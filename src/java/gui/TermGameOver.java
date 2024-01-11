package gui;

import java.util.Locale;
import java.util.Scanner;

public class TermGameOver {
    private static final Scanner sc = new Scanner(System.in);
    public static void termGameOver(boolean win) {
        TermMainMenu.clearScreen();
        TermGame.setRunning(false);

        if (win) {
            System.out.println(
                    "                                            \n" +
                    "                                            \n" +
                    "                                            \n" +
                    "                                            \n" +
                    "8b      db      d8  ,adPPYba,  8b,dPPYba,   \n" +
                    "`8b    d88b    d8' a8\"     \"8a 88P'   `\"8a  \n" +
                    " `8b  d8'`8b  d8'  8b       d8 88       88  \n" +
                    "  `8bd8'  `8bd8'   \"8a,   ,a8\" 88       88  \n" +
                    "    YP      YP      `\"YbbdP\"'  88       88  ");
        } else {
            System.out.println(
                    "                                  \n" +
                    "88                                \n" +
                    "88                         ,d     \n" +
                    "88                         88     \n" +
                    "88  ,adPPYba,  ,adPPYba, MM88MMM  \n" +
                    "88 a8\"     \"8a I8[    \"\"   88     \n" +
                    "88 8b       d8  `\"Y8ba,    88     \n" +
                    "88 \"8a,   ,a8\" aa    ]8I   88,    \n" +
                    "88  `\"YbbdP\"'  `\"YbbdP\"'   \"Y888  ");
        }
        System.out.println("\n\nWhat would you like to do?\n\n");
        System.out.println("M: Main Menu\nQ: Quit\n");
        String choice = sc.next();
        TermMainMenu.clearScreen();
        switch (choice.toUpperCase(Locale.ROOT)) {
            case "M": {
                TermMainMenu.runTermMainMenu();
                break;
            }
            case "Q": {
                System.exit(0);
                break;
            }
            default: {
                TermGameOver.termGameOver(win);
                break;
            }
        }
    }
}
