package snakegame;

public class MovableBlockImp extends BlockImp implements Movable, Block {
    public MovableBlockImp(int x, int y) {
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

    public void moveTo(BlockImp block) {
        this.setX(block.getX());
        this.setY(block.getY());
    }
}