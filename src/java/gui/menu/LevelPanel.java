package gui.menu;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelPanel extends JPanel {

    private JLabel levelName;
    public int levelNum;
    public JButton playBtn = new JButton();
    public JLabel levelWaves = new JLabel("waves -> ");

    public LevelPanel(int num, int waves) {
        super();
        levelNum = num;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(MainMenu.backgroundColor);

        levelName = new JLabel("Level " + num);
        levelName.setFont(levelName.getFont().deriveFont(20.0f));
        playBtn.setBackground(MainMenu.buttonBackgroundColor);
        playBtn.setText("Play");
        playBtn.setForeground(Color.white);
        playBtn.setFocusPainted(false);
        playBtn.setMaximumSize(new Dimension(100, 30));

        if (waves == -1) {
            levelWaves.setText("Marathon mode");
        } else {
            levelWaves.setText("waves -> " + waves);
        }
        levelWaves.setFont(levelWaves.getFont().deriveFont(20.0f));

        this.add(levelName);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(playBtn);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(levelWaves);
    }

    
    /** 
     * @return int
     */
    public int getNum() {
        return levelNum;
    }

}
