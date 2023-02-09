package ascii;

import snakegame.Display;

public abstract class DisplayAscii extends Display<PointAscii> {
    private final Character[][] points;

    public Character[][] getPoints() {
        return points;
    }

    public DisplayAscii(int height, int width) {
        super(height, width);
        points = new Character[height][width];
        this.clear();
    }

    private void clear() {
        for (int x = 0; x < this.getWidth(); x++)
            for (int y = 0; y < this.getHeight(); y++)
                this.write(x, y, ' ');
    }

    private void write(int x, int y, Character value) {
        points[y][x] = value;
    }

    @Override
    public void clear(PointAscii point) {
        this.write(point.getX(), point.getY(), ' ');
    }

    @Override
    public void draw(PointAscii point) {
        this.write(point.getX(), point.getY(), point.getCharacter());
    }

    @Override
    public abstract void render();
}
