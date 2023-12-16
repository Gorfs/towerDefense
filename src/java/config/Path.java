package config;

import model.Monster;

public class Path extends Cell {
    
    private boolean isEmpty;
    private Monster monster;
    private Cell nextPath;

    private boolean isSpawn;
    private boolean isBase;

    public Path(Path nextPath, int x, int y){
        super(x,y);
        this.monster = null;
        this.isEmpty = true;
        this.nextPath = nextPath;
    }

    public Path(boolean isSpawn, int x, int y){
        super(x,y);
        this.isSpawn = true;
        this.isEmpty = true;
        this.nextPath = null;
    }
    public Path(boolean isSpawn, boolean isBase, int x, int y){
        this(false, x, y);
        this.isBase = true;
    }
    public boolean isBase(){
        return isBase;
    }
    public void setNextPath(Cell next){
        this.nextPath =  next;
    }

    public Path(int x, int y){
        this(false, x, y);
    }

    public void setSpawn(boolean isSpawn){
        this.isSpawn = isSpawn;
    }
    public boolean isSpawn(){
        return this.isSpawn;
    }

    public Cell getNextPath(){
        return this.nextPath;
    }
    public boolean isEmpty(){
        return this.isEmpty;
    }
    public Monster getMonster(){
        return this.monster;
    }

    public String toString(){
        if(this.isEmpty()){
            return "[]";
        }else{
            // TODO: With this only 1 monster can be displayed at a timer. Discuss and come back to.
            return this.monster.toString();
        }
    }

}
