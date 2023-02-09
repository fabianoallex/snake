package snakegame;

public abstract class Display<T extends Point> {
    private final int height;
    private final int width;

    public Display(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public abstract void render();
    public abstract void draw(T point);
    public abstract void clear(T point);
}
