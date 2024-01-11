package main;
import gui.Game;
import model.GameState;

public class Main {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        GameState.setGraphicVersion(true);
        new Game();
    }
}
