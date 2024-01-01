package gui;

import javax.swing.*;
import java.awt.CardLayout;

import gui.menu.*;
import misc.Debug;

public class Game {
    
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;


    private static GamePanel gamePanel;
    private static GameWindow gameWindow;
    private static boolean running = false;

    private static CardLayout cardLayout = new CardLayout();
    private static JPanel mainPanel = new JPanel(cardLayout);

    private static MainMenu mainMenu = new MainMenu();
    private static LevelSelectMenu levelMenu = new LevelSelectMenu();
    private static SettingsMenu settingsMenu = new SettingsMenu();
    // TODO: add the initiliazer for the other menus as well as the game panel.


    public Game() {
        gameWindow = new GameWindow();
        gameWindow.add(mainPanel);
        mainPanel.add(mainMenu, "main");
        mainPanel.add(levelMenu, "level");
        mainPanel.add(settingsMenu, "settings");
        
        gameWindow.setVisible(true);
    }

    public static void changePanel(String panelName) {
        Debug.out("Changing panel to " + panelName);
        switch(panelName) {
            case "main":
                cardLayout.show(mainPanel, "main");
                break;
            case "settings":
                cardLayout.show(mainPanel, "settings");
                break;
            case "level":
                cardLayout.show(mainPanel, "level");
                break;
            default:
                System.out.println("Error: panelName not found");
        }
    }
}