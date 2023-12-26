package model;

import geometry.IntCoordinates;

public class TowerMaster extends Towers {
    public TowerMaster(IntCoordinates pos) {
        super(pos, 10, 1, 3, 50);
    }

    @Override
    public String toString(){
        return "MT";
    }
}
