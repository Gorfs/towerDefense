package model;
import config.*;
import geometry.RealCoordinates;
import misc.Debug;
import java.util.ArrayList;

public class GameState {
    private static int timesUpdated = 0;
    static Cell[][] gameMap = Map.getMap();
    private static ArrayList<Monster> monsters = new ArrayList<>();
    private static Path initPath;
    

    public static void initGameState(int level){
        Map.generateMap(level);
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
            spawnMonster(new Monster(new RealCoordinates(initPath.getX(), initPath.getY()), 2, 1, 2));
        }     
    }
  
}
