package model.monster;

import config.Path;

public class MonsterAdvanced extends Monsters{
    public MonsterAdvanced(Path path) {
        super(path, 20, 40);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "() ";
    }
}
