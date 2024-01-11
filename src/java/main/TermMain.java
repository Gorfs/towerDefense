package main;
import gui.Log;
import gui.TermMainMenu;
import gui.TermGame;
import model.GameState;

public class TermMain {
  
  
     public static Log log = new Log();
  
  
  
    /** 
     * @param args
     */
    public static void main(String[] args){
        GameState.setGraphicVersion(false);
        System.out.println("mainTerm");
        TermMainMenu.runTermMainMenu();
        int levelSelect = TermMainMenu.getLevelSelect();
        TermGame.runGame(levelSelect);
    }
}
