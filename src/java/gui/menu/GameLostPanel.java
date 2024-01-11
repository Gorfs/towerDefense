package gui.menu;

import java.awt.Image;

import javax.swing.*;

import gui.Game;
import misc.Debug;
import gui.menu.*;


public class GameLostPanel extends JLabel{

    JButton mainMenButton = new JButton("Main Menu");

    public GameLostPanel() {
        super();
        // making the gameOver screen transparent
        this.setBackground(MainMenu.backgroundColor);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("You lose, try again?", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(40.0f));

        mainMenButton.addActionListener(e -> {
            Game.changePanel("main");
            Debug.out("Game lost , going back to mainMenu");
        });

        mainMenButton.setAlignmentX(CENTER_ALIGNMENT);
        label.setAlignmentX(CENTER_ALIGNMENT);
        label.setOpaque(false);
        mainMenButton.setMaximumSize(new java.awt.Dimension(200, 50));
        mainMenButton.setBackground(gui.menu.MainMenu.buttonBackgroundColor);

        this.add(Box.createRigidArea(new java.awt.Dimension(Game.HEIGHT/3, 200)));
        this.add(label);
        this.add(Box.createRigidArea(new java.awt.Dimension(20, 200)));
        this.add(mainMenButton);
    }
    
}
