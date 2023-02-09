package ascii;

import snakegame.Apple;

public class AppleAscii extends Apple<PointAscii> implements PointAscii {
    public AppleAscii(int x, int y) {
        super(x, y);
    }

    @Override
    public Character getCharacter() {
        return 'A';
    }
}
