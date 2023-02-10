package snakegameascii;

import snakegame.SnakeHead;

public class SnakeHeadAscii extends SnakeHead<BlockAscii> implements BlockAscii {
    public SnakeHeadAscii(int x, int y) {
        super(x, y);
    }

    @Override
    public Character getCharacter() {
        return '*';
    }
}
