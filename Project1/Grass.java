/**
 * Interface Grass
 * outlines characteristics common to Grass type
 * Pokemon
 *
 * @author  Francisco Fierro
 *
 */
public interface Grass{
    /** int type stores an integer representing the Electric type */
    public static final int type = 2;
    /** String typeMenu stores special attack menu */
    public static final String typeMenu = "1 .Vine Whip\n2. Razor Leaf\n3. Solar Beam";

    /**
     * vineWhip();
     * performs Vine Whip, displays, and returns hit value
     *
     * @return  the hit value of this attack
     *
     */
    public int vineWhip();
    
    /**
     * razorLeaf();
     * performs Razor Leaf, displays, and returns hit value
     *
     * @return  the hit value of this attack
     *
     */
    public int razorLeaf();

    /**
     * solarBeam();
     * performs Solar Beam, displays, and returns hit value
     *
     * @return  the hit value of this attack
     *
     */
    public int solarBeam();
}
