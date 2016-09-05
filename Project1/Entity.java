/**
 * Entity class
 * defines characteristics common to player, opponent and
 * Pokemon
 *
 * @author Francisco Fierro
 *
 */
public abstract class Entity{
    private String name;
    private int hp;
    private int maxHp;

    /**
     * Entity()
     * Basic constructor
     * Sets name and hp to provided values
     */
    public Entity(String name, int hp){
        this.name = name;
        this.hp = hp;
        maxHp = hp;
    }
    
    /**
     * getName()
     * returns name of entity
     *
     */
    public String getName(){
        return name;
    }

    public int getHp(){
        return hp;
    }

    /**
     * loseHp()
     * handles hit point loss due to hit
     *
     * @param hit   stores returned hit value
     *
     */
    public int loseHp(int hit){
        hp = hp - hit;
        if(hp < 0){
            hp = 0;
        }
        return hp;
    }

    /**
     * gainHp()
     * handles hit point gain due to heal
     *
     * @param heal  int by which entity is healed
     *
     */
    public int gainHp(int heal){
        hp = hp + heal;
        if(hp > maxHp){
            hp = maxHp;
        }
        return hp;
    }
    
    /**
     * incMaxHp()
     * increases maximum hit points
     *
     */
    public void incMaxHp(){
        maxHp += 50;
    }
}
