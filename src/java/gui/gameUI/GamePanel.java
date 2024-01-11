package gui.gameUI;

import javax.swing.*;
import java.awt.*;

import gui.Game;
import gui.menu.MainMenu;
import model.GameState;


public class GamePanel extends JPanel {
    // this panel contains the whole UI for the gameplay part of the Tower Defense
    // game

    private final JLabel title = new JLabel(("Level " + Game.getLevel()), SwingConstants.CENTER);

    // the panel where most of the gamePlay happens
    private final GamePlayPanel gamePlayPanel = new GamePlayPanel();

    public GamePanel() {
        super();
        this.setBackground(MainMenu.backgroundColor);
        this.setLayout(new BorderLayout());

        // this panel contains the shop and the gameplay area
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        title.setFont(title.getFont().deriveFont(30.0f));
        title.setForeground(Color.white);

        gamePlayPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        JButton startRoundBtn = new JButton("Start");
        startRoundBtn.setBackground(MainMenu.buttonBackgroundColor);
        startRoundBtn.setForeground(Color.white);
        startRoundBtn.setFocusPainted(false);
        startRoundBtn.setMaximumSize(new Dimension(100, 30));
        startRoundBtn.addActionListener(e -> {
            if (!Game.running) {
                if (GameState.getHasAlreadyStarted()) {
                    GameState.restartGame();
                }
                Game.startRound();
                Game.isPreparationPhase = false;
                Game.running = true;
                GameState.setRunning(true);
            }
        });

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(MainMenu.backgroundColor);
        centerPanel.add(gamePlayPanel);

        mainPanel.add(centerPanel);
        this.setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));

        this.add(startRoundBtn, BorderLayout.SOUTH);
        this.add(title, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }

    public void update() {
        gamePlayPanel.update();
        this.title.setText("Level " + Game.getLevel());
    }
}
