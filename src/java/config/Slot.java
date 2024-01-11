package config;
import model.tower.Towers;

public class Slot extends Cell{
    private boolean isEmpty;
    private Towers tower;
    // TODO: Add the same thing as for the path class, but with Towers, wait until Tower class has been made.
    
    public Slot(int x, int y){
        super(x, y);
        isEmpty = true;
    }
    public Slot(){
        super();
        isEmpty = true;
    }

    public Towers getTower(){
        return tower;
    }
    public void setTower(Towers tower){
        this.isEmpty = false;
        this.tower = tower;
    }

    public void removeTower(){
        this.isEmpty = true;
        this.tower = null;
    }

    @Override
    public String toString(){
        if(isEmpty){
            return "XX ";
        }else{
            return tower.toString();
        }
    }

    
   
}
