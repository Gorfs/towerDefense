package gui;

import javax.swing.*;
import java.awt.CardLayout;

import gui.gameUI.GamePanel;
import gui.menu.*;
import misc.Debug;
import model.*;
import config.*;

public class Game {
    

    public static final int WIDTH = 1101;
    public static final int HEIGHT = 800;

    private static Cell[][] map;

    public static boolean running = false;
    public static boolean isPreperationPhase = false;

    private static CardLayout cardLayout = new CardLayout();
    private static JPanel mainPanel = new JPanel(cardLayout);

    private static GameWindow gameWindow = new GameWindow();
    private static MainMenu mainMenu = new MainMenu();
    private static LevelSelectMenu levelMenu = new LevelSelectMenu();
    private static SettingsMenu settingsMenu = new SettingsMenu();

    private static GamePanel gamePanel = new GamePanel();

    public static int levelSelect;

    public static int updates = 0;

    

    public Game() {
        gameWindow = new GameWindow();
        gameWindow.add(mainPanel);
        mainPanel.add(mainMenu, "main");
        mainPanel.add(levelMenu, "level");
        mainPanel.add(settingsMenu, "settings");
        mainPanel.add(gamePanel, "game");
        
        gameWindow.setVisible(true);
    }
    public static void setlevel(int n){
        levelSelect = n;
    }
    public static int getLevel(){
        return levelSelect;
    }

    public static void startRound(){
        running = true;
        gameLoop();
    }

    public static void start(){
        GameState.initGameState(levelSelect);
        map = GameState.getMap();
        updateGUI();
        // TODO setup preperation phase then moving to game phase
        // TODO setup going back to main menu after loosing of winning a round.
    }

    public static void updateGUI(){
        gamePanel.update();
        //!!  The line under this comment somehow fixes a load of graphical bugs, do not remove.
        gameWindow.validate();
    }

    public static void gameLoop(){
        //!! do not remove thread, the gameloop needs to run on a different thread to the rest of the application
        new Thread(()->{
            long priorTime = System.nanoTime();
            while(running){
                if(System.nanoTime() - priorTime > 16600000){
                    // 1/60th of a second has passed, updating gameView
                    updates++;
                    Debug.out("fps -> " + 1.0f/((System.nanoTime() - priorTime)*1E-9)); 
                    priorTime = System.nanoTime();
                    GameState.updateGameState(updates);
                    updateGUI();
                }
            }
        }).start();
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
            case "game":
                cardLayout.show(mainPanel, "game");
                isPreperationPhase = true;
                break;
            default:
                System.out.println("Error: panelName not found");
        }
        updateGUI();
    }
}