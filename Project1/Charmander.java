/* Name: Francisco Fierro
   Date: 8/22/2016
   Program: Project 1
   File: Trainer.java
   Description: daughter of Pokemon class; simulates a Charmander
*/

import java.lang.Math;

public class Charmander extends Pokemon implements Fire{
    public Charmander(){
        super("Charmander", 1);
    }

    @Override
    public int getType(){
        return type;
    }

    @Override
    public void displaySpecialMenu(){
        System.out.println(typeMenu);
    }

    @Override
    public int specialFight(int move){
        //switch case to handle chosen basic attack
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

    public int ember(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Ember", getName());
        return hit;
        
    }

    public int fireBlast(){
        int hit = (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Fire Blast", getName());
        return hit;
    }

    public int firePunch(){
        int hit =  (int)(25 * Math.random()) + 3 * getLevel();
        System.out.format("%s used Fire Punch", getName());
        return hit;
    }
}
