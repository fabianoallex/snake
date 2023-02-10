package ascii;

import snakegame.Snake;

public class SnakeAscii extends Snake<BlockAscii> {
    private SnakeHeadAscii head;

    @Override
    public SnakePartAscii createNewPart() {
        return new SnakePartAscii(0, 0);
    }

    @Override
    public SnakeHeadAscii getHead() {
        if (head == null)
            head = new SnakeHeadAscii(0,0);

        return head;
    }
}
