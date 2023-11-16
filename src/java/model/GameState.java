package model;
import config.*;
import misc.Debug;

public class GameState {
    Cell[][] map;
    int life;

    public static void initGameState(){
        Map map = new Map();
        Cell[][] gameMap = Map.getMap();
        // the amount of life the player has left.
        if (map == null){
            System.out.println("Game state was loaded before config files, therefore no map was loaded, exiting...");
            System.exit(1);
        }
        //loading path for the monsters
        
    }
}
