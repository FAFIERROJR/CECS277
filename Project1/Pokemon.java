/* Name: Francisco Fierro
   Date: 8/22/2016
   Program: Project 1
   File: Pokemon.java
   Description: daughter of Entity; simulates a pokemon
*/

import java.lang.Math;

public class Pokemon extends Entity{
    private int level;
    private int exp;


    /* Pokemon()
       Basic constructor 
       sets name and level
    */
    public Pokemon(String name, int level){
        super(name, 100);
        this.level = level;
        exp = 0;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
  
    /* gainExp()
       Increases exp by amount gained from battle
    */

    public int gainExp(int exp){
        this.exp = this.exp + exp;
        return this.exp;
    }

    public int getExp(){
        return exp;
    }

    /* displayBasicMenu()
       displays Menu for basic attacks
    */

    public void displayBasicMenu(){
        System.out.println("\t1. Slam");
        System.out.println("\t2. Tackle");
        System.out.println("\t3. Mega Punch");
    }


    /* basicFight()
       determines which basic attack was chosen and
       executes it
    */
    public int basicFight(int move){
        //switch case to handle chose basic attack
        int hit = 0;
        switch(move){
            case 1:
                hit = slam();
                System.out.format("%s used Slam", getName());
                break;
            case 2:
                hit = tackle();
                System.out.format("%s used Tackle", getName());
                break;
            case 3:
                hit = megaPunch();
                System.out.format("%s used Mega Punch", getName());
                break;
        }
        return hit;
    }

    /* displaySpecialMenu()
       displays menu for Special attacks
    */
    public void displaySpecialMenu(){
    }

    /* specialFight()
       determines which special attack was chosen and
       executes it. Unique to each pokemon. So just a stub here.
    */
    public int specialFight(int move){
        return 0;
    }
    
    /* The functions below are the basic attacks common to all Pokemon
       Each attack does random damage which is multiplied
       by the pokemon's level
    */
    public int slam(){
        return (int)(20 * Math.random()) + 3 * level;
    }

    public int tackle(){
        return (int)(20 * Math.random()) + 3 * level;
    }

    public int megaPunch(){
        return (int)(20 * Math.random()) + 3 * level;
    }
}
