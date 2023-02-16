package snakegame;

public class Board<B extends Block<?>, P extends Position<?>> {
    private final Display<B> display;
    private int topLeftCornerX;
    private int topLeftCornerY;
    private int height;
    private int width;

    public Board(Display<B> display) {
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

    public void clearSnake(Snake<P> snake) {
        snake.getParts().forEach(snakePart -> {
            display.clear((B) snakePart);
        });
    }

    public void drawSnake(Snake<P> snake) {
        snake.getParts().forEach(snakePart -> {
            display.draw((B) snakePart);
        });
    }

    public void draw(B block) {
        display.draw(block);
    }

    public void clear(B block) {
        display.clear(block);
    }

    public void render() {
        this.display.render();
    }

    public Display<B> getDisplay() {
        return display;
    }
}
