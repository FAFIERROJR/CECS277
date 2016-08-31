/* Name: Francisco Fierro
   Date: 8/22/2016
   Program: Project 1
   File: Trainer.java
   Description: daughter of Entity; simulates a pokemon trainer
*/

import java.util.*;

public abstract class Trainer extends Entity{
    private ArrayList<Pokemon> pokemon;
    int currentPokemon;

    /* Trainer(String name, int hp)
     * Basic constructor for Trainer
     * simply calls super(name,hp)
     */
    public Trainer(String name, int hp){
        super(name,hp);
    }
    
    public abstract void attackSpeech();
        
    public abstract void winSpeech();
    
    public abstract void lossSpeech();
    
    public abstract int chooseStyle();
    
    public abstract int chooseMove(int style);
   
    public void displayCurrentPokemon(){
        System.out.format("%s LVL: %d HP: %d\n", pokemon.get(currentPokemon).getName(),
            pokemon.get(currentPokemon).getLevel(), pokemon.get(currentPokemon).getHp());
    }
    
    public Pokemon getCurrentPokemon(){
        return pokemon.get(currentPokemon);
    }
    
    public void addPokemon(Pokemon p){
        pokemon.add(p);
    }

    public void listPokemon(){
        for(int i = 0; i < pokemon.size(); i++){
            System.out.format("%s LVL: %d HP: %d\n", pokemon.get(currentPokemon).getName(),
            pokemon.get(currentPokemon).getLevel(), pokemon.get(currentPokemon).getHp());
        }
    }
    
    public void healAllPokemon(){
        for(int i = 0; i < pokemon.size(); i++){
            pokemon.get(currentPokemon).gainHp(1000000);
        }
    }
    
    public Pokemon setCurrentPokemon(int cur){
        currentPokemon = cur;
        return pokemon.get(currentPokemon);
    }

    
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
