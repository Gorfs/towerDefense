package gui.gameUI;

import javax.swing.*;

import gui.Game;
import main.Main;

import java.awt.*;
import java.util.ArrayList;



public class GamePlayPanel extends JPanel {

    // the label that says what phase of the game we are currently in. ex: preperation / wave 2/ wave 3/etc...
    JLabel infoTitle = new JLabel("Preperation Phase", SwingConstants.CENTER);
    UIPanel uiPanel = new UIPanel();


    private MapPanel mapPanel = new MapPanel();

    public GamePlayPanel() {
        super();
        this.setBackground(gui.menu.MainMenu.backgroundColor);
            
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        infoTitle.setFont(infoTitle.getFont().deriveFont(20.0f));
        infoTitle.setForeground(Color.white);
        infoTitle.setAlignmentX(CENTER_ALIGNMENT);

        this.add(infoTitle);

        // mapPanel.setMaximumSize(new Dimension(800, 400));
        this.add(mapPanel);
        mapPanel.setBackground(gui.menu.MainMenu.backgroundColor);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        uiPanel.setBackground(gui.menu.MainMenu.backgroundColor);
        // uiPanel.setMaximumSize(new Dimension(800, 400));
        this.add(uiPanel);
    }
    public void update(){
        mapPanel.update();
        uiPanel.update();
        //TODO set the wave number on this label
        infoTitle.setText((Game.isPreperationPhase) ? "Preperation Phase" : ("Wave "));
    }
}
