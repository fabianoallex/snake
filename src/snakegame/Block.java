package snakegame;

public interface Block<T extends Position<?>> {
    void setPosition(T position);

    T getPosition();
}