/**
 * Squirtle class
 * simulates a squirtle Pokemon
 *
 * @author  Francisco Fierro
 *
 */
public class Squirtle extends Pokemon implements Water{
    /**
     * Squirtle()
     * simple constructor
     *
     */
    public Squirtle(){
        super("Squirtle", 1);
    }

    /**
     * getType()
     * returns Pokemon type
     *
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
     * @param move   integer representing chosen move
     *
     */
    @Override
    public int specialFight(int move){
        /** switch case to handle chosen basic attack */
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

    /**
     * waterGun()
     * performs Water Gun, displays, and returns hit value
     *
     */
    public int waterGun(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Water Gun", getName());
        return hit;
    }

    /**
     * bubbleBeam()
     * performs Bubble Beam, displays, and returns hit value
     *
     */
    public int bubbleBeam(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Bubble Beam", getName());
        return hit;
    }

    /**
     * waterfall()
     * performs Water Fall, displays, and returns hit value
     *
     */
    public int waterfall(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Waterfall", getName());
        return hit;
    }

}
