package gui;

import javax.swing.*;
import java.awt.CardLayout;

import gui.gameUI.GamePanel;
import gui.gameUI.Tile;
import gui.menu.*;
import misc.Debug;
import model.*;

public class Game {
    

    public static final int WIDTH = 1101;
    public static final int HEIGHT = 800;

    public static boolean running = false;
    public static boolean isPreparationPhase = false;

    private static final CardLayout cardLayout = new CardLayout();
    private static final JPanel mainPanel = new JPanel(cardLayout);

    private static GameWindow gameWindow = new GameWindow();
    private static final MainMenu mainMenu = new MainMenu();
    private static final LevelSelectMenu levelMenu = new LevelSelectMenu();
    private static final SettingsMenu settingsMenu = new SettingsMenu();

    private static final GamePanel gamePanel = new GamePanel();

    public static int levelSelect;

    public static int updates = 0;

    

    public Game() {
        gameWindow = new GameWindow();
        gameWindow.add(mainPanel);
        mainPanel.add(mainMenu, "main");
        mainPanel.add(levelMenu, "level");
        mainPanel.add(settingsMenu, "settings");
        mainPanel.add(gamePanel, "game");
        mainPanel.add(new GameWonPanel(), "won");
        mainPanel.add(new GameLostPanel(), "lost");
        
        gameWindow.setVisible(true);
    }
    
    /** 
     * @param n level
     */
    public static void setLevel(int n){
        levelSelect = n;
    }
    
    /** 
     * @return int
     */
    public static int getLevel(){
        return levelSelect;
    }

    public static void startRound(){
        running = true;
        gameLoop();
    }

    public static void start(){
        GameState.initGameState(levelSelect);
        Tile.initImages();
        updateGUI();
    }

    public static void updateGUI(){
        gamePanel.update();
        GameState.money = Player.INSTANCE.getMoney();
        //!!  The line under this comment somehow fixes a load of graphical bugs, do not remove.
        gameWindow.validate();
    }

    public static void gameLoop(){
        //!! do not remove thread, the game loop needs to run on a different thread to the rest of the application
        new Thread(()->{
            long priorTime = System.nanoTime();
            while(running){
                if(System.nanoTime() - priorTime > 16600000*2){
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



    
    /** 
     * @param panelName panel name
     */
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
                isPreparationPhase = true;
                break;
            case "lost":
                cardLayout.show(mainPanel, "lost");
                break;
            case "won":
                cardLayout.show(mainPanel, "won");
                break;
            default:
                System.out.println("Error: panelName not found");
        }
        updateGUI();
    }
}