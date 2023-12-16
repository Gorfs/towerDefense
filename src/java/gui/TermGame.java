package gui;

import model.GameState;
import config.*;

public class TermGame {
    private static Cell[][] map;
    public static void runGame(int level) {
        // Create a Scanner object
        GameState.initGameState(level);
        map = GameState.getMap();
        printMap();
    }

    public static void printMap() {
        String[] display = new String[16];
        display[0] = "+--------------------------------------------+-------------------+";
        // TODO: Change the health bar and percentage once player class is added.
        display[1] = "|           HP   [########..]   100%         |      Timer :      |";
        // TODO: Same for the money, the wave and the timer.
        display[2] = "|     Money : 10$      |      Wave n°2       |       00:10       |";
        display[3] = "+---+----------------------------------------+-------------------+";
        display[4] = "|///|  A  B  C  D  E  F  G  H  I  J  K  L  M | ";
        display[15] = display[3];


        for (int x = 0; x < Map.getHeight(); x++) {
            if (x >= 9) display[x + 5] = ("|" + (x + 1) + " | ");
            else display[x + 5] = ("| " + (x + 1) + " | ");
            for (int y = 0; y < Map.getWidth(); y++)
                display[x + 5] = display[x + 5] + Map.getCell(x, y) + " ";
            display[x + 5] = display[x + 5] + "| ";
        }

        for (var line: display) System.out.println(line);
    }


    public Cell[][] getMap() {
        return map;
    }
}
