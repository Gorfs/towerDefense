package model;

import geometry.IntCoordinates;
import geometry.RealCoordinates;

import java.util.HashSet;
import java.util.Set;

public class Towers {
    private static int id_num = 0;
    private final IntCoordinates pos;
    private final int id;
    private final int attack;
    private final int speed;
    private final int range;
    private final int price;
    private final Set<Monster> monstersInRange = new HashSet<>();

    public Towers(IntCoordinates pos, int attack, int speed, int range, int price) {
        this.pos = pos;
        this.id = id_num;
        id_num++;
        this.attack = attack;
        this.speed = speed;
        this.range = range;
        this.price = price;
    }

    public Set<Monster> getMonstersInRange() {
        return monstersInRange;
    }

    public void setMonstersInRange(Monster monster, int factor) {
        if (this.IsInRange(monster.getPos(), factor)) this.monstersInRange.add(monster);
    }

    public boolean IsInRange(RealCoordinates mPos, int factor) {
        return (pos.x * pos.x + Math.abs(mPos.x - pos.x) * Math.abs(mPos.x - pos.x) <= this.getRange(factor) &&
                pos.y * pos.y + Math.abs(mPos.y - pos.y) * Math.abs(mPos.y - pos.y) <= this.getRange(factor));
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
