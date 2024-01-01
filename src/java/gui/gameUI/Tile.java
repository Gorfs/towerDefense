package gui.gameUI;

import javax.swing.*;
import java.awt.*;

public class Tile extends JLabel{
    public Tile(ImageIcon image) {
        super(image);
    }


    public static ImageIcon getImage(String type){
        // used primarily outside of this class to get the image for the tile
        // TODO make new images for each type of Tower and enemy
        switch(type){
            case "path":
                return new ImageIcon("src/resources/images/path.png");
            case "grass":
                return new ImageIcon("src/resources/images/grass.png");
            case "tower":
                return new ImageIcon("src/resources/images/tower.png");
            case "enemy":
                return new ImageIcon("src/resources/images/enemy.png");
            default:
                return null;
        }
    }
    
}
