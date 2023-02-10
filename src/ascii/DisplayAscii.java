package ascii;

import snakegame.Display;

public abstract class DisplayAscii extends Display<BlockAscii> {
    private final Character[][] blocks;

    public Character[][] getBlocks() {
        return blocks;
    }

    public DisplayAscii(int height, int width) {
        super(height, width);
        blocks = new Character[height][width];
        this.clear();
    }

    private void clear() {
        for (int x = 0; x < this.getWidth(); x++)
            for (int y = 0; y < this.getHeight(); y++)
                this.write(x, y, ' ');
    }

    private void write(int x, int y, Character value) {
        blocks[y][x] = value;
    }

    @Override
    public void clear(BlockAscii block) {
        this.write(block.getX(), block.getY(), ' ');
    }

    @Override
    public void draw(BlockAscii block) {
        this.write(block.getX(), block.getY(), block.getCharacter());
    }

    @Override
    public abstract void render();
}
