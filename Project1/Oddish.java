/**
 * Oddish class
 * simulates Oddish Pokemon
 *
 * @author  Francisco Fierro
 *
 */

public class Oddish extends Pokemon implements Grass{
    
    /**
     * Oddish() 
     * simple constructor
     *
     */  
    public Oddish(){
        super("Oddish", 1);
    }

    /**
     * getType() 
     * returns the Pokemon's element type
     *
     * @return   the pokemon's type
     */
    @Override
    public int getType(){
        return type;
    }


     /**
     * displaySpecialMenu()
     * diplays special fight menu
     *
     */
    @Override
    public void displaySpecialMenu(){
        System.out.println(typeMenu);
    }

    /**
     * specialFight()
     * handles the determination and execution of
     * an attack move; prints Pokemon-like attack dialog
     *
     * @param move   integer representing chosen move
     *
     */
    @Override
    public int specialFight(int move){
        /* switch case to handle chosen basic attack */
        int hit = 0;
       switch(move){
            case 1:
                hit = vineWhip();
                break;
            case 2:
                hit = razorLeaf();
                break;
            case 3:
                hit = solarBeam();
                break;
        }
        return hit;
    }

    /**
     * vineWhip();
     * performs Vine Whip, displays, and returns hit value
     *
     * @return      this attack's hit value
     */
    public int vineWhip(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Vine Whip", getName());
        return hit;
    }

    /**
     * razorLeaf();
     * performs Razor Leaf, displays, and returns hit value
     *
     * @return      this attack's hit value
     *
     */
    public int razorLeaf(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Razor Leaf", getName());
        return hit;
    }

    /**
     * solarBeam();
     * performs Razor Leaf, displays, and returns hit value
     *
     * @return      this attack's hit value
     *
     */
    public int solarBeam(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Solar Beam", getName());
        return hit;
    }
}
