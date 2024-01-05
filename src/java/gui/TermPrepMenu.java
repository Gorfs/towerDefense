package gui;

import java.util.Scanner;

import config.Slot;
import geometry.IntCoordinates;
import misc.*;
import model.*;
import java.util.ArrayList;

public class TermPrepMenu {
    private static final Scanner sc = new Scanner(System.in);
    private static boolean run = true;
    private static final ArrayList<Slot> towerList = new ArrayList<>();
    
    
    // class used for methods that deal with the preparation phase of the game


    public static void startPreparationPhase(){
        while(run){
            preparationMenu();
        }
    }




    public static void preparationMenu(){
        // the main function that is called when the preparation phase is to the started
        System.out.println("Preparation time");
        TermGame.printMap();
        System.out.println("what would you like to do?");
        System.out.println(" a -> add a tower \n d -> destroy a tower \n x -> start the level\n\n");
        String choice = sc.nextLine();
        switch(choice){
            case "a" :{
                TermMainMenu.clearScreen();
                addTowerMenu();
                preparationMenu();
                break;
            }
            case "d":{
                TermMainMenu.clearScreen();
                removeTowerMenu();
                preparationMenu();
                break;
            }
            case "x":{
                run = false;
                break;
            }
        }

    }

    public static void removeTowerMenu(){
        TermGame.printMap();
        System.out.println("where should we remove the Tower? format = A7");
        String choice = sc.nextLine();
        int x = (Character.toUpperCase(choice.charAt(0))) - 'A'; 
        int y = Character.getNumericValue(choice.charAt(1)) - 1;
        if (!(model.GameState.getMap()[x][y] instanceof Slot)){
            misc.Print.clearScreen();
            System.out.println("Error, not a valid slot");
            preparationMenu();
        }else{
            Slot slot = (Slot) model.GameState.getMap()[x][y];
            if(slot.getTower() == null){
                TermMainMenu.clearScreen();
                System.out.println("Error, no tower on this slot");
                removeTowerMenu();
            }else{
                misc.Print.clearScreen();
                GameState.removeTower(x, y);
            }
        }
    }

    public static void addTowerMenu(){
        // add a tower to the Map
        TermGame.printMap();
        System.out.println("where should we add the Tower? format = A7");
        String choice = sc.nextLine();
        int x = (Character.toUpperCase(choice.charAt(0))) - 'A'; 
        int y = Integer.parseInt(choice.substring(1)) - 1;
        Debug.out("x = " + x + " y = " + y);
        if (!(model.GameState.getMap()[x][y] instanceof Slot)){
            TermMainMenu.clearScreen();
            misc.Print.clearScreen();
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
                    // add an advanced tower
                    tower = new TowerAdvanced(new IntCoordinates(x,y));
                    break;
                }
                case "3" :{
                    // add an expert tower
                    tower = new TowerExpert(new IntCoordinates(x,y));
                    break;
                }
                case "4" :{
                    // add a master tower
                    tower = new TowerMaster(new IntCoordinates(x,y));
                    break;
                }
                case "5" :{
                    // add an ultimate tower
                    tower = new TowerUltimate(new IntCoordinates(x,y));
                    break;
                }
                default :{
                    misc.Print.clearScreen();
                    System.out.println("Error, not a valid tower");
                    addTowerMenu();
                    break;
                } 
            }
            GameState.addTower(tower, x, y);
            TermMainMenu.clearScreen();
        }
    }
}

