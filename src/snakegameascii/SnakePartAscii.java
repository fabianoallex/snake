package snakegameascii;

import snakegame.SnakePart;

public class SnakePartAscii extends SnakePart<BlockAscii> implements BlockAscii {
    public SnakePartAscii(int x, int y) {
        super(x, y);
    }

    @Override
    public Character getCharacter() {
        return '♦';
    }
}


