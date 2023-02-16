package snakegameascii;

import snakegame.Position;
import snakegame.SnakeHead;

public class SnakeHeadAscii<T extends Position<?>> extends SnakeHead<T> implements BlockAscii<T> {
    public SnakeHeadAscii(T position) {
        super(position);
    }

    @Override
    public Character getCharacter() {
        return '☺';
    }
}
