package config;
import model.tower.Towers;

public class Slot extends Cell{
    private boolean isEmpty;
    private Towers tower;

    public Slot(int x, int y){
        super(x, y);
        isEmpty = true;
    }
    
    /** 
     * @return Towers
     */
    public Towers getTower(){
        return tower;
    }
    
    /** 
     * @param tower Set tower as the tower in this Slot
     */
    public void setTower(Towers tower){
        this.isEmpty = false;
        this.tower = tower;
    }

    public void removeTower(){
        this.isEmpty = true;
        this.tower = null;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        if(isEmpty){
            return "XX ";
        }else{
            return tower.toString();
        }
    }

    
   
}
