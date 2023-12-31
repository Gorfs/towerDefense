package gui;

import javax.swing.*;

public class Game {
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;


    private GamePanel gamePanel;
    private GameWindow gameWindow;
    private static boolean running = false;

    public Game() {
        gameWindow = new GameWindow();
        MainMenu mainMenu = new MainMenu();
        gameWindow.add(mainMenu);
        gameWindow.setVisible(true);
    }
}
