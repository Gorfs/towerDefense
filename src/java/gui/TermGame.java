package gui;

import model.GameState;
import config.*;
import misc.Debug;

import java.util.Scanner;

public class TermGame {
    private static int updates = 0;
    private static Cell[][] map;
    private static boolean isRunning = false;
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
        System.out.println(updates);

    }
    public static void run(){
            isRunning = true;
            long priorTime = System.nanoTime();
            while(System.nanoTime() - priorTime < 1660000){
                updates++;
                animate();
                if(isRunning){priorTime = System.nanoTime();}
            }
            
        }

}
