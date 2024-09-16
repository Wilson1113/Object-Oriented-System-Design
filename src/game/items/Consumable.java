package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface representing a consumable item in the game.
 * Allows items to be consumed and describes their function.
 */
public interface Consumable {

    /**
     * Consumes the item, performing its effect on the given actor.
     *
     * @param actor The actor consuming the item.
     * @return A string describing the result of consuming the item.
     */
    String consume(Actor actor);

    /**
     * Provides a description of the function of the item.
     *
     * @return A string describing the function of the item.
     */
    String function();
}
