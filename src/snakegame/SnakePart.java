package snakegame;

public class SnakePart<T extends Position<?>> implements Block<T> {
    private T position;

    public SnakePart(T position) {
        this.setPosition(position);
    }

    @Override
    public void setPosition(T position) {
        this.position = position;
    }

    @Override
    public T getPosition() {
        return this.position;
    }
}