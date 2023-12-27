package gui;

import model.GameState;
import config.*;
import main.TermMain;
import misc.*;

import model.Towers;
import java.util.ArrayList;

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
        // Scanner myObj = new Scanner(System.in);
        // System.out.println("file name :");

        // String filename = myObj.nextLine();
        
        GameState.initGameState(level);
        map = GameState.getMap();
        TermMainMenu.clearScreen();
        TermPrepMenu.startPreparationPhase();
        TermMainMenu.clearScreen();
        run();
        
        // Debug.printMap(map);

    }

    public static void printMap() {
        printMap("");
    }
        
    public static void printMap(String str){
        System.out.println(str);
        for (int x = 0; x < Map.getHeight(); x++) {
            for (int y = 0; y < Map.getWidth(); y++)
                System.out.print(Map.getCell(x, y));
            System.out.println();
        }
    }
    


    public Cell[][] getMap() {
        return map;
    }


    public static void animate(){
        // this is where our main animation cycle is going to be...
        // TODO create a function in GameState that updates the gameState
        TermMainMenu.clearScreen();
        printMap();
        System.out.println("fps -> " + 1.0f/(timeElapsedSinceLastUpdate*1E-9));
    }


    public static void run(){
            isRunning = true;
            long priorTime = System.nanoTime();
            while(isRunning){
                if(System.nanoTime() - priorTime > 16600000){
                    // 1/60th of a second has passed, updating gameView
                    timeElapsedSinceLastUpdate = (System.nanoTime()) - priorTime; 
                    updates++;
                    priorTime = System.nanoTime();
                    animate();
                }
            }
            
        }

}
