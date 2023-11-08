package geometry;

public record IntCoordinates(int x, int y) {

    public String toString(){
        return ("x :" + x + "    y : " + y);
    }
    public RealCoordinates toRealCoordinates(double scale) {
        return new RealCoordinates(x * scale, y * scale);
    }
}
