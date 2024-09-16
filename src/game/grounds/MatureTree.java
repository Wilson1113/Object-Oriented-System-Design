package game.grounds;

import game.utils.CloningFactory;
import game.items.LargeFruit;

/**
 * Represents a mature tree on the game map.
 * Extends the Tree class from the FIT2099 game engine.
 */
public class MatureTree extends Tree {

    /**
     * Constructor for the MatureTree class.
     * Initializes a MatureTree with a display character 'T' and a default fruit drop chance of 20%.
     */
    public MatureTree() {
        super('T', 20, new CloningFactory<>(LargeFruit.class)); // 'T' represents a mature tree, 20% chance of dropping fruit, and SmallFruit as the fruit type
    }
}
