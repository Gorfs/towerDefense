package config;

public class Cell {
    private final int x, y;

    public Cell(int x_coord, int y_coord){
        this.x = x_coord;
        this.y = y_coord;
    }
    public Cell(){
        this.x = 0;
        this.y = 0;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return "XX ";
    }
    public String debugString(){
       return x + " " + y; 
    }
}
