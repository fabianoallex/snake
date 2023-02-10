package snakegame;

import java.util.Random;

public abstract class SnakeGame<T extends Block> {
    public enum Direction {STOPED, UP, RIGHT, DOWN, LEFT};

    private final Board<T> board;
    private final Snake<T> snake;
    private final Apple<T> apple;

    private final int displayHight;
    private final int displayWidth;
    private Direction direction = Direction.STOPED;

    protected boolean gameOver = false;

    protected SnakeGame(Builder<T> builder) {
        this.displayWidth = builder.boardWidth;
        this.displayHight = builder.boardHeight;
        this.board = this.createBoard(builder.display);
        this.snake = this.createSneak();
        this.apple = this.createApple();
    }

    protected abstract Apple<T> createApple();

    protected abstract Board<T> createBoard(Display<T> display);

    protected abstract Snake<T> createSneak();

    public void moveSnake(Direction direction) {
        this.direction = direction;
    }

    public int getDisplayHight() {
        return displayHight;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public Board<T> getBoard() {
        return board;
    }

    public Snake<T> getSnake() {
        return snake;
    }

    private void randomAplle() {
        getBoard().clear((T) apple);

        Random random = new Random();

        int x = random.nextInt(this.displayWidth);
        int y = random.nextInt(this.displayHight);

        apple.setX(x);
        apple.setY(y);

        getBoard().draw((T) apple);
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

    private void updateDirectionSnake() {
        if (direction.equals(Direction.UP)) {
            getSnake().moveUp();
        } else if (direction.equals(Direction.RIGHT)) {
            getSnake().moveRight();
        } else if (direction.equals(Direction.DOWN)) {
            getSnake().moveDown();
        } else if (direction.equals(Direction.LEFT)) {
            getSnake().moveLeft();
        }
    }

    public abstract static class Builder<T extends Block> {
        protected int boardWidth = 10;
        protected int boardHeight = 10;
        protected Display<T> display;

        public Builder(Display<T> display) {
            this.display = display;
        }

        public Builder<T> withBoardWidth(int boardWidth) {
            this.boardWidth = boardWidth;
            return this;
        }

        public Builder<T> withBoardHeight(int boardHeight) {
            this.boardHeight = boardHeight;
            return this;
        }

        public abstract Builder<T> getThis();
        public abstract SnakeGame<T> build();
    }
}
