package model.monster;

import config.Path;

public class MonsterExpert extends Monsters{
    public MonsterExpert(Path path) {
        super(path, 30, 1, 80);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "[] ";
    }
}
