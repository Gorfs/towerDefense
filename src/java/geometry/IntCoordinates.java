package geometry;

public class IntCoordinates {
    public final int x;
    public final int y;

    public IntCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /** 
     * @return int
     */
    public int getX() {
        return x;
    }

    /** 
     * @return int
     */
    public int getY() {
        return y;
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "x: " + x + "    y: " + y;
    }
}
