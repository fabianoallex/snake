package snakegame;

public class Board<T extends Block> {
    private final Display<T> display;
    private int topLeftCornerX;
    private int topLeftCornerY;
    private int height;
    private int width;

    public Board(Display<T> display) {
        this.display = display;
        this.topLeftCornerX = 0;
        this.topLeftCornerY = 0;
        this.height = display.getHeight();
        this.width = display.getWidth();
    }

    public void setTopLeftCornerX(int topLeftCornerX) {
        this.topLeftCornerX = topLeftCornerX;
    }

    public void setTopLeftCornerY(int topLeftCornerY) {
        this.topLeftCornerY = topLeftCornerY;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getTopLeftCornerX() {
        return topLeftCornerX;
    }

    public int getTopLeftCornerY() {
        return topLeftCornerY;
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
