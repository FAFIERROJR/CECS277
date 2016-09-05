/** 
 * Trainer class
 * outlines characteristics common to
 * Player and Opponent classes
 *
 * @author  Francisco Fierro
 *
 */

import java.util.*;

public abstract class Trainer extends Entity{
    private ArrayList<Pokemon> pokemon;
    int currentPokemon;

    /**
     * Trainer(String name, int hp)
     * Basic constructor for Trainer
     *
     * @param name  name to which to set Trainer's name
     * @param name  hit points to set for Trainer
     *
     */
    public Trainer(String name, int hp){
        super(name,hp);
        pokemon = new ArrayList<Pokemon>();
    }
    
    /**
     * attackSpeech()
     * prints speech at start of battle
     *
     */
    public abstract void attackSpeech();
        
    /**
     * winSpeech()
     * prints celebratory speech
     *
     */
    public abstract void winSpeech();
    
    /**
     * lossSpeech()
     * prints speech if player loses
     *
     */
    public abstract void lossSpeech();
    
    /**
     * chooseStyle()
     * prints  Style menu and prompts for user to choose style
     * returns int of chosen style
     *
     */
    public abstract int chooseStyle();
    
    /**
     * chooseMove()
     * prints move menu and prompts for user to choose move
     * based on chosen style, returns int of chosen move
     *
     * @param style represents chosen style
     *
     */
    public abstract int chooseMove(int style);
   
    /**
     * displayCurrentPokemon()
     * displays current pokemons's name, hp, level
     *
     */ 
    public void displayCurrentPokemon(){
        System.out.format("%s LVL: %d HP: %d\n", pokemon.get(currentPokemon).getName(),
            pokemon.get(currentPokemon).getLevel(), pokemon.get(currentPokemon).getHp());
    }
    
    /**
     * getCurrentPokemon()
     * returns current Pokemon
     *
     */
    public Pokemon getCurrentPokemon(){
        return pokemon.get(currentPokemon);
    }
    
    /**
     * addPokemon()
     * Adds a pokemon to the player's party
     *
     * @param p pokemon to be added to party
     *
     */
    public void addPokemon(Pokemon p){
        pokemon.add(p);
    }

    /**
     * listPokemon()
     * lists all pokemon in player's party
     *
     */
    public void listPokemon(){
        for(int i = 0; i < pokemon.size(); i++){
            System.out.format( i + 1 + ". %s LVL: %d HP: %d\n", pokemon.get(i).getName(),
            pokemon.get(i).getLevel(), pokemon.get(i).getHp());
        }
    }
    
    /**
     * healAllPokemon()
     * heals all pokemon in player's party
     *
     */
    public void healAllPokemon(){
        for(int i = 0; i < pokemon.size(); i++){
            pokemon.get(currentPokemon).gainHp(1000000);
        }
    }
    
    /**
     * setCurrentPokemon()
     * sets active pokemon for battling
     *
     * @param cur   index of pokemon to be set as current
     *
     */
    public Pokemon setCurrentPokemon(int cur){
        currentPokemon = cur;
        return pokemon.get(currentPokemon);
    }

    
    /**
     * getNextCurPokemon()
     * switches to next available pokemon
     *
     */
    public int getNextCurPokemon(){
        int i = 0;
        int j = currentPokemon;
            for(i = 0; i < pokemon.size(); i++){
                if(j == pokemon.size()) {
                    j = 0;
                }
                if(pokemon.get(j).getHp() > 0){
                    return j;
                }
            }
        return -1;
    }
    
    /**
     * battle()
     * handles trainer's end of a battle round
     *
     */
    public int battle(){
        int style;
        int move;
        int hit;

        style = chooseStyle();
        move = chooseMove(style);

        hit = getCurrentPokemon().fight(style, move);
        return hit;
    }
}
