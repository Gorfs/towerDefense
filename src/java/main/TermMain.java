package main;
import gui.TermMainMenu;
import gui.TermGame;
public class TermMain {
    public static void main(String[] args){
        System.out.println("mainTerm");
        TermMainMenu.runTermMainMenu();
        int levelSelect = TermMainMenu.getLevelSelect();
        TermGame.runGame(levelSelect);
    }
}
