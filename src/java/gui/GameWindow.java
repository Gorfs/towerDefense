package gui;

import javax.swing.JFrame;

public class GameWindow{
    private static JFrame root;


    public GameWindow(Game game) {
        root = new JFrame("Tower Defense");
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setResizable(false);
        root.add(game);
        root.setLocationRelativeTo(null);
        root.pack();
        root.setVisible(true);
    
    }
}
