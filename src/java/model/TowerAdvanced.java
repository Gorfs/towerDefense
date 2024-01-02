package model;

import geometry.IntCoordinates;

public class TowerAdvanced extends Towers {
    public TowerAdvanced(IntCoordinates pos) {
        super(pos, 15, 1, 3, 80);
    }

    @Override
    public String toString(){
        return "AT ";
    }
}
