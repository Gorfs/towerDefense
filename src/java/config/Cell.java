package config;

public class Cell {
    private int x,y;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
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
