package gui.gameUI;

import javax.swing.*;

import model.GameState;
import misc.Debug;

import java.awt.*;
import java.awt.event.MouseAdapter;

import config.*;

public class MapPanel extends JPanel {
    // this panel contains the Main Map with each tile and the towers etc...

    Cell[][] prevMap;
    public MapPanel() {
        super();
        this.setBackground(gui.menu.MainMenu.backgroundColor);
        update();
        
    }


    public void update(){
        this.removeAll();
        int heightOfMap = GameState.getMap().length;
        int lengthOfMap = GameState.getMap()[0].length;
        this.setLayout(new GridLayout(heightOfMap, lengthOfMap));
        for (int i = 0; i < heightOfMap; i++) {
            for (int j = 0; j < lengthOfMap; j++) {
                if (GameState.getMap()[i][j] == null) {
                    // Debug.out("Map was null before calling the GUI function to load it");
                } else {
                    Tile tile = new Tile(Tile.getImage(Map.getMap()[i][j].toString()));
                    // tile.setBorder(BorderFactory.createLineBorder(Color.red)); // Add border here

                    tile.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            Debug.out("Clicked");
                        }
                    });
                    this.add(tile);
                }
            }
            }
        }

}
