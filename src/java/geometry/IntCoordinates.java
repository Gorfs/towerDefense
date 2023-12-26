package geometry;

public class IntCoordinates {
    public final int x;
    public final int y;

    public IntCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x: " + x + "    y: " + y;
    }

    public RealCoordinates toRealCoordinates(double scale) {
        return new RealCoordinates(x * scale, y * scale);
    }

}
