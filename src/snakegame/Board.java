package snakegame;

public class Board<T extends Point> {
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

    public void draw(T point) {
        display.draw(point);
    }

    public void clear(T point) {
        display.clear(point);
    }
}
