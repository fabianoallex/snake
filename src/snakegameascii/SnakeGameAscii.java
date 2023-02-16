package snakegameascii;

import snakegame.*;

public abstract class SnakeGameAscii<B extends Block<?>, P extends Position<?>> extends SnakeGame<B, P> {
    protected SnakeGameAscii(Builder<BlockAscii> builder) {
        super(builder);
    }

    @Override
    protected AppleAscii createApple() {
        return new AppleAscii(0, 0);
    }

    @Override
    protected BoardAscii createBoard(Display<BlockAscii> display) {
        return new BoardAscii((DisplayAscii) display);
    }

    @Override
    protected SnakeAscii createSneak() {
        return new SnakeAscii();
    }
}
