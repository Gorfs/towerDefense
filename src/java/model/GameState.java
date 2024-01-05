package model;

import config.*;
import geometry.RealCoordinates;
import misc.Debug;
import java.util.ArrayList;
import java.io.*;

public class GameState {
    private static int timesMonstersMoved = 0;
    private static double gameSpeed = 2;
    private static int level = -1;
    public static int money = Player.INSTANCE.getMoney();
    private static int wave = 1; // -1 means that the game is in preperation phase
    private static int[] waveInfo = new int[2]; // [0] is the amount of enemys, [1] is the speed at which they spawn
    private static String waveString = "";
    private static boolean spawning = false; // true if the game is currently spawning monsters
    private static int updateOfLastSpawn = 0;
    private static int monstersLeftToSpawn = 0; // the amount of monsters left to spawn in the current wave
    private static int updateToStartNextWave = 0;
    // once per second is the maximum speed possible.

    public static void getWaveInfo() {
        String e = "";
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(("src/resources/mapInfo/level" + level + ".txt")));
            while ((e = reader.readLine()) != null) {
                waveString = e;
            }
        } catch (IOException er) {
            System.out.println("ERROR -> could not find file for level " + level);
            er.printStackTrace();
        }
    }

    public static void win() {
        System.out.println("Game won");
        // TODO make this have a winning screen and go back to the main menu
        System.exit(0);
    }

    public static boolean updateWaveInfo() {
        try {
            if (waveString.split(";").length < wave) {
                win();
                return true;
            } else {
                getWaveInfo();
                String str = "";
                if (waveString.split(";").length == 0) {
                    str = waveString;
                } else {
                    str = waveString.split(";")[wave - 1];
                }
                int enemyCount = Integer.parseInt(str.split(",")[0]);
                int enemySpeed = Integer.parseInt(str.split(",")[1]);
                waveInfo[0] = enemyCount;
                waveInfo[1] = enemySpeed;
                monstersLeftToSpawn = enemyCount;
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // the game has been won
            // TODO make this have a winning screen and go back to the main menu
            return true;

        }

    }

    public static int getWave() {
        return wave;
    }

    private static ArrayList<Monster> monstersToRemoveNextUpdate = new ArrayList<>();

    static Cell[][] gameMap = Map.getMap();
    private static final ArrayList<Monster> monsters = new ArrayList<>();
    private static final ArrayList<Slot> towers = new ArrayList<>();

    public static void addTower(Towers tower, int x, int y) {
        if (gameMap[y][x] instanceof Slot && (!towers.contains(gameMap[y][x]))) {
            ((Slot) gameMap[y][x]).setTower(tower);
            towers.add((Slot) gameMap[y][x]);
            Player.INSTANCE.removeMoney(tower.getCost());
            Debug.out("Tower added, money is now " + Player.INSTANCE.getMoney());
        } else {
            System.out.println("ERROR -> tried to add a tower to a non slot tile");
        }

    }

    public static void removeTower(int x, int y) {
        if (gameMap[y][x] instanceof Slot) {
            Towers tower = ((Slot) gameMap[y][x]).getTower();
            ((Slot) gameMap[y][x]).removeTower();
            towers.remove((Slot) gameMap[y][x]);
            Player.INSTANCE.updateMoney(tower.getCost());
            Debug.out("Tower removed, money is now " + Player.INSTANCE.getMoney());
        } else {
            System.out.println("ERROR -> tried to remove a tower from a non slot tile");
        }
    }

    private static Path initPath;

    public static void initGameState(int levelChoice) {
        Map.generateMap(levelChoice);
        level = levelChoice;
        updateWaveInfo();
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

    public static void waveEnded() {
        if (wave == -1) {
            wave = 0;
        }
        spawning = false;
        if(wave + 1 > waveString.split(";").length){
            win();
        }else{
            wave++;
        }
    }

    public static void updateGameState(int timesUpdated) {
        // every time this function is called it is considered that one frame has passed
        // since the last update
        // Debug.out(towers.toString());
        Debug.out("" + Player.INSTANCE.getHealth()[0]);
        Debug.out("" + Player.INSTANCE.getMoney());
        Debug.out("wave = " + wave);
        Debug.out("currentupdate = " + timesUpdated + " update to start next wave = " + updateToStartNextWave);
        Debug.out("waveString = " + waveString.split(";").length + " str = " + waveString);
        if (updateToStartNextWave <= timesUpdated && updateToStartNextWave != -1) {
            if (updateWaveInfo()) {
                Debug.out("Game won");
                
            }
            spawning = true;
            updateToStartNextWave = -1;
        }
        if (monstersLeftToSpawn > 0 && spawning
                && (updateOfLastSpawn + ((30 / gameSpeed) * 2 * waveInfo[1])) < timesUpdated) {
            spawnMonster(new Monster(initPath, 10, 1, 100));
            monstersLeftToSpawn--;
            updateOfLastSpawn = timesUpdated;

        }
        if (monsters.size() == 0 && monstersLeftToSpawn == 0 && spawning) {
            waveEnded();
            updateToStartNextWave = ((int) Math.floor(timesUpdated + (3 * 2 * (30 / gameSpeed)))); // TODO set the 5 as
                                                                                                   // the time in
                                                                                                   // seconds
                                                                                                   // between waves
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
                    Player.INSTANCE.takeDamage(monster.getAttack());
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
