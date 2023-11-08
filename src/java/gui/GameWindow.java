package gui;

import javax.swing.JFrame;

public class GameWindow {
    private JFrame jFrame;
    public GameWindow(GamePanel gamePanel) {
        jFrame = new JFrame();
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
    }
}
