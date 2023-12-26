package model;

import geometry.IntCoordinates;

public class TowerAdvanced extends Towers {
    public TowerAdvanced(IntCoordinates pos) {
        super(pos, 10, 1, 3, 50);
    }

    @Override
    public String toString(){
        return "AT";
    }
}
