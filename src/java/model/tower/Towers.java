package model.tower;

import geometry.IntCoordinates;
import geometry.RealCoordinates;
import gui.Game;
import model.monster.Monsters;

import java.util.HashSet;
import java.util.Set;

public class Towers {
    private static int id_num = 0;
    private IntCoordinates pos;
    private final int id;
    private final int attack;
    private final int speed;
    private final int range;
    private final int price;
    private final Set<Monsters> monstersInRange = new HashSet<>();

    public Towers(IntCoordinates pos, int attack, int speed, int range, int price) {
        this.pos = pos;
        this.id = id_num;
        id_num++;
        this.attack = attack;
        this.speed = speed;
        this.range = range;
        this.price = price;
    }

    /**
     * @param pos
     */
    public void setPos(IntCoordinates pos) {
        this.pos = pos;
    }

    /**
     * @return int
     */
    public int getCost() {
        return price;
    }

    
    /** 
     * @return Set<Monsters>
     */
    public Set<Monsters> getMonstersInRange() {
        return monstersInRange;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return "Null Tower";
    }

    
    /** 
     * @param monsters
     * @param factor
     */
    public void setMonstersInRange(Monsters monsters, int factor) {
        if (this.IsInRange(monsters.getPos(), factor))
            this.monstersInRange.add(monsters);
    }

    
    /** 
     * @param mPos
     * @param factor
     * @return boolean
     */
    public boolean IsInRange(RealCoordinates mPos, int factor) {
        return this.getDistance(mPos) * factor <= this.getRange(factor);
        // return (Math.abs(mPos.getX() - pos.getX()) * Math.abs(mPos.getX() -
        // pos.getX()) +
        // Math.abs(mPos.getY() - pos.getY()) * Math.abs(mPos.getY() - pos.getY())
        // <= this.getRange(factor) * this.getRange(factor));
    }

    
    /** 
     * @param mPos
     * @return double
     */
    public double getDistance(RealCoordinates mPos) {

        return Math.max(
                Math.max(
                        Math.abs(pos.getX() - mPos.getY()), // !! coordinates inverted due to map being a list of lists.
                        Math.abs(pos.getY() - mPos.getX())),
                Math.max(
                        Math.abs(mPos.getX() - pos.getY()),
                        Math.abs(mPos.getY() - pos.getX())));
        // return Math.sqrt(Math.pow((mPos.getX() - pos.getX()), 2) +
        // Math.pow((mPos.getY() - pos.getY()),2));
    }

    
    /** 
     * @return int
     */
    public int getId() {
        return id;
    }

    
    /** 
     * @param factor
     * @return int
     */
    public int getAttack(int factor) {
        return attack * factor;
    }

    
    /** 
     * @param factor
     * @return int
     */
    public int getSpeed(int factor) {
        return speed * factor;
    }

    
    /** 
     * @param factor
     * @return int
     */
    public int getRange(int factor) {
        return range * factor;
    }

    
    /** 
     * @return int
     */
    public int getPrice() {
        return price;
    }
}
