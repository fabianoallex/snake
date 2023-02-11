package snakegameascii;

import snakegame.Apple;

public class AppleAscii extends Apple<BlockAscii> implements BlockAscii {
    public AppleAscii(int x, int y) {
        super(x, y);
    }

    @Override
    public Character getCharacter() {
        return '☼';
    }
}
