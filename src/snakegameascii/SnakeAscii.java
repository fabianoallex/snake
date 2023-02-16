package snakegameascii;

import snakegame.Position;
import snakegame.Snake;
import snakegame.SnakePart;

public class SnakeAscii<T extends Position<?>> extends Snake<T> {
    private SnakeHeadAscii<T> head;

    @Override
    public SnakePartAscii<T> createNewPart(T position) {
        return new SnakePartAscii<>(position);
    }

    @Override
    public SnakePart<T> createHead(T position) {
        this.head = new SnakeHeadAscii<>(position);
        return this.head;
    }


    @Override
    public SnakeHeadAscii<T> getHead() {
        return head;
    }
}
