package snakegameswing;

import ascii.SnakeGameAscii;
import snakegame.SnakeGame;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGameTextArea extends SnakeGameAscii {
    protected SnakeGameTextArea(Builder builder) {
        super(builder);
    }

    @Override
    protected DisplayTextArea createDisplay() {
        var display = new DisplayTextArea(this.getDisplayHight(), getDisplayWidth());
        configEventsOfTextArea(display.getTextArea());
        return display;
    }

    private void configEventsOfTextArea(JTextArea textArea) {
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (gameOver)
                    return;

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) moveSnake(Direction.RIGHT);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) moveSnake(Direction.DOWN);
                if (e.getKeyCode() == KeyEvent.VK_LEFT) moveSnake(Direction.LEFT);
                if (e.getKeyCode() == KeyEvent.VK_UP) moveSnake(Direction.UP);

                e.consume();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
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
