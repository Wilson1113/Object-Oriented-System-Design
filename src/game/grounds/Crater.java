package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.CloningFactory;
import game.actors.HuntsmanSpider;
import game.utils.Utility;

/**
 * A class representing a crater on the game map.
 * Craters can spawn actors at random intervals.
 */
public class Crater extends Ground {

    /**
     * A factory for cloning actors to be spawned in the crater.
     */
    private static CloningFactory<? extends Actor> spawn = new CloningFactory<>(HuntsmanSpider.class);

    /**
     * Constructor for the Crater class.
     * Initializes the crater with a display character.
     */
    public Crater() {
        super('u');
    }

    /**
     * Constructor for the Crater class with custom actor spawn.
     * Initializes the crater with a display character and sets the actor spawn factory.
     *
     * @param spawn The actor to be spawned in the crater.
     */
    public Crater(Actor spawn) {
        super('u');
        Crater.spawn = new CloningFactory<>(spawn.getClass());
    }

    /**
     * Overrides the tick method to potentially spawn actors in the crater.
     * If the location is empty and a random chance condition is met, a new actor is spawned.
     *
     * @param location The location of the crater.
     */
    @Override
    public void tick(Location location) {
        if (!location.containsAnActor() && Utility.chanceOfTrue(5)) {
            // Add a new actor to the location
            location.addActor(spawn.cloning());
        }
    }
}
