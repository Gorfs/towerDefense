package gui;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class TermMainMenu {
    Scanner sc = new Scanner(System.in);
    boolean running = false;
    String ascii = "";
    String choice;
    public TermMainMenu(){
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
                case "q" ->{
                    System.exit(0);
                }
                case "c" -> {
                    // call the change difficulty menu
                }
                case "s" ->{
                    // call settings menu
                }
                case "l" ->{
                    // call level select menu
                }
            }
        }
    }    
    
    
}
