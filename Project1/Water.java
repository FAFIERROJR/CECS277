/**
 * Interface Water
 * outlines characteristics common to Water type
 * Pokemon
 *
 * @author  Francisco Fierro
 *
 */
public interface Water{
    /* int type stores an integer representing the Electric type */
    public static final int type = 0;
    /* String typeMenu stores special attack menu */
    public static final String typeMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall\n";

    /**
     * waterGun()
     * performs Water Gun, displays, and returns hit value
     *
     * @return  this attack's hit value
     *
     */
    public int waterGun();

    /**
     * bubbleBeam()
     * performs Bubble Beam, displays, and returns hit value
     *
     * @return  this attack's hit value
     *
     */
    public int bubbleBeam();

    /**
     * ember()
     * performs Ember, displays, and returns hit value
     *
     * @return  this attack's hit value
     *
     */
    public int waterfall();
}
