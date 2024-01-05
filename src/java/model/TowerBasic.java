package model;

import geometry.IntCoordinates;

public class TowerBasic extends Towers {
    public TowerBasic(IntCoordinates pos) {
        super(pos, 10, 1, 1, 50);
    }

    @Override
    public String getName() {
        return "Basic Tower";
    }

    @Override
    public String toString() {
        return "BT ";
    }
}
