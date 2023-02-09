package ascii;

import snakegame.SnakePart;

public class SnakePartAscii extends SnakePart<PointAscii> implements PointAscii {
    public SnakePartAscii(int x, int y) {
        super(x, y);
    }

    @Override
    public Character getCharacter() {
        return '~';
    }
}


