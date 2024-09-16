package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

/**
 * Represents a fruit item that can be consumed for healing actions.
 */
public abstract class Fruit extends Item implements Consumable {

    /** The amount of health points this fruit item can heal */
    private int healRate;

    /**
     * Constructor for the Fruit class.
     *
     * @param name The name of the fruit item.
     * @param displayChar The character to use for display when the item is on the ground.
     * @param healRate The amount of health points this fruit item can heal.
     */
    public Fruit(String name, char displayChar, int healRate) {
        super(name, displayChar, true);
        this.healRate = healRate;
    }

    /**
     * Returns a list of allowable actions for the fruit item.
     * Adds a ConsumeAction to the actions list.
     *
     * @param owner The actor who owns this fruit item.
     * @return A list of allowable actions for the fruit item.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(owner, this)); // Add a ConsumeAction to allow consuming the fruit
        return actions;
    }

    /**
     * Consumes the fruit, healing the given actor.
     *
     * @param actor The actor consuming the fruit.
     * @return A string describing the result of consuming the fruit.
     */
    @Override
    public String consume(Actor actor) {
        actor.removeItemFromInventory(this);
        actor.heal(healRate); // Heal the actor by the specified heal rate
        return actor + " healed for " + healRate + " HP";
    }

    /**
     * Provides a description of the function of the fruit item.
     *
     * @return A string describing the function of the fruit item.
     */
    @Override
    public String function() {
        return "healing " + healRate + " HP";
    }
}
