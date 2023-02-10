package snakegame;

import java.util.ArrayList;
import java.util.List;

public abstract class Snake<T extends Block> implements Movable {
    private final List<SnakePart<T>> parts;
    private boolean isEating = false;

    public Snake() {
        parts = new ArrayList<>();
        parts.add(this.getHead());
    }

    public abstract SnakePart<T> createNewPart();
    public abstract SnakeHead<T> getHead();

    public List<SnakePart<T>> getParts() {
        return parts;
    }

    public void eat() {
        isEating = true;
    }

    private void grow() {
        var last = getParts().get(getParts().size()-1);
        int x = last.getX();
        int y = last.getY();

        SnakePart<T> newPart = createNewPart();
        newPart.moveTo(new BlockImp(x, y));
        getParts().add(newPart);
    }

    private void moveBodyAndCheckIsEating() {
        if (isEating) {
            this.grow();
            isEating = false;
        }

        BlockImp before = this.getHead();

        for (var part: parts) {
            var temp = new BlockImp(part.getX(), part.getY());
            part.moveTo(before);
            before = temp;
        }
    }

    @Override
    public void moveLeft() {
        moveBodyAndCheckIsEating();
        getHead().setX(getHead().getX()-1);
    }

    @Override
    public void moveRight() {
        moveBodyAndCheckIsEating();
        getHead().setX(getHead().getX()+1);
    }

    @Override
    public void moveDown() {
        moveBodyAndCheckIsEating();
        getHead().setY(getHead().getY()+1);
    }

    @Override
    public void moveUp() {
        moveBodyAndCheckIsEating();
        getHead().setY(getHead().getY()-1);
    }
}
