package gui;

import model.GameState;
import config.*;
import model.Player;

public class TermGame {
    private static Cell[][] map;
    public static void runGame(int level) {
        // Create a Scanner object
        GameState.initGameState(level);
        map = GameState.getMap();
        printMap();
    }

    public static void printMap() {
        String[] display = new String[17];
        display[0] = "+--------------------------------------------+-------------------+";
        // Update health percentage
        float healthPercent = (float) 85L
                / Player.INSTANCE.getHealth()[1] * 100;
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
        // TODO: Change the money, the wave and the timer.
        String money = "|     Money : 10$      ";
        String wave = "|      Wave n°2       ";
        String timer = "|       00:10       |";
        display[2] = money + wave + timer;
        display[3] = "+---+----------------------------------------+-------------------+";
        display[4] = "|///|  A  B  C  D  E  F  G  H  I  J  K  L  M | ";
        display[5] = "+---+----------------------------------------+ ";
        display[16] = display[3];

        for (int x = 0; x < Map.getHeight(); x++) {
            if (x >= 9) display[x + 6] = ("|" + (x + 1) + " | ");
            else display[x + 6] = ("| " + (x + 1) + " | ");
            for (int y = 0; y < Map.getWidth(); y++)
                display[x + 6] = display[x + 6] + Map.getCell(x, y) + " ";
            display[x + 6] = display[x + 6] + "| ";
        }

        for (var line: display) System.out.println(line);
    }


    public Cell[][] getMap() {
        return map;
    }
}
