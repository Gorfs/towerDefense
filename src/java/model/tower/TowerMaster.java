package model.tower;

import geometry.IntCoordinates;

public class TowerMaster extends Towers {
    public TowerMaster(IntCoordinates pos) {
        super(pos, 40, 1, 5, 150);
    }
    
    /** 
     * @return String
     */
    @Override
    public String getName(){
        return "Master Tower";
    }


    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        return "MT ";
    }
}
