/**
 * Player class
 * defines characterics for the player
 * controlled character
 *
 * @author  Francisco Fierro
 *
 */
import java.io.*;
import java.awt.Point;

public class Player extends Trainer implements Serializable{
    /** number of potions */
    private int potions;
    /** number of pokeballs*/
    private int pokeballs;
    /** amount of money in wallet */
    private int money;

    private int level;
	
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
        level = 1;
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
    public String attackSpeech(){
        return "YOU: I choose you, " + getCurrentPokemon().getName() + "!";
    }

    /**
     * winSpeech()
     * prints celebratory speech
     *
     */
    public String winSpeech(){
        return "YOU: I won!";
    }

    /**
     * lossSpeech()
     * prints speech if player loses
     *
     */
    public String lossSpeech(){
        return "YOU: Oh no! I lost!";
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

    /**
     * getLocation()
     * returns current location of player
     * @return current location of player as Point
     */
    
    public Point getLocation(){
    	return location.getLocation();
    }

    /**
     * setLocation()
     * sets the location of player to given
     * Point
     * @param  p the point to which to set the player's current location
     * @return   true if the successfully set, else false
     */
    public boolean setLocation(Point p){
        if(p.getX() > -1 && p.getX() < 5){
            if(p.getY() > -1 && p.getY() < 5){
                location = p;
                return true;
            }
        }
        return false;
    }

    /**
     * goNorth()
     * moves the player up a point on the map
     * 
     * @param  m the Map instance
     * @return   the char at the new location, or meaningless char if out of bounds
     */
    public char goNorth(Map m){
        Point newLocation = new Point((int)location.getX() -1, (int)location.getY());
        if(setLocation(newLocation)){
            m.reveal(location);
            return m.getCharAtLoc(location);
        }
        return 'e';
    }

    /**
     * goSouth()
     * moves the player up a point on the map
     * 
     * @param  m the Map instance
     * @return   the char at the new location, or meaningless char if out of bounds
     */
    char goSouth(Map m){
    	Point newLocation = new Point((int)location.getX() + 1, (int)location.getY());
        if(setLocation(newLocation)){
            m.reveal(location);
            return m.getCharAtLoc(location);
        }
        return 'e';
    }

    /**
     * goEast()
     * moves the player down to the right a point on the map
     * 
     * @param  m the Map instance
     * @return   the char at the new location, or meaningless char if out of bounds
     */
    public char goEast(Map m){
    	Point newLocation = new Point((int)location.getX(), (int)location.getY() + 1);
        if(setLocation(newLocation)){
            m.reveal(location);
            return m.getCharAtLoc(location);
        }   
        return 'e';
    }
    
    /**
     * goWest()
     * moves the player to the left a point on the map
     * 
     * @param  m the Map instance
     * @return   the char at the new location, or meaningless char if out of bounds
     */
    public char goWest(Map m){
    	Point newLocation = new Point((int)location.getX(), (int)location.getY() - 1);
        if(setLocation(newLocation)){
            m.reveal(location);
            return m.getCharAtLoc(location);
        }
        return 'e';
    }

    /**
     * getLevel()
     * returns the number of the area the player
     * is currently or was most recently at
     * 
     * @return the player's area
     */
    public int getLevel(){
        return level;
    }

    /**
     * incLevel()
     * increments the players level(area)
     */
    public void incLevel(){
        level++;
    }
}

