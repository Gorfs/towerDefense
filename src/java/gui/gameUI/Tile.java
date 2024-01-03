package gui.gameUI;

import javax.swing.*;
import java.awt.*;
import config.Cell;

public class Tile extends JLabel{

    public static final int TILE_SIZE = 60;
    public Cell cell;
    public Popup popUp;

    public Tile(ImageIcon image, Cell cell) {
        super(image);
        this.setMaximumSize(new Dimension(TILE_SIZE, TILE_SIZE));   
        this.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
        this.cell = cell;
    }


    public static ImageIcon getImage(Cell cell){
        String type = cell.toString();
        // used primarily outside of this class to get the image for the tile
        // TODO make new images for each type of Tower and enemy
        if (type.matches(".*XX.*")){
            return new ImageIcon("src/resources/art/grass.png");
        }
        else if (type.matches(".*\\[\\].*")){
            return new ImageIcon("src/resources/art/path.png");
        }
        else if (type.matches("BT.*")){
            return new ImageIcon("src/resources/art/towerb.png");
        }
        else if (type.matches("AT.*")){
            return new ImageIcon("src/resources/art/towera.png");
        }
        else if (type.matches("ET.*")){
            return new ImageIcon("src/resources/art/towere.png");
        }
        else if (type.matches("MT.*")){
            return new ImageIcon("src/resources/art/towerm.png");
        }
        else if (type.matches("UT.*")){
            return new ImageIcon("src/resources/art/toweru.png");
        }
        else if (type.matches(".*M.*")){
            return new ImageIcon("src/resources/art/enemy.png");
        }
        else{
            return null;
        }
    }
    
}
