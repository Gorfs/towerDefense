package gui;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
  
    public GameWindow() {
        super("Tower Defense");
        this.setSize(Game.WIDTH, Game.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
