package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static config.Cell.slot;

public class Map {
    private Cell[][] map = new Cell[10][13];

    public void generateMap(String file) {
        map = new Cell[10][13];
        // Get the file that contains the map
        File maze = new File("src/resources/map/" + file + ".txt");
        Scanner myReader;
        // Try if the file exist
        try {
            // Read the file maze.txt
            myReader = new Scanner(maze);
            int n = 0;
            // while there is something to read
            while (myReader.hasNextLine()) {
                // Get the curent line
                String line = myReader.nextLine();
                // Split everything into a String array
                String[] data = line.split(",");

                // For every 2 string
                for (int i = 0; i < data.length; i ++) {
                    // create a cell based on what there is inside(NOTHING, DOT, etc.)
                    switch (data[i]) {
                        case "B" -> map[n][i] = slot(Cell.Content.BASE);
                        case "P" -> map[n][i] = slot(Cell.Content.PATH);
                        case "S" -> map[n][i] = slot(Cell.Content.SPAWN);
                        default -> map[n][i] = slot(Cell.Content.SLOT);
                    }
                }
                n++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
}
