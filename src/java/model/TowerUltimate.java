package model;

import geometry.IntCoordinates;

public class TowerUltimate extends Towers {
    public TowerUltimate(IntCoordinates pos) {
        super(pos, 10, 1, 3, 50);
    }

    @Override
    public String toString(){
        return "UT ";
    }
}
