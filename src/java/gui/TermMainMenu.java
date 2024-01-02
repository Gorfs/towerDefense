package gui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class TermMainMenu {
    private static Scanner sc = new Scanner(System.in);
    private static boolean running = false;
    private static String choice;
    private static int levelSelect = 0;

    public static int getLevelSelect(){
        return levelSelect;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 


    public static void runTermMainMenu(){
        running = true;
        while(running){ 
            running = true;
            try(BufferedReader br = new BufferedReader(new FileReader("src/resources/ascii2.txt"))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
            String everything = sb.toString();
            System.out.println(everything);
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println("What would you like to do?\n\n");
            System.out.println("C : Change difficulty");
            System.out.println("L : Level Select");
            System.out.println("S : Settings");
            System.out.println("Q : Exit");
            choice = sc.next();
            switch(choice.toLowerCase()){
                case "q":{
                    System.exit(0);
                    break;
                }
                case "c" : {
                    // call the change difficulty menu
                }
                case "s" :{
                    // call settings menu
                }
                case "l" :{
                    clearScreen();
                    levelSelect = TermLevelMenu();
                    running = false;
                }
            }
        }
    }    
    
    
    public static int TermLevelMenu(){
        // this is the menu that is called when we want to choose a level.
        int counter = 0;
        System.out.println("Les levels disponibles:");
        final File folder = new File("src/resources/map");
        for(final File fileEntry: folder.listFiles()){
            System.out.println(" " + counter + " : " + fileEntry.getName());
        }
        System.out.println("\n\n Votre Choix: ");
        int levelChoice = sc.nextInt();
        clearScreen();
        return levelChoice;
    }
}
