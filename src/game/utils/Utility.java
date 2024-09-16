package game.utils;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;

/**
 * Utility class containing static helper methods for various purposes in the game.
 */
public class Utility {

    /** A random number generator used by utility methods requiring randomness */
    private static Random rand = new Random();

    /**
     * Determines if an event with a given percentage chance occurs.
     *
     * @param percentage The percentage chance of the event occurring, ranging from 0 to 100.
     * @return True if the event occurs, false otherwise.
     */
    public static boolean chanceOfTrue(int percentage) {
        return (rand.nextInt(100) < percentage);
    }

    /**
     * Retrieves a random Exit from a list of Exits.
     *
     * @param location The location from which exits are obtained.
     * @return A randomly selected Location from the provided list of exits.
     */
    public static Location getRandomExitLocation(Location location) {
        List<Exit> exits = location.getExits();
        return exits.get(rand.nextInt(exits.size())).getDestination();
    }


}
