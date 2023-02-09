package snakegame;

public class PointImp implements Point {
    private int x;
    private int y;

    public PointImp(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "snakegame.PointImp{" + "x=" + x + ", y=" + y + '}';
    }
}