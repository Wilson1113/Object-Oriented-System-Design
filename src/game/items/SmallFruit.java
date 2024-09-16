package game.items;

/**
 * Represents a small fruit item in the game.
 * Extends the Fruit class from the game items package.
 */
public class SmallFruit extends Fruit {

    /**
     * Constructor for the SmallFruit class.
     * Initializes a small fruit item with a name, display character, and heal rate.
     */
    public SmallFruit() {
        super("Small Food", 'o', 1); // Small fruit heals for 1 HP
    }
}
