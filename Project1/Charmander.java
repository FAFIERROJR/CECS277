/* Name: Francisco Fierro
   Date: 8/22/2016
   Program: Project 1
   File: Trainer.java
   Description: daughter of Pokemon class; simulates a Charmander
*/

import java.lang.Math;

public class Charmander extends Pokemon{
    public Charmander(){
        super("Charmander", 1);
    }


    @Override
    public void displaySpecialMenu(){
        System.out.println("\t1. Ember");
        System.out.println("\t2. Fire Blast" );
        System.out.println("\t3. Fire Punch");
    }

    @Override
    public int specialFight(int move){
        //switch case to handle chose basic attack
        int hit = 0;
        switch(move){
            case 1:
                hit = ember();
                System.out.format("%s used Ember", getName());
                break;
            case 2:
                hit = fireBlast();
                System.out.format("%s used Fire Blast", getName());
                break;
            case 3:
                hit = firePunch();
                System.out.format("%s used Fire Punch", getName());
                break;
        }
        return hit;
    }

    public int ember(){
        return (int)(25 * Math.random()) + 3 * getLevel();
    }

    public int fireBlast(){
        return (int)(25 * Math.random()) + 3 * getLevel();
    }

    public int firePunch(){
        return (int)(25 * Math.random()) + 3 * getLevel();
    }
}
