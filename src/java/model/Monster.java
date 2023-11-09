package model;

import geometry.IntCoordinates;
import geometry.RealCoordinates;

public class Monster {
    private static int id_num = 0;
    private final RealCoordinates pos;
    private final int id;
    private final int[] health;
    private final int attack;
    private final int speed;


    public Monster(RealCoordinates pos, int attack, int speed, int health) {
        this.pos = pos;
        this.id = id_num;
        id_num++;
        this.attack = attack;
        this.speed = speed;
        this.health = new int[]{health, health};

    }

    public RealCoordinates getPos() {
        return pos;
    }

    public int getId() {
        return id;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpeed() {
        return speed;
    }

    public int[] getHealth() {
        return health;
    }
}
