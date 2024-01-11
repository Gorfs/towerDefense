package model.tower;

import geometry.IntCoordinates;
import geometry.RealCoordinates;

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
    public void setPos(IntCoordinates pos){
        this.pos = pos;
    }
    public int getCost(){
        return price;
    }
    
    public String getName(){
        return "Null Tower";
    }

    public boolean IsInRange(RealCoordinates mPos, int factor) {
        return this.getDistance(mPos) * factor <= this.getRange(factor);
    }

    public double getDistance(RealCoordinates mPos){
        return 
        Math.max(
            Math.max(
                Math.abs(pos.getX() - mPos.getX()),
                Math.abs(pos.getY() - mPos.getY())
                ), 
            Math.max(
                Math.abs(mPos.getX() - pos.getX()),
                Math.abs(mPos.getY() - pos.getY())
                ));
    }


    public int getAttack(int factor) {
        return attack * factor;
    }

    public int getRange(int factor) {
        return range * factor;
    }

    public int getPrice() {
        return price;
    }
}
