package gui.gameUI;

import javax.swing.*;

import model.GameState;
import misc.Debug;

import java.awt.*;
import java.awt.event.MouseAdapter;

import config.*;
import gui.Game;
import gui.GameWindow;

import java.util.ArrayList;

public class MapPanel extends JPanel {
    // this panel contains the Main Map with each tile and the towers etc...

    private final static int TILE_SIZE = Tile.TILE_SIZE;

    Cell[][] prevMap;
    private addTowerPopUp popUp = new addTowerPopUp();

    private Popup p;
    private static ArrayList<JPopupMenu> popUps = new ArrayList<JPopupMenu>();

    private static ArrayList<Tile> tiles = new ArrayList<Tile>();

    public MapPanel() {
        super();
        this.setBackground(gui.menu.MainMenu.backgroundColor);
        update();

    }

    public void update() {
        // for (JPopupMenu p : popUps) {
            // p.setVisible(false);
        // }
        popUps.clear();
        this.removeAll();
        int heightOfMap = GameState.getMap().length;
        int lengthOfMap = GameState.getMap()[0].length;
        this.setLayout(new GridLayout(heightOfMap, lengthOfMap));
        for (int i = 0; i < heightOfMap; i++) {
            for (int j = 0; j < lengthOfMap; j++) {
                if (GameState.getMap()[i][j] == null) {
                    // Debug.out("Map was null before calling the GUI function to load it");
                } else {
                    Tile tile = new Tile(Tile.getImage(GameState.getMap()[i][j]), GameState.getMap()[i][j]);
                    // tile.setBorder(BorderFactory.createLineBorder(Color.red)); // Add border here
                    if (!tile.cell.toString().matches("XX\\[ \\]|.T.*")) {
                        if (tile.cell.toString().matches("XX ")) {
                            tile.setToolTipText("click to add Tower");
                        }
                        tile.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                // Debug.out("Clicked");
                                // addTowerPopUp popUp = new addTowerPopUp();
                                popUp.update();
                                popUp.setCell(tile.cell.getX(), tile.cell.getY());
                                if (!tile.cell.toString().matches(".*T.*")) {
                                    popUp.show(evt.getComponent(), evt.getX(), evt.getY());
                                } else {
                                    GameState.removeTower(tile.cell.getX(), tile.cell.getY());
                                }

                                Game.updateGUI();

                            }

                            @Override
                            // TODO setup a nicer border for the tiles
                            public void mouseEntered(java.awt.event.MouseEvent evt) {
                                // Debug.out("Entered");
                                if (tile.cell.toString().matches(".*T.*")) {
                                    tile.setBorder(BorderFactory.createLineBorder(Color.red));
                                } else {
                                    tile.setBorder(BorderFactory.createLineBorder(Color.blue));
                                }
                            }

                            @Override
                            public void mouseExited(java.awt.event.MouseEvent evt) {
                                // Debug.out("Exited");
                                tile.setBorder(null);

                            }
                        });
                    
                    }if(tile.cell.toString().matches(".*M.*")){
                        JPopupMenu p = new JPopupMenu();
                        p.add(new monsterStatsPanel(((Path)tile.cell).getMonster().getHealth()[0]));

                        tile.popUp = p;
                        popUps.add(p);
                        
                    }
                    // tile.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
                    // tile.setMaximumSize(new Dimension(TILE_SIZE, TILE_SIZE));

                    this.add(tile);
                    tiles.add(tile);
                    
                    


            }
        }
    }

    }
    public static void removePopUps(){
        for (Tile tile:tiles){
            if(tile.popUp != null){
                try{
                tile.popUp.setVisible(false);
                }catch(Exception e){
                    Debug.out("Error removing popup");
                }
            }

        }
    }
    public static void showPopUps(){
        for (Tile tile:tiles){
            if(tile.popUp != null){
                try{
                tile.popUp.show(tile, 0, 0);
                }catch(Exception e){
                    Debug.out("Error showing popup");
                }
            }

        }
    }

    public PopupFactory popUpMaker = new PopupFactory();

}
