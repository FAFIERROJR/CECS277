/**
 * Interface Grass
 * outlines characteristics common to Grass type
 * Pokemon
 *
 */
public interface Grass{
    /** int type stores an integer representing the Electric type */
    public static final int type = 2;
    /** String typeMenu stores special attack menu */
    public static final String typeMenu = "1 .Vine Whip\n2. Razor Leaf\n3. Solar Beam";

    /**
     * vinWhip();
     * performs Vine Whip, displays, and returns hit value
     */
    public int vineWhip();
    
    /**
     * razorLeaf();
     * performs Razor Leaf, displays, and returns hit value
     */
    public int razorLeaf();

    /**
     * solarBeam();
     * performs Solar Beam, displays, and returns hit value
     */
    public int solarBeam();
}
