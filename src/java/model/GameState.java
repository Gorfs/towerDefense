package model;

import config.*;
import gui.Game;
import gui.TermGameOver;
import gui.TermGame;
import gui.TermPrepMenu;
import main.TermMain;
import misc.Debug;
import model.monster.MonsterAdvanced;
import model.monster.MonsterBasic;
import model.monster.MonsterExpert;
import model.monster.Monsters;
import model.tower.Towers;

import java.util.ArrayList;
import java.io.*;

public class GameState {
    private static boolean graphicVersion = false;
    private static double gameSpeed = 2;
    private static int level = -1;
    public static int money = Player.INSTANCE.getMoney();
    private static int wave = 1; // -1 means that the game is in preperation phase
    private static int[] waveInfo = new int[2]; // [0] is the amount of enemys, [1] is the speed at which they spawn
    private static String waveString = "";
    private static boolean spawning = false; // true if the game is currently spawning monsters
    private static int updateOfLastSpawn = 0;
    private static int monstersLeftToSpawn = 0; // the amount of monsters left to spawn in the current wave
    private static boolean isMarathon = false;
    private static int updateToStartNextWave = 0;
    private static double difficulty = 0.1;
    private static Path initPath;

    private static boolean running = false;
    public static boolean hasAlreadyStarted = false;

    private static int marathonEnemiesToSpawn = 10;
    private static int marathonEnemiesWaves = 1;

    public static String infoString = "Preperation Phase"; // the string that is displayed above the map.

    private static ArrayList<Monsters> monstersToRemoveNextUpdate = new ArrayList<>();
    static Cell[][] gameMap = Map.getMap();
    private static final ArrayList<Monsters> monsters = new ArrayList<>();
    private static final ArrayList<Slot> towers = new ArrayList<>();

    /**
     * @return boolean
     */
    // once per second is the maximum speed possible.

    public static boolean getHasAlreadyStarted() {
        return hasAlreadyStarted;
    }

    /**
     * @param b
     */
    public static void setRunning(boolean b) {
        running = b;
    }

    /**
     * @return boolean
     */
    public static boolean getRunning() {
        return running;
    }

    /**
     * @return ArrayList<Monsters>
     */
    public static ArrayList<Monsters> getMonsters() {
        return monsters;
    }

    /**
     * @return ArrayList<Slot>
     */
    public static ArrayList<Slot> getTowers() {
        return towers;
    }

    /**
     * @return Cell[][]
     */
    public static Cell[][] getMap() {
        return gameMap;
    }

    /**
     * @param marathon
     */
    // once per second is the maximum speed possible.

    public static void setMarathon(boolean marathon) {
        isMarathon = marathon;
    }

    /**
     * @return boolean
     */
    public static boolean getMarathon() {
        return isMarathon;
    }

    /**
     * @return boolean
     */
    public static boolean isSpawning() {
        return spawning;
    }

    public static void getWaveInfo() {
        String e = "";
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(("src/resources/mapInfo/level" + level + ".txt")));
            while ((e = reader.readLine()) != null) {
                waveString = e;
            }
            reader.close();
            if (waveString == "") {
                isMarathon = true;
            }
        } catch (IOException er) {
            System.out.println("ERROR -> could not find file for level " + level);
            er.printStackTrace();
        }
    }

    public static void resetGame() {
        System.out.println("aaaaaaa");
        Player.INSTANCE.resetPlayer();
        TermMain.log.resetLog();
        monstersToRemoveNextUpdate.addAll(monsters);
        for (var tower : towers)
            tower.removeTower();
        towers.clear();
        wave = 0;
    }

    public static void win() {
        resetGame();
        if (graphicVersion) {
            if (Game.running) {
                Game.changePanel("won");
                Game.running = false;
            } else {
                TermGame.pause();
            }
        } else {
            TermGameOver.termGameOver(true);
        }
    }

    public static void lose() {
        resetGame();
        if (graphicVersion) {
            if (Game.running) {
                Game.changePanel("lost");
                Game.running = false;
            }
        } else {
            TermGame.unpause();
            TermGameOver.termGameOver(false);
        }
    }

    /**
     * @return int
     */
    public static int getWave() {
        return wave;
    }

    /**
     * @return boolean
     */
    public static boolean updateWaveInfo() {
        getWaveInfo();
        if (isMarathon) {
            waveInfo[0] = marathonEnemiesToSpawn + (marathonEnemiesWaves * 2);
            waveInfo[1] = 1;
            monstersLeftToSpawn = waveInfo[0];
            return false;

        } else {
            try {
                if (waveString.split(";").length < wave) {
                    win();
                    return true;
                } else {
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
                return true;

            }
        }

    }

    /**
     * @param tower
     * @param x
     * @param y
     */
    public static void addTower(Towers tower, int x, int y) {
        if (gameMap[y][x] instanceof Slot && (!towers.contains(gameMap[y][x]))) {
            ((Slot) gameMap[y][x]).setTower(tower);
            towers.add((Slot) gameMap[y][x]);
            Player.INSTANCE.removeMoney(tower.getCost());
            Debug.out("Tower added, money is now " + Player.INSTANCE.getMoney());
        } else {
            System.out.println("ERROR -> tried to add a model.tower to a non slot tile");
        }
    }

    /**
     * @param x
     * @param y
     */
    public static void removeTower(int x, int y) {
        if (gameMap[y][x] instanceof Slot) {
            Towers tower = ((Slot) gameMap[y][x]).getTower();
            ((Slot) gameMap[y][x]).removeTower();
            towers.remove((Slot) gameMap[y][x]);
            Player.INSTANCE.updateMoney(tower.getCost());
            Debug.out("Tower removed, money is now " + Player.INSTANCE.getMoney());
        } else {
            System.out.println("ERROR -> tried to remove a model.tower from a non slot tile");
        }
    }

    /**
     * @param levelChoice
     */
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

    /**
     * @param monsters
     */
    public static void spawnMonster(Monsters monsters) {

        if (initPath.isEmpty()) {
            initPath.setMonster(monsters);
            GameState.monsters.add(monsters);
        } else {
            Debug.out("Error, spawn path not empty when monster was spawned");
        }
    }

    public static void waveEnded() {
        if (isMarathon) {
            marathonEnemiesWaves++;
            setRunning(false);
            updateWaveInfo();
            difficulty += 0.1;
        } else {
            if (wave == -1) {
                wave = 0;
            }
            spawning = false;
            if (wave > waveString.split(";").length) {
                win();
            } else {
                wave++;
                Player.INSTANCE.updateWave(wave);
            }
            updateWaveInfo();
        }
        spawning = false;
        if (wave > waveString.split(";").length) {
            win();
        } else {
            pauseGame();
            updateWaveInfo();
            if (TermGame.getRunning()) {
                TermGame.pause();
                TermPrepMenu.startPreparationPhase();
                // TermGame.run();
                TermGame.unpause();
            } else {
                if (graphicVersion)
                    Game.running = false;
                infoString = "Wave " + wave + " has ended, Press the play button to start the next wave.";
            }
            restartGame();

        }
    }

    public static void pauseGame() {
        running = false;
    }

    public static void restartGame() {
        running = true;
        spawning = true;
    }

    /**
     * @param timesUpdated
     */
    public static void updateGameState(int timesUpdated) {
        // every time this function is called it is considered that one frame has passed
        // since the last update
        // Debug.out(towers.toString());

        if (!isMarathon) {
            infoString = "wave " + wave + " / " + waveString.split(";").length;
        } else {
            infoString = "Marathon wave " + marathonEnemiesWaves;
        }

        hasAlreadyStarted = true;
        // Choosing next monster to spawn randomly

        if (running) {
            Debug.out("" + Player.INSTANCE.getHealth()[0]);
            Debug.out("" + Player.INSTANCE.getMoney());
            Debug.out("wave = " + wave);
            Debug.out("currentupdate = " + timesUpdated + " update to start next wave = " + updateToStartNextWave);
            Debug.out("waveString = " + waveString.split(";").length + " str = " + waveString);
            Monsters monster;
            double choiceNum = Math.random() * difficulty;
            if (choiceNum > 1)
                choiceNum = 1;
            double choice = 1 + 2 * (choiceNum);
            int choice2 = Math.round((float) choice);
            switch (choice2) {
                case 1:
                    monster = new MonsterBasic(initPath);
                    break;
                case 2:
                    monster = new MonsterAdvanced(initPath);
                    break;
                default:
                    monster = new MonsterExpert(initPath);
                    break;
            }
            if (updateToStartNextWave <= timesUpdated && updateToStartNextWave != -1) {
                if (updateWaveInfo()) {
                    Debug.out("Game won");

                }
                spawning = true;
                updateToStartNextWave = -1;
            }
            if (monstersLeftToSpawn > 0 && spawning
                    && (updateOfLastSpawn + ((30 / gameSpeed) * 2 * waveInfo[1])) < timesUpdated) {

                spawnMonster(monster);
                monstersLeftToSpawn--;
                updateOfLastSpawn = timesUpdated;

            }
            if (monsters.isEmpty() && monstersLeftToSpawn == 0 && spawning) {
                waveEnded();
                updateToStartNextWave = ((int) Math.floor(timesUpdated + (3 * 2 * (30 / gameSpeed))));
            }
            monstersToRemoveNextUpdate = new ArrayList<>();
            if (timesUpdated % (15 / gameSpeed) == 0 && timesUpdated > 1) { // game speed is divided to basically invert
                                                                            // the
                                                                            // factor that multiplies the framerate
                for (Monsters monsters : GameState.monsters) {

                    for (Slot slot : towers) {
                        if (slot.getTower().IsInRange(monsters.getPos(), 1)) {
                            String towerString = slot.toString().substring(0,slot.toString().length()-1);
                            String monsterString = monsters.toString().substring(0,monsters.toString().length()-1);
                            TermMain.log.addLog(towerString + "->" + monsterString + "-" + slot.getTower().getAttack(1) + " |");
                            Debug.out("monster in range" + monsters.getPos().x + " " + monsters.getPos().y + " "
                                    + slot.getX() + " " + slot.getY());
                            if (monsters.takeDamage(slot.getTower().getAttack(1))) {
                                monstersToRemoveNextUpdate.add(monsters);
                                TermMain.log.addLog(monsters + "died   |");
                                TermMain.log.addLog("+10$      |");
                            }
                        }
                    }
                    if (monsters.move()) { // is true if the enemy has made it to the end of the map
                        monstersToRemoveNextUpdate.add(monsters);
                        Player.INSTANCE.takeDamage(monsters.getAttack());
                    }
                }
                // we cannot modify the arrayList while we are reading it, so we store the
                // information in another list to remove them once the main loop has finished.
                for (Monsters monsters : monstersToRemoveNextUpdate) {
                    monsters.getPath().removeMonster();
                    GameState.monsters.remove(monsters);
                }
            }
        } else {
            Debug.out("GameState is not updated.");
        }
    }

    /**
     * @param graphicVersion
     */
    public static void setGraphicVersion(boolean graphicVersion) {
        GameState.graphicVersion = graphicVersion;
    }
}
