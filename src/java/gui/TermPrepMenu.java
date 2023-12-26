package gui;

import java.util.Scanner;

import config.Slot;
import geometry.IntCoordinates;
import model.*;

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
            case "a" :{
                addTowerMenu();
                preperationMenu();
                break;
            }
        }

    }

    public static void addTowerMenu(){
        // add a tower to the Map
        TermGame.printMap();
        System.out.println("where should we add the Tower? format = A7");
        String choice = sc.nextLine();
        int x = choice.charAt(0) - 'A'; 
        int y = choice.charAt(1) - 'A';
        if (!(model.GameState.getMap()[x][y] instanceof Slot)){
            System.out.println("Error, not a valid slot");
            addTowerMenu();
        }else{
            Slot slot = (Slot) model.GameState.getMap()[x][y];
            System.out.println("what tower would you like to add?");
            System.out.println("1 -> basic tower");
            System.out.println("2 -> advanced tower");
            System.out.println("3 -> expert tower");
            System.out.println("4 -> master tower");
            System.out.println("5 -> ultimate tower");
            choice = sc.nextLine();
            Towers tower = new TowerBasic(new IntCoordinates(x,y));
            // add a basic tower
            switch(choice){
                case "1" :{
                    // add a basic tower
                    // Tower is already made since it is the default.
                    break;
                }
                case "2" :{
                    // add a advanced tower
                    tower = new TowerAdvanced(new IntCoordinates(x,y));
                    break;
                }
                case "3" :{
                    // add a expert tower
                    tower = new TowerExpert(new IntCoordinates(x,y));
                    break;
                }
                case "4" :{
                    // add a master tower
                    tower = new TowerMaster(new IntCoordinates(x,y));
                    break;
                }
                case "5" :{
                    // add a ultimate tower
                    tower = new TowerUltimate(new IntCoordinates(x,y));
                    break;
                }
                default :{
                    System.out.println("Error, not a valid tower");
                    addTowerMenu();
                    break;
                } 
            }
            slot.setTower(tower);
        }
    }
}

