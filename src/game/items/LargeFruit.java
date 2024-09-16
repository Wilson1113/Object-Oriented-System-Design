package game.items;

/**
 * Represents a large fruit item in the game.
 * Extends the Fruit class from the game items package.
 */
public class LargeFruit extends Fruit {

    /**
     * Constructor for the LargeFruit class.
     * Initializes a large fruit item with a name, display character, and heal rate.
     */
    public LargeFruit() {
        super("Large Food", 'O', 2); // Large fruit heals for 2 HP
    }
}
