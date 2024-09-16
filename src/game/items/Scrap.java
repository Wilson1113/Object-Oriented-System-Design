package game.items;

import edu.monash.fit2099.engine.items.Item;

/**
 * Represents scraps, a type of item.
 */
public class Scrap extends Item {

    /**
     * Constructor.
     *
     * @param name        The name of the scraps.
     * @param displayChar The character to use for display when the scraps are on the ground.
     */
    public Scrap(String name, char displayChar) {
        super(name, displayChar, true);
    }
}
