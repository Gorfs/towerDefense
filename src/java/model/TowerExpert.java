package model;

import geometry.IntCoordinates;

public class TowerExpert extends Towers {
    public TowerExpert(IntCoordinates pos) {
        super(pos, 10, 1, 3, 50);
    }

    @Override
    public String toString(){
        return "ET ";
    }
}
