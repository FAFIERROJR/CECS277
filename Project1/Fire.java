/**
 * Interface Fire
 * outlines characteristics common to Fire type
 * Pokemon
 *
 * @author  Francisco Fierro
 *
 */
public interface Fire{
    /** int type stores an integer representing the Electric type */
    public static final int type = 0;
    /** String typeMenu stores special attack menu */
    public static final String typeMenu = "1. Ember\n2. Fire Blast\n3. Fire Punch";

    /**
     * Ember()
     * performs Ember, displays, and returns hit value
     *
     */
    public int ember();

    /**
     * fireBlast()
     * performs Fire Blast, displays, and returns hit value
     *
     */
    public int fireBlast();

    /**
     * thunderPunch();
     * performs Thunder Punch, displays, and returns hit value
     */
    public int firePunch();
}
