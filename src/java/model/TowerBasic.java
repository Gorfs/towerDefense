package model;

import geometry.IntCoordinates;

public class TowerBasic extends Towers {
    public TowerBasic(IntCoordinates pos) {
        super(pos, 10, 1, 3, 50);
    }

    @Override
    public String toString(){
        return "BT ";
    }
}