package gui;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
  
    public GameWindow() {
        super("Tower Defense");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
