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
        // Initialize money
        String money = "|     Money : " + Player.INSTANCE.getMoney() + "$       ";
        // Initialize timer
        String timer = "|       " + Player.INSTANCE.getTimer() + "       |";
        // Initialize wave
        StringBuilder wave = new StringBuilder("|      Wave n°");
        if (Player.INSTANCE.getWave() < 1000) wave.append(Player.INSTANCE.getWave());
        else wave.append("999");
        int n;
        if (Player.INSTANCE.getWave() < 10) n = 7; else if (Player.INSTANCE.getWave() < 100) n = 6; else n = 5;
        wave.append(" ".repeat(n));
        // Display everything
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
