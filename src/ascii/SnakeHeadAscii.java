package ascii;

import snakegame.SnakeHead;

public class SnakeHeadAscii extends SnakeHead<PointAscii> implements PointAscii {
    public SnakeHeadAscii(int x, int y) {
        super(x, y);
    }

    @Override
    public Character getCharacter() {
        return '*';
    }
}
