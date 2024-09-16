package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.CloningFactory;
import game.utils.Utility;
import game.items.Fruit;

/**
 * A class representing a tree that grows and drops fruits over time.
 * Extends the Ground class from the FIT2099 game engine.
 */
public abstract class Tree extends Ground {

    /** The age of the tree, measured in ticks */
    private int age = 0;

    /** The percentage chance that the tree will drop fruits during each tick */
    private int percentage;

    /** The type of fruit dropped by the tree */
    private CloningFactory<? extends Fruit> fruitDrop;

    /**
     * Constructor for the Tree class.
     * Initializes a tree with a display character, fruit drop chance, and type of fruit.
     *
     * @param displayChar The display character representing the tree on the map.
     * @param percentage The percentage chance of dropping fruits when the tree matures.
     * @param fruitDrop The type of fruit to drop when the tree matures.
     */
    public Tree(char displayChar, int percentage, CloningFactory<? extends Fruit> fruitDrop) {
        super(displayChar);
        this.percentage = percentage;
        this.fruitDrop = fruitDrop;
    }

    /**
     * Overrides the tick method to update the tree's age and possibly drop fruits based on chance.
     * If the tree reaches an age where it drops fruits, it adds a new fruit item to a random adjacent location.
     *
     * @param location The location of the tree.
     */
    @Override
    public void tick(Location location) {
        if (Utility.chanceOfTrue(percentage)) {
            Utility.getRandomExitLocation(location).addItem(getFruitDrop());
        }
        age++;
    }

    /**
     * Retrieves the age of the tree.
     *
     * @return The age of the tree, measured in ticks.
     */
    public int getAge() {
        return age;
    }

    /**
     * Retrieves a new instance of the fruit to be dropped by the tree.
     *
     * @return A new instance of the fruit.
     */
    public Fruit getFruitDrop() {
        return fruitDrop.cloning();
    }
}
