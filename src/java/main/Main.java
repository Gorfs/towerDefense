package main;
import gui.Game;
import model.GameState;

public class Main {

    public static void main(String[] args) {
        GameState.setGraphicVersion(true);
        new Game();
    }
}
