/**
 * Charmander class simulates a Charmander Pokemon
 *
 * @author Francisco Fierro
 *
 */

import java.lang.Math;
import java.io.*;

public class Charmander extends Pokemon implements Fire, Serializable{

    /**
     * Charmander() 
     * simple constructor
     */    
    public Charmander(){
        super("Charmander", 1);
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
     * @return  the hit value of this attack
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
     *
     * @return  the hit value of this attack
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
     * @return  the hit value of this attack
     *
     */
    public int firePunch(){
        int hit =  (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Fire Punch", getName());
        return hit;
    }
}
