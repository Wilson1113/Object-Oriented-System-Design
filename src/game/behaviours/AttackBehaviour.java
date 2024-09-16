package game.behaviours;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actors.Behaviour;
import game.actions.AttackAction;
import game.capabilities.Status;

/**
 * A class representing the behaviour of attacking hostile actors.
 */
public class AttackBehaviour implements Behaviour {

    /**
     * A random number generator.
     */
    private final Random random = new Random();


    /**
     * Retrieves the action for attacking a hostile actor.
     *
     * @param actor The actor performing the behaviour.
     * @param map   The game map containing the actor.
     * @return An attack action targeting a hostile actor, or null if no valid action is found.
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<>();

        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            Actor hostile = destination.getActor();
            if (hostile != null && hostile.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                actions.add(new AttackAction(hostile, exit.getName()));
            }
        }

        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        }
        else {
            return null;
        }

    }
}
