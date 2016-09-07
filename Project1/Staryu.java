/**
 * Staryu class
 * Simulates a Staryu pokemon
 *
 * @author  Francisco Fierro
 */
public class Staryu extends Pokemon implements Water{
    /**
     * Staryu()
     * simple constructor
     *
     */
    public Staryu(){
        super("Staryu", 1);
    }

    
    /**
     * getType()
     * returns Pokemon type
     *
     * @return  the pokemon's type
     */
    @Override
    public int getType(){
        return type;
    }

    /**
     * displaySpecialMenu
     * displays special fight menu
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
     * @return          the hit value 
     *
     */
    @Override
    public int specialFight(int move){
        //switch case to handle chosen basic attack
        int hit = 0;
       switch(move){
            case 1:
                hit = waterGun();
                break;
            case 2:
                hit = bubbleBeam();
                break;
            case 3:
                hit = waterfall();
                break;
        }
        return hit;
    }

    /* The functions below are the special attacks unique to each Pokemon
       Each attack does random damage which is multiplied
       by the pokemon's level
    */
    public int waterGun(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Water Gun", getName());
        return hit;
    }

    public int bubbleBeam(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Bubble Beam", getName());
        return hit;
    }

    public int waterfall(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Waterfall", getName());
        return hit;
    }
}
