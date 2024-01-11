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
    public void setPos(IntCoordinates pos){
        this.pos = pos;
    }
    public int getCost(){
        return price;
    }

    public Set<Monsters> getMonstersInRange() {
        return monstersInRange;
    }
    
    public String getName(){
        return "Null Tower";
    }

    public void setMonstersInRange(Monsters monsters, int factor) {
        if (this.IsInRange(monsters.getPos(), factor)) this.monstersInRange.add(monsters);
    }


    // Desole pour le code commenter, j'ai passe 3 heures a tester des facons differents de faire.

    // public boolean IsInRange(RealCoordinates mPos, int factor) {
    //        return (((Math.sqrt(Math.pow((mPos.getX() - pos.getX()),2) + (Math.pow((mPos.getY() - pos.getY()),2))))) <= this.getRange(factor));
    //      return (((Math.abs(mPos.getX() - pos.getX())) <= this.getRange(factor)) && ((Math.abs(mPos.getY() - pos.getY())) <= this.getRange(factor)));
    //     return (pos.x * pos.x + Math.abs(mPos.x - pos.x) * Math.abs(mPos.x - pos.x) <= (Math.pow(this.getRange(factor),2)) &&
    //             pos.y * pos.y + Math.abs(mPos.y - pos.y) * Math.abs(mPos.y - pos.y) <= (Math.pow(this.getRange(factor),2)));
    // }

    public boolean IsInRange(RealCoordinates mPos, int factor) {
        return this.getDistance(mPos) * factor <= this.getRange(factor); 
        // return (Math.abs(mPos.getX() - pos.getX()) * Math.abs(mPos.getX() - pos.getX()) +
        //         Math.abs(mPos.getY() - pos.getY()) * Math.abs(mPos.getY() - pos.getY())
        //         <= this.getRange(factor) * this.getRange(factor));
    }

    public double getDistance(RealCoordinates mPos){
   
        return 
        Math.max(
            Math.max(
                Math.abs(pos.getX() - mPos.getY()), // !! coordinates inverted due to map being a list of lists.
                Math.abs(pos.getY() - mPos.getX())
                ), 
            Math.max(
                Math.abs(mPos.getX() - pos.getY()),
                Math.abs(mPos.getY() - pos.getX())
                ));
        // return Math.sqrt(Math.pow((mPos.getX() - pos.getX()), 2) +
        //         Math.pow((mPos.getY() - pos.getY()),2));
    }

    public int getId() {
        return id;
    }

    public int getAttack(int factor) {
        return attack * factor;
    }

    public int getSpeed(int factor) {
        return speed * factor;
    }

    public int getRange(int factor) {
        return range * factor;
    }

    public int getPrice() {
        return price;
    }
}
