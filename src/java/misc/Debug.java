package misc;
import config.*;

public class Debug {
    public static boolean isDebugging = true;

    public static boolean isDebugging() {
        return isDebugging;
    }
    public static void toggleDebugging(){
        isDebugging = !isDebugging;
    }

    public static void printPath(){
        System.out.println("current path is ");
        Path initPath = Map.getInitPath();
        while(initPath != null){
            System.out.println(" current tile is " + initPath.getX() + " " + initPath.getY() + "");
            initPath = (Path) initPath.getNextPath();
        }
    }
    public static void out(String str){
        if(isDebugging)
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

    public static void printMap(Cell[][] map){
        for(int i = 0 ; i < map.length ;i++){
            for(int j = 0; j < map[0].length ; j++){
                System.out.print(map[i][j] + "   ");
            }
            System.out.println("");
        }
    }
}
