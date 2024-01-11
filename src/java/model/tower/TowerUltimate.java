package model.tower;

import geometry.IntCoordinates;

public class TowerUltimate extends Towers {
    public TowerUltimate(IntCoordinates pos) {
        super(pos, 60, 6, 200);
    }

    
    /** 
     * @return String
     */
    @Override
    public String getName() {
        return "Ultimate Tower";
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "UT ";
    }
}
