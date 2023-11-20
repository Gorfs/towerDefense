package model;
import config.*;
import misc.Debug;

public class GameState {
    static Cell[][] gameMap = Map.getMap();

    public static void initGameState(int level){
        Map.generateMap(level);
        gameMap = Map.getMap();
        // Debug.printMap(gameMap);
        // the amount of life the player has left.
        if (gameMap == null){
            System.out.println(" ERROR -> Game state was loaded before config files, therefore no map was loaded, exiting...");
            System.exit(1);
        }
        //loading path for the monsters
    }
    public static Cell[][] getMap(){
        return gameMap;
    }
}
