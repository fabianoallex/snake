package snakegame;

import java.util.ArrayList;
import java.util.List;

public abstract class Snake<T extends Position<?>> {
    private final List<SnakePart<T>> parts;
    private boolean isEating = false;

    public Snake() {
        parts = new ArrayList<>();
        parts.add(this.getHead());
    }

    public abstract SnakePart<T> createNewPart(T position);
    public abstract SnakePart<T> createHead(T position);
    public abstract SnakeHead<T> getHead();

    public List<SnakePart<T>> getParts() {
        return parts;
    }

    public void eat() {
        isEating = true;
    }

    private void grow() {
        var lastPart = getParts().get(getParts().size()-1);
        SnakePart<T> newPart = createNewPart(lastPart.getPosition());
        getParts().add(newPart);
    }


    private void moveSnake() {
        T previousPosition = this.getHead().getPosition();

        for (var part: parts) {
            T temp = part.getPosition();
            part.setPosition(previousPosition);
            previousPosition = temp;
        }
    }

    private void checkIsEating() {
        if (isEating) {
            this.grow();
            isEating = false;
        }
    }

    public void moveTo(T position) {
        checkIsEating();
        moveSnake();
        getHead().setPosition(position);
    }
}
