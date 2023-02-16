package snakegame;

public class SnakeHead<T extends Position<?>> extends SnakePart<T> {
    public SnakeHead(T position) {
        super(position);
    }
}
