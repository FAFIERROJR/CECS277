/**
 * Pokemon class
 * defines characteristics common to all Pokemon
 *
 * @author Francisco Fierro
 */
import java.lang.Math;

public abstract class Pokemon extends Entity{
    private int level;
    private int exp;
    private int nextLevelExp;


    /**
     * Pokemon()
     * Basic constructor 
     * sets name and level
     *
     * @param name  Name of Pokemon
     * @param level Pokemons level
     *
     */
    public Pokemon(String name, int level){
        super(name, 100);
        this.level = level;
        exp = 0;
        nextLevelExp = 1000;
    }

    /**
     * abstract getType()
     * returns Pokemon type
     *
     * @return  Pokemon's type
     *
     */
    public abstract int getType();

    /**
     * abstract specialFight()
     * handles the determination and execution of
     * an attack move; prints Pokemon-like attack dialog
     *
     * @param move  represents attack chosen
     * @return      the hit value
     */    
    public abstract int specialFight(int move);

    /**
     * abstract void displaySpecialMenu()
     * displays special fight menu
     *
     */
    public abstract void displaySpecialMenu();

    /**
     * getLevel()
     * returns level
     *
     * @return  the Pokemon's level
     */
    public int getLevel(){
        return level;
    }

    /**
     * setLevel()
     * sets Pokemon's level
     *
     * @param level integer to set Pokemon's level
     * 
     */
    public void setLevel(int level){
        this.level = level;
    }
  
    /**
     * displayPokemon()
     * diplays Pokemon's name Hp and Level
     *
     */
    public void displayPokemon(){
        System.out.format("\n%s HP: %d LVL: %d\n", getName(), getHp(), level);
    }


    /**
     * gainExp()
     * Increases exp by amount gained from battle
     *
     * @param exp   amount by which to increase EXP
     * @return      this pokemon's exp
     *
     */
    public int gainExp(int exp){
        this.exp = this.exp + exp;

        if(this.exp >= nextLevelExp){
            level += 1;
            System.out.println("\n%s leveled up!\n");
            this.exp = 0;
        }

        return this.exp;
    }

    /**
     * getExp()
     * returns EXP value
     *
     * @return  this pokemon's exp
     *
     */
    public int getExp(){
        return exp;
    }

    /**
     * displayBasicMenu()
     * displays Menu for basic attacks
     */
    public void displayBasicMenu(){
        System.out.println("1. Slam");
        System.out.println("2. Tackle");
        System.out.println("3. Mega Punch");
    }


    /**
     * basicFight()
     * determines which basic attack was chosen and
     * executes it
     *
     * @param move  represents chosen move
    */
    public int basicFight(int move){
        /* switch case to handle chose basic attack */
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

    /**
     * fight()
     * handles execution of move
     * by calling basicFight or specialFight()
     * returns hit value
     *
     * @param style     represents chosen attack style
     * @param move      represents chosen attack move
     * @return          the hit value
     *
     */
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
    
    /**
     * slam()
     * performs Slam, displays, and returns hit value
     *
     * @return  this attack's hit value
     *
     */
    public int slam(){
        return (int)(20 * Math.random()) + 3 * level;
    }

    /**
     * tackle()
     * performs Tackle, displays, and returns hit value
     *
     * @return  this attack's hit value
     *
     */
    public int tackle(){
        return (int)(20 * Math.random()) + 3 * level;
    }

    /**
     * megaPunch()
     * performs Mega Punch, displays, and returns hit value
     *
     * @return  this attack's hit value
     *
     */
    public int megaPunch(){
        return (int)(20 * Math.random()) + 3 * level;
    }
}
