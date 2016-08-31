/* Name: Francisco Fierro
   Date: 8/22/2016
   Program: Project 1
   File: Trainer.java
   Description: daughter of Entity; simulates a pokemon trainer
*/

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
        System.out.format("%s LVL: %d HP: %d\n", pokemon[currentPokemon].getName(),
            pokemon[currentPokemon].getLevel(), pokemon[currentPokemon].getHp());
    }
    
    public Pokemon getCurrentPokemon(){
        return pokemon[currentPokemon];
    }
    
    public void addPokemon(Pokemon p){
        pokemon.add(p);
    }

    public void listPokemon(){
        for( i = 0; i < pokemon.length; i++){
            System.out.format("%s LVL: %d HP: %d\n", pokemon[currentPokemon].getName(),
            pokemon[currentPokemon].getLevel(), pokemon[currentPokemon].getHp());
        }
    }
    
    public void healAllPokemon(){
        for( i = 0; i < pokemon.length; i++){
            pokemon[currentPokemon].gainHp(1000000);
        }
    }
    
    public Pokemon setCurrentPokemon(int cur){
        currentPokemon = cur;
    }

    
    public int getNextCurPokemon(){
        int i = 0;
        int j = cur;
          for(i = 0; i < pokemon.length; i++){
              if(j = pokemon.length) {
                  j = 0;
              }
              if(pokemon[j].getHp() > 0){
                  return pokemon;
          }
        return -1;
    }
    
    public int battle(){
    }
}
