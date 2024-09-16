package game.weapon_items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;
import game.capabilities.Status;

/**
 * Represents a weapon item that can be used to attack actors.
 */
public class AttackItem extends WeaponItem {

    /**
     * Constructor for the AttackItem class.
     *
     * @param name The name of the item.
     * @param displayChar The character to use for display when the item is on the ground.
     * @param damage The amount of damage this weapon does.
     * @param verb The action verb associated with using this weapon.
     * @param hitRate The probability/chance to hit the target.
     */
    public AttackItem(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }

    /**
     * Returns a list of allowable actions for the weapon item.
     * Adds an AttackAction if the other actor is hostile to the player.
     *
     * @param otherActor The actor being targeted by the weapon item.
     * @param location The location of the other actor.
     * @return A list of allowable actions for the weapon item.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = super.allowableActions(otherActor, location);
        if (otherActor.hasCapability(Status.HOSTILE_TO_PLAYER)) {
            String direction = String.format("(%s, %s)", location.x(), location.y());
            actions.add(new AttackAction(otherActor, direction, this)); // Add an AttackAction if the other actor is hostile
        }
        return actions;
    }
}
