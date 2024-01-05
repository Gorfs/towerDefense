package gui.menu;

import javax.swing.*;

import gui.Game;
import misc.Debug;
import gui.menu.*;

public class GameLostPanel extends JPanel{

    JButton mainMenButton = new JButton("Main Menu");

    public GameLostPanel() {
        super();
        this.setBackground(MainMenu.backgroundColor);
        // making the gameOver screen transparent
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Game Over", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(40.0f));

        mainMenButton.addActionListener(e -> {
            Game.changePanel("main");
            Debug.out("Game lost , going back to mainMenu");
        });

        this.add(Box.createRigidArea(new java.awt.Dimension(Game.HEIGHT/3, 200)));
        this.add(mainMenButton);
        this.add(Box.createRigidArea(new java.awt.Dimension(20, 200)));
        this.add(label);
    }
    
}
