package snakegameascii;

import snakegame.Block;
import snakegame.Position;

public interface BlockAscii<T extends Position<?>> extends Block<T> {
    Character getCharacter();
}
