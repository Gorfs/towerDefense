package gui.gameUI;

import javax.swing.*;

import gui.Game;
import gui.menu.MainMenu;

import java.awt.*;

public class GamePanel extends JPanel {
    // this panel contains the whole UI for the gameplay part of the Tower Defense game

    private JLabel title = new JLabel(("Level " + Game.getLevel()), SwingConstants.CENTER);

    // this panel contains the shop and the gameplay area
    private JPanel mainPanel = new JPanel();

    // the panel where most of the gamePlay happens 
    private GamePlayPanel gamePlayPanel = new GamePlayPanel();


    private JButton startRoundBtn = new JButton("Start");


    public GamePanel() {
        super();
        this.setBackground(MainMenu.backgroundColor);
        this.setLayout(new BorderLayout());

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        title.setFont(title.getFont().deriveFont(30.0f));
        title.setForeground(Color.white);

        // gamePlayPanel.setPreferredSize(new Dimension(1000, 400));
        // gamePlayPanel.setBorder(BorderFactory.createLineBorder(Color.red)); // Add border here
        gamePlayPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        startRoundBtn.setBackground(MainMenu.buttonBackgroundColor);
        startRoundBtn.setForeground(Color.white);
        startRoundBtn.setFocusPainted(false);
        startRoundBtn.setMaximumSize(new Dimension(100, 30));
        startRoundBtn.addActionListener(e -> {
            Game.startRound();
            Game.isPreperationPhase = false;
            Game.running = true;
        });

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(MainMenu.backgroundColor);
        centerPanel.add(gamePlayPanel);

        mainPanel.add(centerPanel);
        this.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
        // centerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        this.add(startRoundBtn, BorderLayout.SOUTH);
        this.add(title, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    public void update(){
        gamePlayPanel.update();
        this.title.setText("Level " + Game.getLevel());
    }

    
}
