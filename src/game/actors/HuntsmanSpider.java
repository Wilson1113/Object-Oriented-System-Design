package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.behaviours.AttackBehaviour;
import game.capabilities.Status;
import game.behaviours.WanderBehaviour;

import java.util.HashMap;
import java.util.Map;

/**
 * A class representing a Huntsman Spider actor in the game.
 * Huntsman Spider can wander and attack hostile enemies.
 */
public class HuntsmanSpider extends Actor {

    /**
     * Map of behaviours associated with the Huntsman Spider.
     * Key: Priority of the behaviour
     * Value: Behaviour object
     */
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor for HuntsmanSpider class.
     * Initializes the Huntsman Spider with default name, display character, and hit points.
     * Also initializes its behaviours: wandering and attacking.
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.behaviours.put(999, new WanderBehaviour());
        this.behaviours.put(1, new AttackBehaviour());
        this.addCapability(Status.HOSTILE_TO_PLAYER);
    }

    /**
     * At each turn, selects a valid action to perform.
     *
     * @param actions    Collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        The map containing the Actor
     * @param display    The I/O object to which messages may be written
     * @return The valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }

        return new DoNothingAction();
    }

    /**
     * Determines the allowable actions for the Huntsman Spider.
     * It can be attacked by any actor that has the HOSTILE_TO_ENEMY capability.
     *
     * @param otherActor The Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        Current GameMap
     * @return A list of allowable actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }

    /**
     * Retrieves the intrinsic weapon of the Huntsman Spider.
     *
     * @return The intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "attacks", 25);
    }

}
