package snakegame;

import java.util.Random;

public abstract class SnakeGame<T extends Point> {
    private final int displayHight;
    private final int displayWidth;

    private final Display<T> display;
    private final Board<T> board;
    private final Snake<T> snake;
    private final Apple<T> apple;
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

            if (cont < getDisplayWidth()-1) getSnake().moveRight();
            else if (cont < getDisplayWidth()+getDisplayHight()-2) getSnake().moveDown();
            else if (cont < getDisplayWidth()*2+getDisplayHight()-3) getSnake().moveLeft();
            else if (cont < getDisplayWidth()*2+getDisplayHight()*2-4) getSnake().moveUp();
            else cont = -1;

            cont++;

            if (cont % 5 == 0) {
                getSnake().eat();
            }

            getBoard().drawSnake(getSnake());

            if (cont % 10 == 0) {
                randomAplle();
            }

            getDisplay().render();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
