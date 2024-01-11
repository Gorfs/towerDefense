package gui.gameUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import config.*;
import misc.Debug;
import model.monster.MonsterAdvanced;
import model.monster.MonsterBasic;
import model.monster.MonsterExpert;
import model.monster.Monsters;
import model.tower.*;

import java.util.ArrayList;

public class Tile extends JLabel {

    public static final int TILE_SIZE = 60;
    public Cell cell;
    public static ImageIcon grass1Img;
    public static ImageIcon grass2Img;
    static public ImageIcon grass3Img;
    static public ImageIcon pathImg;
    static public ImageIcon tower1Img;
    static public ImageIcon tower2Img;
    static public ImageIcon tower3Img;
    static public ImageIcon tower4Img;
    static public ImageIcon tower5Img;
    static public ImageIcon zombieImg;
    static public ImageIcon slimeImg;
    static public ImageIcon endermanImg;

    private static ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();

    public Tile(ImageIcon image, Cell cell) {
        super(image);
        this.setMaximumSize(new Dimension(TILE_SIZE, TILE_SIZE));
        this.setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
        this.cell = cell;
    }

    public static ImageIcon getImage(Cell cell) {
        if (cell instanceof Slot) {
            if(((Slot) cell).getTower() == null){
                return grass1Img;
            }
            if (((Slot)cell).getTower() instanceof TowerBasic) {
                return tower1Img;
            } else if (((Slot)cell).getTower() instanceof TowerAdvanced) {
                return tower2Img;
            } else if(((Slot)cell).getTower() instanceof TowerExpert) {
                return tower3Img;
            }else if(((Slot)cell).getTower() instanceof TowerMaster) {
                return tower4Img;
           }else{
                return tower5Img;
            }
           
        } else if (cell instanceof Path) {
            if(((Path)cell).isEmpty()){
                return pathImg;
            }else{
                switch(((Path)cell).getMonster().toString()){
                    case "() ":
                        return slimeImg;
                    case "<> ": 
                        return zombieImg;
                    case "[] ":
                        return endermanImg;
                }
            }
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
        tower2Img = getBufferedImage(slot, 0);
        slot.setTower(new TowerExpert(null));
        tower3Img = getBufferedImage(slot, 0);
        slot.setTower(new TowerMaster(null));
        tower4Img = getBufferedImage(slot, 0);
        slot.setTower(new TowerUltimate(null));
        tower5Img = getBufferedImage(slot, 0);
        Path path = new Path(0, 0);
        path.setMonster(new MonsterAdvanced(null));
        zombieImg = getBufferedImage(path, 0);
        path.setMonster(new MonsterBasic(null));
        slimeImg = getBufferedImage(path, 0);
        path.setMonster(new MonsterExpert(null));
        endermanImg = getBufferedImage(path, 0);



    }

    private static ImageIcon getBufferedImage(Cell cell, int i) {
        BufferedImage img = null;
        String type = cell.toString();
        // used primarily outside of this class to get the image for the tile
        // TODO make new images for each type of Tower and enemy
        if (type.matches(".*XX.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/assets/textures/grass.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type == "() ") {
            try {
                img = ImageIO.read(new File("src/resources/art/assets/enemies/slime.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (type == "<> "){
            try{
                img = ImageIO.read(new File("src/resources/art/assets/enemies/zombie.png"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (type == "[] ") {
            try{
                img = ImageIO.read(new File("src/resources/art/assets/enemies/enderman.png"));
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (type.matches("BT.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/assets/towers/arrow.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type.matches("AT.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/assets/towers/dispenser.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (type.matches("ET.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/assets/towers/iron_g.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (type.matches("MT.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/assets/towers/snow_g.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (type.matches("UT.*")) {
            try {
                img = ImageIO.read(new File("src/resources/art/assets/towers/villager.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (type == "   ") {
            try {
                img = ImageIO.read(new File("src/resources/art/assets/textures/dirt.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{

            return grass1Img;
        }
        Debug.out(type);
        ImageIcon dImage = new ImageIcon(img.getScaledInstance(TILE_SIZE, TILE_SIZE, Image.SCALE_DEFAULT));
        images.add(dImage);
        return dImage;
    }

}
