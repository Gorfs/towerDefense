package gui;

import model.GameState;
import config.*;
import misc.Debug;

import java.util.Scanner;

public class TermGame {
    private static Cell[][] map;
    public static void runGame(int level) {
        // Create a Scanner object
        // Scanner myObj = new Scanner(System.in);
        // System.out.println("file name :");

        // String filename = myObj.nextLine();
        
        GameState.initGameState(level);
        map = GameState.getMap();
        printMap();
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
}
