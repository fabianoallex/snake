package snakegameswing;

import ascii.AppleAscii;
import ascii.SnakeGameAscii;
import snakegame.SnakeGame;

public class SnakeGameTextArea extends SnakeGameAscii {
    protected SnakeGameTextArea(Builder builder) {
        super(builder);
    }

    @Override
    protected AppleAscii createApple() {
        return new AppleAscii(0, 0);
    }

    @Override
    protected DisplayTextArea createDisplay() {
        return new DisplayTextArea(this.getDisplayHight(), getDisplayWidth());
    }

    @Override
    public DisplayTextArea getDisplay() {
        return (DisplayTextArea) super.getDisplay();
    }

    public static class Builder extends SnakeGame.Builder {
        @Override
        public Builder getThis() {
            return this;
        }

        @Override
        public SnakeGameTextArea build() {
            return new SnakeGameTextArea(this);
        }
    }
}
