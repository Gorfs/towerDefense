package model.monster;

import geometry.IntCoordinates;
import config.Path;
import model.Player;

public class Monsters {
    private Path path;
    private final int[] health;
    private final int attack;


    public Monsters(Path path, int attack, int health) {
        this.path = path;
        this.attack = attack;
        this.health = new int[]{health, health};

    }
    
    /**
     * @return IntCoordinates
     */
    public IntCoordinates getPos(){
        return new IntCoordinates(this.path.getX(), this.path.getY());
    }

    
    /**
     * @param damage d
     * @return boolean
     */
    public boolean takeDamage(int damage){ // returns a boolean if the monster is dead
        this.health[0] -= damage;
        if (this.health[0] <= 0){
            Player.INSTANCE.updateMoney(10);
            return true;
        }else{
            return false;
        }
    }

    
    /**
     * @return boolean
     */
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

    
    /** 
     * @return Path
     */
    public Path getPath() {
        return this.path;
    }
    
    /** 
     * @return int
     */
    public int getAttack() {
        return attack;
    }

    public String toString(){
        return "<> ";
    }
}
