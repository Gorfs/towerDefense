package main;
import gui.Log;
import gui.TermMainMenu;
import gui.TermGame;
public class TermMain {
    public static Log log = new Log();
    public static void main(String[] args){
        System.out.println("mainTerm");
        TermMainMenu.runTermMainMenu();
        int levelSelect = TermMainMenu.getLevelSelect();
        TermGame.runGame(levelSelect);
    }
}
