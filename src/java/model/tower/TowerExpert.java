package model.tower;

import geometry.IntCoordinates;

public class TowerExpert extends Towers {
    public TowerExpert(IntCoordinates pos) {
        super(pos, 40, 4, 100);
    }

    /**
     * @return String
     */
    @Override
    public String getName() {
        return "Expert Tower";
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "ET ";
    }
}
