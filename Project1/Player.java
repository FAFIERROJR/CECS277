/**
 * Player class
 * defines characterics for the player
 * controlled character
 *
 * @author  Francisco Fierro
 *
 */
import Java.awt.Point;

public class Player extends Trainer{
    /** number of potions */
    private int potions;
    /** number of pokeballs*/
    private int pokeballs;
    /** amount of money in wallet */
    private int money;
	
	private Point location;
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
     * @return  number of potions
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
     * @return  number of pokeballs
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
     *
     * @return  the user-chosen style
     *
     */
    public int chooseStyle(){
        int style = 0;

        System.out.println("1. Basic");
        System.out.println("2. Special");

        do{
            style = CheckInput.checkInt();
            if(style < 1 || style > 2){
                System.out.println("That's not an option. Try again");
            }
        }while(style < 1 || style > 2);
        return style;
    }

    /**
     * chooseMove()
     * prints move menu and prompts for user to choose move
     * based on chosen style, returns int of chosen move
     *
     * @param style     represents chosen style
     * @return          the user-chose move
     */
    @Override
    public int chooseMove(int style){
        int move = 0;
        switch(style){
            case 1:          
                getCurrentPokemon().displayBasicMenu();
                break;
            case 2:
                getCurrentPokemon().displaySpecialMenu();
                break;
        }
        do{
            move = CheckInput.checkInt();
            if(move < 1 || move > 3){
                System.out.println("That's not an option. Try again");
            }
        }while(move < 1 || move > 3);
        return move;
    }
    
    public Point getLocation(){
    	return location.getLocation();
    }
    
    public boolean setLocation(Point p){
        if(p.getX() > -1 && p.getX() < 5){
            if(p.getY() > -1 && p.getY() < 5){
                location = p;
                return true;
            }
        }
        return false
    }
    
    public char goNorth(Map m){
        if(setLocation(location.getX(), location.getY() - 1){
            m.revealLocation(location);
            return m.getCharAt(location);
        }
        return null;
    }
    
    char goSouth(Map m){
    	if(setLocation(location.getX(), location.getY() + 1){
            m.revealLocation(location);
            return m.getCharAt(location);
        }
        return null;
    }
    
    char goEast(Map m){
    	if(setLocation(location.getX() - 1, location.getY()){
            m.revealLocation(location);
            return m.getCharAt(location);
        }
        return null;
    }
    
    char goWest(Map m){
    	if(setLocation(location.getX() + 1, location.getY()){
            m.revealLocation(location);
            return m.getCharAt(location);
        }
        return null;
    }
}

