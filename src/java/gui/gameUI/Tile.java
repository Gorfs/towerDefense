package gui.gameUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import config.*;
import model.TowerAdvanced;
import model.TowerBasic;

import java.util.Random;
import java.util.ArrayList;

public class Tile extends JLabel {

    public static final int TILE_SIZE = 60;
    public Cell cell;
    public static ImageIcon grass1Img;
    public static ImageIcon grass2Img;
    static public ImageIcon grass3Img;
    static public ImageIcon pathImg;
    static public ImageIcon tower1Img;

    private static ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();

    public Tile(ImageIcon image, Cell cell) {
        super(image);
        this.setMaximumSize(new Dimension(TILE_SIZE, TILE_SIZE));
        this.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
        this.cell = cell;
    }

    public static ImageIcon getImage(Cell cell) {
        Random rd = new Random();
        if (cell instanceof Slot) {
            switch (rd.nextInt(3)) {
                case 0:
                    return grass1Img;
                case 1:
                    return grass2Img;
                case 2:
                    return grass3Img;
            }
        } else if (cell instanceof Path) {
            return pathImg;
        }
        return getBufferedImage(cell, 1);

    }

    public static void initImages() {
        grass1Img = getBufferedImage(new Slot(0, 0), 1);
        grass2Img = getBufferedImage(new Slot(0, 0), 2);
        grass3Img = getBufferedImage(new Slot(0, 0), 3);
        pathImg = getBufferedImage(new Path(0, 0), 1);
        Slot slot = new Slot(0, 0);
        slot.setTower(new TowerBasic(null));
        tower1Img = getBufferedImage(slot, 0);
        slot.setTower(new TowerAdvanced(null));

    }

    private static ImageIcon getBufferedImage(Cell cell, int i) {
        BufferedImage img = null;
        String type = cell.toString();
        // used primarily outside of this class to get the image for the tile
        // TODO make new images for each type of Tower and enemy
        if (type.matches(".*XX.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/Grass" + i + ".jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type.matches(".*\\[\\].*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/path.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type.matches("BT.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/Tower1.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type.matches("AT.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/Tower2.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (type.matches("ET.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/Tower2.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (type.matches("MT.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/Tower2.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (type.matches("UT.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/Tower2.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type.matches(".*M.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/Tower2.jpg"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        ImageIcon dImage = new ImageIcon(img.getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_DEFAULT));
        images.add(dImage);
        return dImage;
    }

}
