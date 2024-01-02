package gui.gameUI;

import javax.swing.*;

import model.GameState;
import misc.Debug;

import java.awt.*;
import java.awt.event.MouseAdapter;

import config.*;

public class MapPanel extends JPanel {
    // this panel contains the Main Map with each tile and the towers etc...

    private final static int TILE_SIZE = Tile.TILE_SIZE;

    Cell[][] prevMap;
    private addTowerPopUp popUp = new addTowerPopUp();

    public MapPanel() {
        super();
        this.setBackground(gui.menu.MainMenu.backgroundColor);
        update();

    }

    public void update() {
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
                            // addTowerPopUp popUp = new addTowerPopUp();
                            popUp.update();
                            popUp.show(evt.getComponent(), evt.getX(), evt.getY());
                            
                        }
                    });
                    // tile.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
                    // tile.setMaximumSize(new Dimension(TILE_SIZE, TILE_SIZE));

                    this.add(tile);
                }
            }
        }
    }

}
