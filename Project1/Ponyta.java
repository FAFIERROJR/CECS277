/**
 * Ponyta class simulates a Ponyta Pokemon
 *
 * @author Francisco Fierro
 *
 */

public class Ponyta extends Pokemon implements Fire{
    /**
     * Ponyta()
     * simple constructor
     */
    public Ponyta(){
        super("Ponyta", 1);
    }

    /**
     * getType() 
     * returns the Pokemon's element type
     * 
     * @return  the pokemon's type
     *
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
     * @param move  integer representing chosen move
     * @return      the hit value
     */
    @Override
    public int specialFight(int move){
        /* switch case to handle chosen basic attack */
        int hit = 0;
        switch(move){
            case 1:
                hit = ember();
                break;
            case 2:
                hit = fireBlast();
                break;
            case 3:
                hit = firePunch();
                break;
        }
        return hit;
    }

    /**
     * ember()
     * performs Ember, displays, and returns hit value
     *
     * @return  this attack's hit value
     *
     */
    public int ember(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Ember", getName());
        return hit;
        
    }

    /**
     * fireBlast()
     * performs Fire Blast, displays, and returns hit value
     *
     * @return  this attack's hit value
     *
     */
    public int fireBlast(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Fire Blast", getName());
        return hit;
    }

    /**
     * firePunch()
     * performs Fire Punch, displays, and returns hit value
     *
     * @return  this attack's hit value
     *
     */
    public int firePunch(){
        int hit =  (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Fire Punch", getName());
        return hit;
    }

}
