package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;


public class Map {
    private static Cell[][] map = new Cell[10][13];
    private static Path initPath;

    public void generateMap(String file) {
        map = new Cell[10][13];
        // Get the file that contains the map
        File maze = new File("src/resources/map/" + file + ".txt");
        Scanner myReader;
        try {
            myReader = new Scanner(maze);
            int n = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] data = line.split(",");

                // For every 2 string
                for (int i = 0; i < data.length; i ++) {
                    // create a cell based on what there is inside(NOTHING, DOT, etc.)
                    switch (data[i]) {
                        case "B" -> map[n][i] = new Cell(i,n);
                        case "P" -> {
                            Path tempCell = new Path(i, n);
                            map[n][i] = tempCell; 
                            if(initPath == null){initPath = tempCell;}
                        } 
                        case "S" -> map[n][i] = new Slot(i, n);
                        default -> map[n][i] = new Slot(i, n);
                    }
                }
                n++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void generatePath(){
        // takes the generated map and linkes all the Paths together to make a linked list
        Path temp = initPath;
        Path tempPrev = initPath;
        while(!temp.isBase()){

        }

    }


    public ArrayList<Cell> getSurroundingCoordinates(int x, int y){
        ArrayList<Cell> result = new ArrayList<Cell>();
        if (x > 0){
            result.add(map[x-1][y]);
            if(y > 0){
                result.add(map[x-1][y-1]);
            }if (y < map[0].length - 2){
                result.add(map[x-1][y + 1]);
            }
        }else{
            result.add(map[x + 1][y]);
        }
        if (x < map.length - 2){
            result.add(map[x+1][y]);
            if(y > 0){
                result.add(map[x+1][y-1]);
            }
            if(y < map[0].length){
                result.add(map[x+1][y+1]);
            }
        }
        

    }
    public int getWidth() {
        return map[0].length;
    }

    public int getHeight() {
        return map.length;
    }

    public Cell getCell(int x, int y) {
        return map[x][y];
    }
    public static Cell[][] getMap(){
        return map;
    }
}
