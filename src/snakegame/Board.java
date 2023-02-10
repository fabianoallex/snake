package snakegame;

public class Board<T extends Block> {
    private final Display<T> display;
    private final int leftCornerX;
    private final int leftCornerY;

    public Board(Display<T> display, int leftCornerX, int leftCornerY) {
        this.display = display;
        this.leftCornerX = leftCornerX;
        this.leftCornerY = leftCornerY;
    }

    public Board(Display<T> display) {
        this(display, 0, 0);
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

    public void render() {
        this.display.render();
    }

    public Display<T> getDisplay() {
        return display;
    }
}
