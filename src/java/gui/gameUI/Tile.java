package gui.gameUI;

import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel{

    public static final int TILE_SIZE = 60;

    public Tile(ImageIcon image) {
        super(image);
        this.setMaximumSize(new Dimension(TILE_SIZE, TILE_SIZE));   
        this.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
    }


    public static ImageIcon getImage(String type){
        // used primarily outside of this class to get the image for the tile
        // TODO make new images for each type of Tower and enemy
        switch(type){
            case "[] ":
                return new ImageIcon("src/resources/art/path.png");
            case "XX ":
                return new ImageIcon("src/resources/art/grass.png");
            case "tower":
                return new ImageIcon("src/resources/art/tower.png");
            case "enemy":
                return new ImageIcon("src/resources/art/enemy.png");
            default:
                return null;
        }
    }
    
}
