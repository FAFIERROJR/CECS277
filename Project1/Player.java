/**
 * Player class
 * defines characterics for the player
 * controlled character
 *
 * @author  Francisco Fierro
 *
 */
public class Player extends Trainer{
    /** int potions = number of potions */
    private int potions;
    /** int pokeballs = number of pokeballs*/
    private int pokeballs;
    private int money;

    /**
     * Player()
     * simple constructor
     * sets name, hp, potions money, pokeballs
     * 
     * @param name  name of player
     * @param hp    player's hit points
     *
     */
    public Player(String name, int hp){
        super(name, hp);
        potions = 5;
        money = 500;
        pokeballs = 10;
    }

    /**
     * usePotion()
     * heals current pokemon and decrements potion
     *
     */
    public void usePotion(){
        if(potions > 0){
            getCurrentPokemon().gainHp(50);
            System.out.format("%s gained 50 HP\n", getCurrentPokemon().getName());
            potions--;
        }
        else{
            System.out.println("You're out of potions!");
        }    
    }

    /**
     * getNumPotionsLeft()
     * returns number of potions
     *
     */
    public int getNumPotionsLeft(){
        return potions;
    }

    /**
     * buyPotion()
     * returns number of potions
     *
     */
    public void buyPotion(){
        potions++;
    }

    /**
     * usePokeball()
     * decrements pokeballs
     *
     */
    public void usePokeball(){
        pokeballs--;
    }

    /**
     * getNumbPokeballsLeft()
     * returns number of remaining pokeballs
     * 
     */
    public int getNumPokeballsLeft(){
        return pokeballs;
    }

    /**
     * buyPokeball()
     * increments pokeballs
     */
    public void buyPokeball(){
        pokeballs++;
    }

    /**
     * spendMoney()
     * decrement money by input amount
     *
     * @param price amount by which to decrement money
     */
    public void spendMoney(int price){
        money -= price;
    }

    /**
     * attackSpeech()
     * prints speech at start of battle
     *
     */
    public void attackSpeech(){
        System.out.println("YOU: I choose you, " + getCurrentPokemon().getName() + "!");
    }

    /**
     * winSpeech()
     * prints celebratory speech
     *
     */
    public void winSpeech(){
        System.out.println("YOU: I won!");
    }

    /**
     * lossSpeech()
     * prints speech if player loses
     *
     */
    public void lossSpeech(){
        System.out.println("YOU: Oh no! I lost!");
    }

    /**
     * chooseStyle()
     * prints  Style menu and prompts for user to choose style
     * returns int of chosen style
     *
     */
    public int chooseStyle(){
        System.out.println("\t1. Basic");
        System.out.println("\t2. Special");

        int style = CheckInput.checkInt();
        return style;
    }

    /**
     * chooseMove()
     * prints move menu and prompts for user to choose move
     * based on chosen style, returns int of chosen move
     *
     * @param style represents chosen style
     *
     */
    @Override
    public int chooseMove(int style){
        int move;
        switch(style){
            case 1:          
                getCurrentPokemon().displayBasicMenu();
                break;
            case 2:
                getCurrentPokemon().displaySpecialMenu();
                break;
        }
        move = CheckInput.checkInt();
        return move;
    }
}
