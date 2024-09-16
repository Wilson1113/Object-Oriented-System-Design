package game.utils;

/**
 * A factory class for cloning objects using reflection.
 *
 * @param <T> The type of object to clone.
 */
public class CloningFactory<T> {
    private Class<T> clazz;

    /**
     * Constructor for CloningFactory.
     *
     * @param clazz The class of the object to clone.
     */
    public CloningFactory(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * Clones the object using reflection.
     *
     * @return A new instance of the cloned object.
     */
    public T cloning() {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
