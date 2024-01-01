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



    public GamePanel() {
        super();
        this.setBackground(MainMenu.backgroundColor);
        this.setLayout(new BorderLayout());

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        title.setFont(title.getFont().deriveFont(30.0f));
        title.setForeground(Color.white);

        gamePlayPanel.setPreferredSize(new Dimension(1000, 400));
        gamePlayPanel.setBorder(BorderFactory.createLineBorder(Color.black)); // Add border here
        JPanel centerPanel = new JPanel();
        centerPanel.add(gamePlayPanel);
        mainPanel.add(centerPanel);
        centerPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        this.add(title, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
    }
    public void update(){
        gamePlayPanel.update();
    }

    
}
