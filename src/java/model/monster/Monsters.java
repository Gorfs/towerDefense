package model.monster;

import geometry.RealCoordinates;
import config.Path;
import model.Player;

public class Monsters {
    private static int id_num = 0;
    private Path path;
    private final int id;
    private final int[] health;
    private final int attack;
    private final int speed;


    public Monsters(Path path, int attack, int speed, int health) {
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

    public boolean takeDamage(int damage){ // returns a boolean if the monster is dead
        this.health[0] -= damage;
        if (this.health[0] <= 0){
            Player.INSTANCE.updateMoney(10);
            return true;
        }else{
            return false;
        }
    }

    public boolean move(){ // returns true if the enemy has made it to the end, else it returns false
        if (this.path.getNextPath() == null){
                // the enemy has made it to the end of the map, reduce health of player and deleted the monster
            Player.INSTANCE.takeDamage(this.attack);
            this.path.removeMonster();
            return true;
        }else{
            this.path.removeMonster();
            this.path = (Path) this.path.getNextPath();
            this.path.setMonster(this);
            return false;
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
        return "<> ";
    }
}