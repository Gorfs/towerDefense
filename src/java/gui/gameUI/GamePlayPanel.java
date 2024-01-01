package gui.gameUI;

import javax.swing.*;

import main.Main;

import java.awt.*;
import java.util.ArrayList;



public class GamePlayPanel extends JPanel {

    // the label that says what phase of the game we are currently in. ex: preperation / wave 2/ wave 3/etc...
    JLabel infoTitle = new JLabel("Wave #:", SwingConstants.CENTER);

    private MapPanel mapPanel = new MapPanel();

    public GamePlayPanel() {
        super();
        this.setBackground(gui.menu.MainMenu.backgroundColor);
            
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(infoTitle);

        mapPanel.setMaximumSize(new Dimension(800, 400));
        this.add(mapPanel);
    }
    public void update(){
        mapPanel.update();
    }
}
