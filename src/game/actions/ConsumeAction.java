package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * Represents an action where an actor consumes a consumable item, possibly affecting its health or other attributes.
 */
public class ConsumeAction extends Action {

    /** The actor that is consuming the item. */
    private Actor target;

    /** The consumable item being consumed. */
    private Consumable item;

    /**
     * Constructor for the ConsumeAction.
     *
     * @param target The actor consuming the item.
     * @param item The consumable item being consumed.
     */
    public ConsumeAction(Actor target, Consumable item) {
        this.target = target;
        this.item = item;
    }

    /**
     * Executes the consumption action, removing the item from the actor's inventory and applying its effects.
     *
     * @param actor The actor performing the action.
     * @param map The game map where the action is performed.
     * @return A string describing the result of the action.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return item.consume(actor); // Apply the item's consumption effect
    }

    /**
     * Provides a description of the consume action for display in the user interface.
     *
     * @param actor The actor performing the action.
     * @return A string describing the action for display in the user interface.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + item + " for " + item.function(); // Display the action description
    }
}
