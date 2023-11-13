package gui;

import config.Map;

import java.util.Scanner;

public class TermGame {
    private final Map map = new Map();
    public TermGame() {
        // Create a Scanner object
        Scanner myObj = new Scanner(System.in);
        System.out.println("file name :");

        String filename = myObj.nextLine();
        map.generateMap(filename);
        printMap();

    }

    public void printMap() {
        for (int x = 0; x < map.getHeight(); x++) {
            for (int y = 0; y < map.getWidth(); y++)
                System.out.print(map.getCell(x, y).termPrint());
            System.out.println();
        }
    }


    public Map getMap() {
        return map;
    }
}
