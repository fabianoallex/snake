package snakegame;

public class MovablePointImp extends PointImp implements Movable, Point {
    public MovablePointImp(int x, int y) {
        super(x, y);
    }

    @Override
    public void moveLeft() {
        this.setX(this.getX()-1);
    }

    @Override
    public void moveRight() {
        this.setX(this.getX()+1);
    }

    @Override
    public void moveDown() {
        this.setY(this.getY()+1);
    }

    @Override
    public void moveUp() {
        this.setY(this.getY()-1);
    }

    public void moveTo(PointImp pointImp) {
        this.setX(pointImp.getX());
        this.setY(pointImp.getY());
    }
}