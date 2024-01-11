package config;

import model.monster.Monsters;

public class Path extends Cell {
    
    private boolean isEmpty;
    private Monsters monsters;
    private Cell nextPath;
    private boolean isBase;

    public Path(boolean isBase, int x, int y){
        this(x, y);
        this.isBase = isBase;
    }

    public Path(int x, int y) {
        super(x,y);
        this.isEmpty = true;
        this.nextPath = null;
    }

    /** 
     * @return boolean
     */
    public boolean isBase(){
        return isBase;
    }
    
    /** 
     * @param next Set the next path as next
     */
    public void setNextPath(Cell next){
        this.nextPath = next;
    }

    /** 
     * @return Cell
     */
    public Cell getNextPath(){
        return this.nextPath;
    }
    
    /** 
     * @return boolean
     */
    public boolean isEmpty(){
        return this.isEmpty;
    }
    
    /** 
     * @return Monsters
     */
    public Monsters getMonster(){
        return this.monsters;
    }


    
    /** 
     * @param monsters Set monsters as the monster in cell
     */
    public void setMonster(Monsters monsters){
        this.isEmpty = false;
        this.monsters = monsters;
    }
    public void removeMonster(){
        this.isEmpty = true;
        this.monsters = null;
    }   

    
    /** 
     * @return String
     */
    public String toString(){
        if(this.isEmpty()){
            return "   ";
        }else{
            // TODO: With this only 1 monster can be displayed at a timer. Discuss and come back to.
            return this.monsters.toString();
        }
    }

}
