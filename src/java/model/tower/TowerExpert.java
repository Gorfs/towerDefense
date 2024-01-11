package model.tower;

import geometry.IntCoordinates;

public class TowerExpert extends Towers {
    public TowerExpert(IntCoordinates pos) {
        super(pos, 40, 4, 100);
    }

    @Override
    public String getName(){
        return "Expert Tower";
    }

    @Override
    public String toString(){
        return "ET ";
    }
}
