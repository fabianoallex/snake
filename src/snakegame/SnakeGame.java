package snakegame;

import java.util.Random;

public abstract class SnakeGame<B extends Block<?>, P extends Position<?>> {
    public enum Direction {STOPED, UP, RIGHT, DOWN, LEFT};

    private final Board<B, P> board;
    private final Snake<P> snake;
    private final Apple<P> apple;

    private Direction direction = Direction.STOPED;

    protected boolean gameOver = false;

    protected SnakeGame(Builder<B, P> builder) {
        this.board = this.createBoard(builder.display);
        this.board.setTopLeftCornerX(builder.topLeftCornerBoardX);
        this.board.setTopLeftCornerY(builder.topLeftCornerBoardY);
        this.board.setWidth(builder.boardWidth);
        this.board.setHeight(builder.boardHeight);
        this.snake = this.createSneak();
        this.apple = this.createApple();
    }

    protected abstract Apple<P> createApple();

    protected abstract Board<B, P> createBoard(Display<B> display);

    protected abstract Snake<P> createSneak();

    protected abstract void randomAplle();

    protected abstract void updateDirectionSnake();

    public void moveSnake(Direction direction) {
        this.direction = direction;
    }

    public Board<B, P> getBoard() {
        return board;
    }

    public Snake<P> getSnake() {
        return snake;
    }

    public void run() {
        int cont = 0;
        while (!gameOver) {
            this.getBoard().clearSnake(this.getSnake());
            updateDirectionSnake();

            if (direction.equals(Direction.STOPED))
                continue;

            cont++;

            getBoard().drawSnake(getSnake());

            if (cont % 10 == 0) {
                randomAplle();
            }

            if (cont % 5 == 0) {
                snake.eat();
            }

            getBoard().render();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public abstract static class Builder<B extends Block<?>, P extends Position<?>> {
        protected int boardWidth = 10;
        protected int boardHeight = 10;
        private int topLeftCornerBoardX = 0;
        private int topLeftCornerBoardY = 0;
        protected Display<B> display;

        public Builder(Display<B> display) {
            this.display = display;
        }

        public Builder<B, P> withTopLeftCornerBoardX(int topLeftCornerBoardX) {
            this.topLeftCornerBoardX = topLeftCornerBoardX;
            return getThis();
        }

        public Builder<B, P> withTopLeftCornerBoardY(int topLeftCornerBoardY) {
            this.topLeftCornerBoardY = topLeftCornerBoardY;
            return getThis();
        }

        public Builder<B, P> withBoardWidth(int boardWidth) {
            this.boardWidth = boardWidth;
            return getThis();
        }

        public Builder<B, P> withBoardHeight(int boardHeight) {
            this.boardHeight = boardHeight;
            return getThis();
        }

        public abstract Builder<B, P> getThis();
        public abstract SnakeGame<B, P> build();
    }
}
