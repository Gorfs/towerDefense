package misc;
import config.*;

public class Debug {

    public static void printPath(){
        System.out.println("current path is ");
        Path initPath = Map.getInitPath();
        while(initPath != null){
            System.out.println(" current tile is " + initPath.getX() + " " + initPath.getY() + "");
            initPath = (Path) initPath.getNextPath();
        }
    }
    public static void out(String str){
        System.out.println("DEBUG>>> " + str);
    }
    public static void printMapCoords(){
        Cell[][] map = Map.getMap();
        for(Cell[] line:map){
            for(Cell cell:line){
                System.out.print(cell.debugString() + "      ");
            }
            System.out.println("");
        }
    }
}
