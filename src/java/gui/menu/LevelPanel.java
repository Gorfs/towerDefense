package gui.menu;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LevelPanel extends JPanel{
    

    private JLabel levelName;
    public JButton playBtn = new JButton();
    public LevelPanel(int num) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(MainMenu.backgroundColor);

        levelName = new JLabel("Level " + num);
        levelName.setFont(levelName.getFont().deriveFont(20.0f));
        playBtn.setBackground(MainMenu.buttonBackgroundColor);
        playBtn.setText("Play");
        playBtn.setForeground(Color.white);
        playBtn.setFocusPainted(false);
        playBtn.setMaximumSize(new Dimension(100, 30));


        this.add(levelName);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(playBtn);
    }

}
