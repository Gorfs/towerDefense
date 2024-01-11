package gui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;


public class TermMainMenu {
    private static final Scanner sc = new Scanner(System.in);
    private static int levelSelect = 0;

    public static int getLevelSelect(){
        return levelSelect;
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 


    public static void runTermMainMenu(){
        boolean running = true;
        while(running){
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
                throw new RuntimeException(e);
            }

            System.out.println("What would you like to do?\n\n");
            System.out.println("C : Change difficulty");
            System.out.println("L : Level Select");
            System.out.println("S : Settings");
            System.out.println("Q : Exit");
            String choice = sc.next();
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
        int levelChoice = 1;
        int counter = 1;
        // this is the menu that is called when we want to choose a level.
        do {
            if (levelChoice > counter || levelChoice < 1) System.out.println("Nombre invalide");
            counter = 1;
            System.out.println("Les levels disponibles:");
            final File folder = new File("src/resources/map");
            for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
                System.out.println(" " + counter + ": " + fileEntry.getName().substring(0,fileEntry.getName().length() - 4));
                counter++;
            }
            System.out.println("\n\n Votre Choix: ");
            try {
                // check out if the input is a correct number
                levelChoice = sc.nextInt();
            } catch (Exception e) {
                levelChoice = counter + 1;
                System.out.println("Entrée invalide, veuillez entrer un nombre.");
            }
            clearScreen();
        } while (levelChoice > counter || levelChoice < 1);
        return levelChoice - 1;
    }
}
