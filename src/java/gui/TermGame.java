package gui;

import model.GameState;
import config.*;
import misc.*;

import java.util.Scanner;

public class TermGame {
    private static int updates = 0;
    private static Cell[][] map;
    private static boolean isRunning = false;
    private static long startTime = System.nanoTime();
    private static long timeElapsed = 10000; // is in nanoseconds, +1 to avoid division by zero errors
    private static int deltaUpdates = 0;


    public static void runGame(int level) {
        // Create a Scanner object
        // Scanner myObj = new Scanner(System.in);
        // System.out.println("file name :");

        // String filename = myObj.nextLine();
        
        GameState.initGameState(level);
        map = GameState.getMap();
        printMap();
        run();
        
        // Debug.printMap(map);

    }

    public static void printMap() {
        Print.clearScreen();
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
        printMap();
    }

    
    public static void run(){
            isRunning = true;
            long priorTime = System.nanoTime();
            while(isRunning){
                if(System.nanoTime() - priorTime > 16600000){
                    // 1/60th of a second has passed, updating gameView
                    priorTime = System.nanoTime();
                    timeElapsed = (System.nanoTime()) + 1 - startTime; 
                    updates++;
                    animate();
                }
            }
            
        }

}
