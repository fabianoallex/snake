package snakegame;

import java.util.Random;

public abstract class SnakeGame<T extends Block> {
    public enum Direction {STOPED, UP, RIGHT, DOWN, LEFT};

    private final Display<T> display;
    private final Board<T> board;
    private final Snake<T> snake;
    private final Apple<T> apple;

    private final int displayHight;
    private final int displayWidth;
    private Direction direction = Direction.STOPED;

    protected boolean gameOver = false;

    protected SnakeGame(Builder builder) {
        this.displayWidth = builder.displayWidth;
        this.displayHight = builder.displayHeight;
        this.display = this.createDisplay();
        this.board = this.createBoard();
        this.snake = this.createSneak();
        this.apple = this.createApple();
    }

    protected abstract Apple<T> createApple();

    protected abstract Display<T> createDisplay();

    protected abstract Board<T> createBoard();

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

    public Display<T> getDisplay() {
        return display;
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

            getDisplay().render();
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

    public abstract static class Builder {
        protected int displayWidth = 10;
        protected int displayHeight = 10;

        public Builder withDisplayWidth(int displayWidth) {
            this.displayWidth = displayWidth;
            return this;
        }

        public Builder withDisplayHeight(int displayHeight) {
            this.displayHeight = displayHeight;
            return this;
        }

        public abstract Builder getThis();
        public abstract SnakeGame<?> build();
    }
}
