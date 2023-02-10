package snakegame;

public class Board<T extends Block> {
    private final Display<T> display;

    public Board(Display<T> display) {
        this.display = display;
    }

    public void clearSnake(Snake<T> snake) {
        snake.getParts().forEach(snakePart -> {
            display.clear((T) snakePart);
        });
    }

    public void drawSnake(Snake<T> snake) {
        snake.getParts().forEach(snakePart -> {
            display.draw((T) snakePart);
        });
    }

    public void draw(T block) {
        display.draw(block);
    }

    public void clear(T block) {
        display.clear(block);
    }
}
