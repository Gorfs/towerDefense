package model;

import misc.Debug;

import geometry.IntCoordinates;
import geometry.RealCoordinates;
import config.Path;

public class Monster {
    private static int id_num = 0;
    private Path path;
    private final int id;
    private final int[] health;
    private final int attack;
    private final int speed;


    public Monster(Path path, int attack, int speed, int health) {
        this.path = path;
        this.id = id_num;
        id_num++;
        this.attack = attack;
        this.speed = speed;
        this.health = new int[]{health, health};

    }
    public RealCoordinates getPos(){
        return new RealCoordinates(this.path.getX(), this.path.getY());
    }

    public boolean move(){ // returns true if the enemy has made it to the end, else it returns false
        if (this.path.getNextPath() == null){
            this.path.removeMonster();
                // the enemy has made it to the end of the map, reduce health of player and deleted the monster
            Player.getInstance().takeDamage(this.attack);
            return false;
        }else{
            this.path.removeMonster();
            this.path = (Path) this.path.getNextPath();
            this.path.setMonster(this);
            return true;
        }

    }

    public Path getPath() {
        return this.path;
    }
    public void setPath(Path path){
        this.path = path;
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
    public String toString(){
        return "M  ";
    }
}
