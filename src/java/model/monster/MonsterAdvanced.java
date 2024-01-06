package model.monster;

import config.Path;

public class MonsterAdvanced extends Monsters{
    public MonsterAdvanced(Path path) {
        super(path, 20, 1, 40);
    }

    @Override
    public String toString() {
        return "() ";
    }
}
