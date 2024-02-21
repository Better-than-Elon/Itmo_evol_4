package lab3;

public class Point {
    private final int x;
    private final int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double dist(Point next) {
        return Math.sqrt((x - next.getX()) * (x - next.getX()) + (y - next.getY()) * (y - next.getY()));
    }
}
