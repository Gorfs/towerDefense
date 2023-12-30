package model;

import geometry.IntCoordinates;

public class TowerMaster extends Towers {
    public TowerMaster(IntCoordinates pos) {
        super(pos, 40, 1, 5, 150);
    }

    @Override
    public String toString(){
        return "MT ";
    }
}
