package snakegameascii;

import snakegame.Position;
import snakegame.SnakePart;

public class SnakePartAscii<T extends Position<?>> extends SnakePart<T> implements BlockAscii<T> {
    public SnakePartAscii(T position) {
        super(position);
    }

    @Override
    public Character getCharacter() {
        return '♦';
    }
}


