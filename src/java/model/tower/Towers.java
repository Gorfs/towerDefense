package model.tower;

import geometry.IntCoordinates;


public class Towers {
    private IntCoordinates pos;
    private final int attack;
    private final int range;
    private final int price;

    public Towers(IntCoordinates pos, int attack, int range, int price) {
        this.pos = pos;
        this.attack = attack;
        this.range = range;
        this.price = price;
    }

    /**
     * @param pos current pos
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
     * @return String
     */
    public String getName() {
        return "Null Tower";
    }
    
    /** 
     * @param mPos monster pos
     * @param factor range factor
     * @return boolean
     */
    public boolean IsInRange(IntCoordinates mPos, int factor) {
        return this.getDistance(mPos) * factor <= this.getRange(factor);
    }
    
    /** 
     * @param mPos monster pos
     * @return double
     */
    public double getDistance(IntCoordinates mPos) {

        return Math.max(
                Math.max(
                        Math.abs(pos.getX() - mPos.getY()), // !! coordinates inverted due to map being a list of lists.
                        Math.abs(pos.getY() - mPos.getX())),
                Math.max(
                        Math.abs(mPos.getX() - pos.getY()),
                        Math.abs(mPos.getY() - pos.getX())));
    }

    /** 
     * @param factor attack factor
     * @return int
     */
    public int getAttack(int factor) {
        return attack * factor;
    }
    
    /** 
     * @param factor range factor
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
