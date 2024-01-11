package gui.gameUI;

import javax.swing.*;
import java.awt.*;

import model.GameState;


public class GamePlayPanel extends JPanel {

    // the label that says what phase of the game we are currently in. ex: preparation / wave 2/ wave 3/etc...
    JLabel infoTitle = new JLabel("Preparation Phase", SwingConstants.CENTER);
    UIPanel uiPanel = new UIPanel();


    private final MapPanel mapPanel = new MapPanel();

    public GamePlayPanel() {
        super();
        this.setBackground(gui.menu.MainMenu.backgroundColor);
            
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        infoTitle.setFont(infoTitle.getFont().deriveFont(20.0f));
        infoTitle.setForeground(Color.white);
        infoTitle.setAlignmentX(CENTER_ALIGNMENT);

        this.add(infoTitle);

        this.add(mapPanel);
        mapPanel.setBackground(gui.menu.MainMenu.backgroundColor);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        uiPanel.setBackground(gui.menu.MainMenu.backgroundColor);
        this.add(uiPanel);
    }
    public void update(){
        mapPanel.update();
        uiPanel.update();
        infoTitle.setText(GameState.infoString);
        
    }
}
