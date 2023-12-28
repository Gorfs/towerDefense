package model;
import config.*;
import geometry.RealCoordinates;
import misc.Debug;
import java.util.ArrayList;

public class GameState {
    private static int timesUpdated = 0;
    private static int timesMonstersMoved = 0;
    private static int gameSpeed = 1;

    private static ArrayList<Monster> monstersToRemoveNextUpdate = new ArrayList<>();

    static Cell[][] gameMap = Map.getMap();
    private static ArrayList<Monster> monsters = new ArrayList<>();
    private static ArrayList<Slot> towers = gui.TermPrepMenu.getTowerList();

    private static Path initPath;
    

    public static void initGameState(int level){
        Map.generateMap(level);
        Map.generatePath();
        gameMap = Map.getMap();
        initPath = config.Map.getInitPath();
        // Debug.printMap(gameMap);
        // the amount of life the player has left.
        if (gameMap == null){
            System.out.println(" ERROR -> Game state was loaded before config files, therefore no map was loaded, exiting...");
            System.exit(1);
        }
        //loading path for the monsters
    }



    public static Cell[][] getMap(){
        return gameMap;
    }

    public void addTower(Towers tower, int x, int y){
        if(gameMap[x][y] instanceof Slot){
            ((Slot) gameMap[x][y]).setTower(tower);
        }
        else{
            System.out.println("ERROR -> tried to add a tower to a non slot tile");
        }

    }
    public static void spawnMonster(Monster monster){
        
        if(initPath.isEmpty()){
            initPath.setMonster(monster);
            monsters.add(monster);
        }else{
            Debug.out("Error, spawn path not empty when monster was spawned");
        }
    }

    public static void updateGameState(){  
        // every time this function is called it is considered that one frame has passed since the last update
        timesUpdated++;
        if (timesUpdated == 100){
            spawnMonster(new Monster(initPath, 2, 1, 2));
        }
        monstersToRemoveNextUpdate = new ArrayList<>();
        // TODO make the timer based on difficulty rather then set at once per second
        if(timesUpdated % (30/gameSpeed) == 0 && timesUpdated > 1){ // game speed is devided to basically invert the factor that multiplies the framerate 
            timesMonstersMoved++; // basic stats, not very useful.
            for(Monster monster: monsters){
                for(Slot slot : towers){
                    // TODO set factors to a variable rather than a constant 1.
                    if (slot.getTower().IsInRange(monster.getPos(), 1)){
                        if (monster.takeDamage(slot.getTower().getAttack(1))){
                            monstersToRemoveNextUpdate.add(monster);
                        }
                    } 
                }
                monster.move();
            }
            // we cannot modify the arrayList while we are reading it, so we store the information in another list to remove them once the main loop has finished.
            for(Monster monster: monstersToRemoveNextUpdate){
                monster.getPath().removeMonster();
                monsters.remove(monster);
            }
        }
    }
  
}
