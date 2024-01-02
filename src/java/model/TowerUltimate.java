package model;

import geometry.IntCoordinates;

public class TowerUltimate extends Towers {
    public TowerUltimate(IntCoordinates pos) {
        super(pos, 60, 1, 6, 200);
    }

    @Override
    public String toString(){
        return "UT ";
    }
}
