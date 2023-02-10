package snakegame;

public class BlockImp implements Block {
    private int x;
    private int y;

    public BlockImp(int x, int y) {
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

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "snakegame.BlockImp{" + "x=" + x + ", y=" + y + '}';
    }
}