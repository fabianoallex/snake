package snakegam2D;

import snakegame.Position;

public class Position2D implements Position<Position2D> {
    private int x;
    private int y;

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveRight() {
        this.x++;
    }

    public void moveDown() {
        this.y++;
    }

    public void moveUp() {
        this.y--;
    }

    @Override
    public void moveTo(Position2D position) {
        this.x = position.getX();
        this.y = position.getY();
    }
}
