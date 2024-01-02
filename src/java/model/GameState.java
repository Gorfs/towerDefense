package model;

import config.*;
import geometry.RealCoordinates;
import misc.Debug;
import java.util.ArrayList;

public class GameState {
    private static int timesMonstersMoved = 0;
    private static double gameSpeed = 1;
    private static int money = 100;
    private static int lives = 3;

    private static ArrayList<Monster> monstersToRemoveNextUpdate = new ArrayList<>();

    static Cell[][] gameMap = Map.getMap();
    private static ArrayList<Monster> monsters = new ArrayList<>();
    private static ArrayList<Slot> towers = new ArrayList<>();

    public static void addTower(Towers tower, int x, int y) {
        if (gameMap[y][x] instanceof Slot) {
            ((Slot) gameMap[y][x]).setTower(tower);
            towers.add((Slot) gameMap[y][x]);
        } else {
            System.out.println("ERROR -> tried to add a tower to a non slot tile");
        }

    }

    public static void removeTower(int x, int y){
        if (gameMap[y][x] instanceof Slot) {
            ((Slot) gameMap[y][x]).removeTower();
            towers.remove((Slot) gameMap[y][x]);
        } else {
            System.out.println("ERROR -> tried to remove a tower from a non slot tile");
        }
    }

    private static Path initPath;

    public static int getMoney() {
        return money;
    }

    public static int getLives() {
        return lives;
    }

    public static void initGameState(int level) {
        Map.generateMap(level);
        Map.generatePath();
        gameMap = Map.getMap();
        initPath = config.Map.getInitPath();
        // Debug.printMap(gameMap);
        // the amount of life the player has left.
        if (gameMap == null) {
            System.out.println(
                    " ERROR -> Game state was loaded before config files, therefore no map was loaded, exiting...");
            System.exit(1);
        }
        // loading path for the monsters
    }

    public static ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public static ArrayList<Slot> getTowers() {
        return towers;
    }

    public static Cell[][] getMap() {
        return gameMap;
    }

    public static void spawnMonster(Monster monster) {

        if (initPath.isEmpty()) {
            initPath.setMonster(monster);
            monsters.add(monster);
        } else {
            Debug.out("Error, spawn path not empty when monster was spawned");
        }
    }

    public static void updateGameState(int timesUpdated) {
        // every time this function is called it is considered that one frame has passed
        // since the last update
        if (timesUpdated == 100) {
            spawnMonster(new Monster(initPath, 2, 1, 100));
        } else if (timesUpdated == 200) {
            spawnMonster(new Monster(initPath, 2, 1, 50));
        }
        monstersToRemoveNextUpdate = new ArrayList<>();
        // TODO make the timer based on difficulty rather then set at once per second
        if (timesUpdated % (30 / gameSpeed) == 0 && timesUpdated > 1) { // game speed is devided to basically invert the
                                                                        // factor that multiplies the framerate
            timesMonstersMoved++; // basic stats, not very useful.
            for (Monster monster : monsters) {

                for (Slot slot : towers) {
                    // TODO set factors to a variable rather than a constant 1.
                    if (slot.getTower().IsInRange(monster.getPos(), 1)) {
                        if (monster.takeDamage(slot.getTower().getAttack(1))) {
                            monstersToRemoveNextUpdate.add(monster);
                        }
                    }
                }
                if (monster.move()) { // is true if the enemy has made it to the end of the map
                    monstersToRemoveNextUpdate.add(monster);
                    lives--;
                }
            }
            // we cannot modify the arrayList while we are reading it, so we store the
            // information in another list to remove them once the main loop has finished.
            for (Monster monster : monstersToRemoveNextUpdate) {
                monster.getPath().removeMonster();
                monsters.remove(monster);
            }
        }
    }

}
