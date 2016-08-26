/* Name: Francisco Fierro
   Date: 8/22/2016
   Program: Project 1
   File: Trainer.java
   Description: daughter of Pokemon; simulates a Pikachu
*/

import java.lang.Math;

public class Pikachu extends Pokemon{
    public Pikachu(){
        super("Pikachu", 1);
    }

    @Override
    public void displaySpecialMenu(){
        System.out.println("\t1. Thunder Shock");
        System.out.println("\t2. Thunder Bolt" );
        System.out.println("\t3. Thunder Punch");
    }

    /* specialFight()
       handles the determination and execution of
       an attack move; prints Pokemon-like attack dialog
    */

    @Override
    public int specialFight(int move){
        //switch case to handle chose basic attack
        int hit = 0;
       switch(move){
            case 1:
                hit = thunderShock();
                System.out.format("%s used Thunder Shock", getName());
                break;
            case 2:
                hit = thunderBolt();
                System.out.format("%s used Thunder Bolt", getName());
                break;
            case 3:
                hit = thunderPunch();
                System.out.format("%s used Thunder Punch", getName());
                break;
        }
        return hit;
    }

    /* The functions below are the special attacks unique to each Pokemon
       Each attack does random damage which is multiplied
       by the pokemon's level
    */
    public int thunderShock(){
        return (int)(25 * Math.random()) + 3 * getLevel();
    }

    public int thunderBolt(){
        return (int)(25 * Math.random()) + 3 * getLevel();
    }

    public int thunderPunch(){
        return (int)(25 * Math.random()) + 3 * getLevel();
    }

}
