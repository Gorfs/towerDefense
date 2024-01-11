package model.tower;

import geometry.IntCoordinates;

public class TowerBasic extends Towers {
    public TowerBasic(IntCoordinates pos) {
        super(pos, 10, 1, 30);
    }

    
    /** 
     * @return String
     */
    @Override
    public String getName() {
        return "Basic Tower";
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "BT ";
    }
}
