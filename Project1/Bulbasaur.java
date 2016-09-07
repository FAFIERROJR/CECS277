/**
 * Bulbasaur class simulates a Bulbasaur Pokemon
 *
 * @author Francisco Fierro
 *
 */

public class Bulbasaur extends Pokemon implements Grass{
   
    /**
      * Bulbasaur() simple constructor
      */    
    public Bulbasaur(){
        super("Bulbasaur", 1);
    }

    /**
     * getType() 
     * returns the Pokemon's element type
     *
     * @return  returns the Pokemon's element type
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
     * @param move      integer representing chosen move
     * @return          hit value 
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
     * vineWhip()
     * performs Vine Whip, displays, and returns hit value
     *
     * @return  the hit value of this attack
     */
    public int vineWhip(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Vine Whip", getName());
        return hit;
    }

    /**
     * razorLeaf()
     * performs Razor Leaf, displays, and returns hit value
     *
     * @return  the hit value of this attack
     *
     */
    public int razorLeaf(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Razor Leaf", getName());
        return hit;
    }

    /**
     * solarBeam()
     * performs Solar Beam, displays, and returns hit value
     *
     * @return  the hit value of this attack
     */
    public int solarBeam(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Solar Beam", getName());
        return hit;
    }
}
