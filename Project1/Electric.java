/**
 * Interface Electric
 * outlines characteristics common to Electric type
 * Pokemon
 *
 */
public interface Electric{
    /* int type stores an integer representing the Electric type */
    public static final int type = 3;
    /* String typeMenu stores special attack menu */
    public static final String typeMenu = "1. Thunder Shock\n2. Thunderbolt\n3.Thunder Punch";

    /**
     * thunderShock()
     * performs Thunder Shock, displays, and returns hit value
     *
     * return  the hit value of this attack
     *
     */
    public int thunderShock();

    /**
     * thunderbolt()
     * performs Thunderbolt, displays, and returns hit value
     *
     * @return  the hit value of this attack
     *
     */
    public int thunderbolt();

    /**
     * thunderPunch();
     * performs Thunder Punch, displays, and returns hit value
     *
     * @return  the hit value of this attack
     *
     */
    public int thunderPunch();
}
