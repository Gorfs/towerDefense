package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import misc.Debug;

public class Map {
    private static Cell[][] map = new Cell[10][13];
    private static Path initPath;

    /**
     * @param file
     */
    public static void generateMap(int file) {
        String fileString = "level" + file;
        // Get the file that contains the map
        File maze = new File("src/resources/map/" + fileString + ".txt");
        Scanner myReader;
        try {
            myReader = new Scanner(maze);
            int n = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] data = line.split(",");

                // For every 2 string
                for (int i = 0; i < data.length; i++) {
                    switch (data[i]) {
                        case "B": {
                            Path cell = new Path(false, true, i, n);
                            map[n][i] = cell;
                            break;
                        }
                        case "P": {
                            Path tempCell = new Path(i, n);
                            map[n][i] = tempCell;
                            break;
                        }
                        case "S":
                            map[n][i] = new Path(true, i, n);
                            initPath = (Path) map[n][i];
                            break;
                        default:
                            map[n][i] = new Slot(i, n);
                            break;
                    }
                }
                n++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generatePath() {

        // takes the generated map and linkes all the Paths together to make a linked
        // list
        Path temp = initPath;
        int prevX = initPath.getX();
        int prevY = initPath.getY();
        ArrayList<Cell> surroundingTiles;
        while (!temp.isBase()) {
            surroundingTiles = getSurroundingCoordinates(temp.getX(), temp.getY());
            for (Cell cell : surroundingTiles) {
                if ((cell instanceof Path) && (cell.getX() != prevX || cell.getY() != prevY)) {
                    temp.setNextPath(cell);
                    prevX = temp.getX();
                    prevY = temp.getY();
                    temp = (Path) cell;
                    break;
                }
            }

        }
    }

    /**
     * @param x
     * @param y
     * @return ArrayList<Cell>
     */
    private static ArrayList<Cell> getSurroundingCoordinates(int x, int y) {
        // should return all the tiles around the current tile
        ArrayList<Cell> result = new ArrayList<Cell>();
        if (x > 0) {
            result.add(map[y][x - 1]);
        }
        if (x < map[0].length - 1) {
            result.add(map[y][x + 1]);
        }
        if (y > 0) {
            result.add(map[y - 1][x]);
        }
        if (y < map.length - 1) {
            result.add(map[y + 1][x]);
        }
        return result;
    }

    /**
     * @return Path
     */
    public static Path getInitPath() {
        return initPath;
    }

    /**
     * @return int
     */
    public static int getWidth() {
        return map[0].length;
    }

    /**
     * @return int
     */
    public static int getHeight() {
        return map.length;
    }

    /**
     * @param x
     * @param y
     * @return Cell
     */
    public static Cell getCell(int x, int y) {
        return map[x][y];
    }

    /**
     * @return Cell[][]
     */
    public static Cell[][] getMap() {
        return map;
    }
}
