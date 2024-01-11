package model.tower;

import geometry.IntCoordinates;

public class TowerAdvanced extends Towers {
    public TowerAdvanced(IntCoordinates pos) {
        super(pos, 20, 3,  70);
    }

    
    /** 
     * @return String
     */
    @Override
    public String getName() {
        return "Advanced Tower";
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "AT ";
    }
}
