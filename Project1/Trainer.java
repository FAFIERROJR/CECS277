/* Name: Francisco Fierro
   Date: 8/22/2016
   Program: Project 1
   File: Trainer.java
   Description: daughter of Entity; simulates a pokemon trainer
*/

public class Trainer extends Entity{
    private Pokemon pokemon;

    public Trainer(String name, int hp){
        super(name,hp);
    }
    
    public void displayPokemon(){
        System.out.println("\n");
        System.out.println(pokemon.getName());
        System.out.println(pokemon.getLevel());
        System.out.println(pokemon.getExp());
        System.out.println("\n");
    }

    public Pokemon getPokemon(){
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon){
        this.pokemon = pokemon;
    }
}
