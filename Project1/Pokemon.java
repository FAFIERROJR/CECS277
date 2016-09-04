/**
  *@author Francisco Fierro
  *Date: 8/22/2016
  *Program: Project 1
  *File: Pokemon.java
  *Description: daughter of Entity; abstract class for pokemon
*/

import java.lang.Math;

public abstract class Pokemon extends Entity{
    private int level;
    private int exp;
    private int nextLevelExp;


    /* Pokemon()
       Basic constructor 
       sets name and level
    */
    public Pokemon(String name, int level){
        super(name, 100);
        this.level = level;
        exp = 0;
        nextLevelExp = 1000;
    }

    public abstract int getType();

    public abstract int specialFight(int move);

    public abstract void displaySpecialMenu();

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
  
    /* gainExp()
       Increases exp by amount gained from battle
    */


    public void displayPokemon(){
        System.out.format("\n%s HP: %d LVL: %d\n", getName(), getHp(), level);
    }

    public int gainExp(int exp){
        this.exp = this.exp + exp;

        if(this.exp >= nextLevelExp){
            level += 1;
            System.out.println("\n%s leveled up!\n");
            this.exp = 0;
        }

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

    public int fight(int style, int move){
        int hit = 0;
        if(style == 1){
            hit = basicFight(move);
        }
        if(style == 2){
            hit = specialFight(move);
        }
        return hit;
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
