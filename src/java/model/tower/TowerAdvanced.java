package model.tower;

import geometry.IntCoordinates;

public class TowerAdvanced extends Towers {
    public TowerAdvanced(IntCoordinates pos) {
        super(pos, 20, 1, 3, 70);
    }

    @Override
    public String getName() {
        return "Advanced Tower";
    }

    @Override
    public String toString() {
        return "AT ";
    }
}
