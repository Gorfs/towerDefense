package gui;
import java.io.BufferedReader;
import java.io.FileReader;



public class TermMainMenu {
    boolean initialized = false;
    String ascii = "";
    public TermMainMenu(){
        initialized = true;
        try(BufferedReader br = new BufferedReader(new FileReader("src/resources/ascii.txt"))) {
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
    }
    
    
    
}
