package snakegame;

public interface Position <T extends Position<?>> {
    void moveTo(T position);
}

