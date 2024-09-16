package game.grounds;

import edu.monash.fit2099.engine.positions.Location;
import game.utils.CloningFactory;
import game.items.SmallFruit;

/**
 * Represents a tree that grows and drops fruits over time, with the ability to evolve into another type of tree.
 * Extends the Tree class from the FIT2099 game engine.
 */
public class Inheritree extends Tree {

    /**
     * The age at which the tree evolves into the next tree type.
     */
    private int growAge = 5;

    /**
     * A factory for cloning the next tree type.
     */
    private static CloningFactory<? extends Tree> nextTree = new CloningFactory<>(MatureTree.class);

    /**
     * Constructor for the Inheritree class.
     * Initializes an Inheritree with a display character, fruit drop chance, fruit drop type, grow age, and the next tree type.
     */
    public Inheritree() {
        super('t', 30, new CloningFactory<>(SmallFruit.class));
    }

    /**
     * Constructor for the Inheritree class with custom next tree type.
     * Initializes an Inheritree with a display character, fruit drop chance, fruit drop type, and sets the next tree type.
     *
     * @param nextTree The next tree type to evolve into.
     */
    public Inheritree(Tree nextTree) {
        super('t', 30, new CloningFactory<>(SmallFruit.class));
        Inheritree.nextTree = new CloningFactory<>(nextTree.getClass());
    }

    /**
     * Overrides the tick method to update the tree's age and possibly evolve into the next tree type.
     * If the tree reaches the specified age, it changes into the next tree type.
     *
     * @param location The location of the tree.
     */
    @Override
    public void tick(Location location) {
        if (getAge() == growAge) {
            location.setGround(nextTree.cloning());
        }
        super.tick(location); // Perform default tick actions (e.g., fruit dropping)
    }
}
