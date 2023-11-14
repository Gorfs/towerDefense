package model;
import config.*;

public class gameState {
    Cell[][] map;
    int life;

    public gameState(){
        map = Map.getMap();
        // the amount of life the player has left.
        if (map == null){
            System.out.println("Game state was loaded before config files, therefore no map was loaded, exiting...");
            System.exit(1);
        }
    }
}
