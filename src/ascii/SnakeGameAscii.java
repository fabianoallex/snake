package ascii;

import snakegame.*;

public abstract class SnakeGameAscii extends SnakeGame<BlockAscii> {
    protected SnakeGameAscii(Builder builder) {
        super(builder);
    }

    @Override
    protected abstract DisplayAscii createDisplay();

    @Override
    protected AppleAscii createApple() {
        return new AppleAscii(0, 0);
    }

    @Override
    protected BoardAscii createBoard() {
        return new BoardAscii((DisplayAscii) this.getDisplay());
    }

    @Override
    protected SnakeAscii createSneak() {
        return new SnakeAscii();
    }
}
