package gui;

import model.*;
import config.*;
import main.TermMain;
import misc.*;

import model.Towers;
import java.util.ArrayList;
import model.Player;

public class TermGame {
    private static int updates = 0;
    private static Cell[][] map;
    public static ArrayList<Towers> towers = new ArrayList<>();
    private static boolean isRunning = false;
    private static long startTime = System.nanoTime();
    private static long timeElapsedSinceLastUpdate = 10000; // is in nanoseconds, +1 to avoid division by zero errors

    public int getUpdates() {
        return updates;
    }

    public static void runGame(int level) {
        // Create a Scanner object
        GameState.initGameState(level);
        map = GameState.getMap();
        TermMainMenu.clearScreen();
        TermPrepMenu.startPreparationPhase();
        TermMainMenu.clearScreen();
        run();

        // Debug.printMap(map);

    }

    public static void printMap() {
        String[] display = new String[17];
        display[0] = "+--------------------------------------------+-------------------+";
        // Update health percentage
        float healthPercent = (float) Player.INSTANCE.getHealth()[1] / Player.INSTANCE.getHealth()[0] * 100;
        String HPPercent;
        if (healthPercent < 100.0f) HPPercent = " " + healthPercent;
        else HPPercent = "" + healthPercent;
        // Update health bar
        StringBuilder HPBar = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (i * 10 < healthPercent - 5) HPBar.append("#");
            else HPBar.append(".");
        }
        display[1] = String.format("|         HP   [%s]   %s", HPBar, HPPercent) + "%         |      Timer :      |";
        int n;
        // Initialize money
        StringBuilder money = new StringBuilder("|     Money : " + Player.INSTANCE.getMoney() + "$");
        if (Player.INSTANCE.getMoney() < 10) n = 7;
        else if (Player.INSTANCE.getMoney() < 100) n = 6;
        else if (Player.INSTANCE.getMoney() < 1000) n = 5;
        else n = 4;
        money.append(" ".repeat(n));

        // Initialize timer
        String timer = "|       " + Player.INSTANCE.getTimer() + "       |";
        // Initialize wave
        StringBuilder wave = new StringBuilder("|      Wave n°");
        if (GameState.getWave() < 1000) wave.append(GameState.getWave());
        else wave.append("999");
        if (GameState.getWave() < 10) n = 7; else if (GameState.getWave() < 100) n = 6; else n = 5;
        wave.append(" ".repeat(n));
        // Display everything
        display[2] = String.format("%s%s%s", money, wave, timer);
        display[3] = "+---+----------------------------------------+-------------------+";
        display[4] = "|///|  1  2  3  4  5  6  7  8  9 10 11 12 13 | ";
        display[5] = "+---+----------------------------------------+ ";
        display[16] = display[3];

        char[] chara = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'};
        for (int x = 0; x < Map.getHeight(); x++) {
            display[x + 6] = ("| " + chara[x] + " | ");
            for (int y = 0; y < Map.getWidth(); y++)
                display[x + 6] = display[x + 6] + Map.getCell(x, y);
            display[x + 6] = display[x + 6] + "| ";
        }

        for (var line: display) System.out.println(line);
    }


    public Cell[][] getMap() {
        return map;
    }


    public static void animate(){
        // this is where our main animation cycle is going to be...
        // TODO create a function in GameState that updates the gameState
        TermMainMenu.clearScreen();
        GameState.updateGameState(updates);
        printMap();
        System.out.println("fps -> " + 1.0f/(timeElapsedSinceLastUpdate*1E-9));
        if (Player.INSTANCE.getHealth()[1] <= 0) {
            System.out.println("Game lost");
            isRunning = false;
        }

        //!! This is all just Debug code for the terminal version of the game.

        // ArrayList<Monster> monsters = GameState.getMonsters();
        // ArrayList<Slot> towers = GameState.getTowers();
        // for(Monster monster : monsters){
        //     System.out.println(monster.getId() + " health:"  + monster.getHealth()[0] + " position : " + monster.getPos().x + " " + monster.getPos().y);
        // }
        // for(Slot tower : towers){
        //     // TODO, change damage factor to variable rather than just 1
        //     System.out.println(tower.toString() + " position : " + tower.getX() + " " + tower.getY() + " range :" + tower.getTower().getRange(1));
        // }
        // for(Monster monster: monsters){
        //     for(Slot tower: towers){
        //         System.out.println("monster " + monster.getId() + " range status to : x: " + tower.getX() + " y:" + tower.getY() + " is "
        //         + tower.getTower().IsInRange(monster.getPos(), 1) + " distance to tower is ="
        //         + tower.getTower().getDistance(monster.getPos()));
        //     }
        // }
        
    }


    public static void run(){
        // we assume the main menu and the preperation phase a finished, this is the main game loop for gameplay
            isRunning = true;
            long priorTime = System.nanoTime();
            while(isRunning){
                if(System.nanoTime() - priorTime > 16600000){
                    // 1/60th of a second has passed, updating gameView
                    timeElapsedSinceLastUpdate = (System.nanoTime()) - priorTime;
                    Player.INSTANCE.updateTimer(timeElapsedSinceLastUpdate);
                    updates++;
                    priorTime = System.nanoTime();
                    animate();
                }
            }

        }

}
