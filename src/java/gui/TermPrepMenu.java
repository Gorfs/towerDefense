package gui;

import java.util.Scanner;

public class TermPrepMenu {
    private static Scanner sc = new Scanner(System.in);
    private static boolean run = true;
    
    // class used for methodes that deal with the preparation phase of the game


    public static void startPreparationPhase(){
        while(run){
            preperationMenu();
        }
    }


    public static void preperationMenu(){
        // the main function that is called when the preparation phase is to the started
        System.out.println("Preperation time");
        TermGame.printMap();
        System.out.println("what would you like to do?");
        System.out.println(" a -> add a tower \n d -> destroy a tower \n x -> start the level\n\n");
        String choice = sc.nextLine();
        switch(choice){
            case "a" ->{
                addTowerMenu();
            }
        }

    }

    public static void addTowerMenu(){
        // add a tower to the map
        System.out.println("where should we add the Tower? format = A7");
    }
}

