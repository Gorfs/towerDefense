package gui;

import javax.swing.*;

public class Game {
    private GamePanel gamePanel;
    private GameWindow gameWindow;

    public Game() {
        gameWindow = new GameWindow();
        JButton btn = new JButton("Click me!");
        gameWindow.getContentPane().add(btn);
        gameWindow.setVisible(true);
    }

    public static void main(String[] args){
        Game game = new Game();
    }
}
