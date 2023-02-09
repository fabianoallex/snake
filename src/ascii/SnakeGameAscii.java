package ascii;

import snakegame.*;

public abstract class SnakeGameAscii extends SnakeGame<PointAscii> {
    protected SnakeGameAscii(Builder builder) {
        super(builder);
    }

    @Override
    protected abstract DisplayAscii createDisplay();

    @Override
    protected abstract AppleAscii createApple();

    @Override
    protected BoardAscii createBoard() {
        return new BoardAscii((DisplayAscii) this.getDisplay());
    }

    @Override
    protected SnakeAscii createSneak() {
        return new SnakeAscii();
    }
}
