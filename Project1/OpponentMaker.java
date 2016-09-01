public class OpponentMaker{
    static Opponent makeRandomOpponent(){
        Opponent opponent;
        Pokemon pokemon;
        Pokemon pokemon2 = null;
        String name;
        int randomType;
        int randomHealth;
        
        randomType = (int) (Math.round(Math.random() * 10));
        randomHealth = (int) (100 + 50 * Math.round(Math.random() * 3));

        switch(randomType){
            case 0:
                name = "BUG CATCHER";
                pokemon = PokemonMaker.makeTypePokemon(2);
                break;
            case 1:
                name = "MISTY";
                pokemon = PokemonMaker.makeTypePokemon(1);
                break;
            case 2:
                name = "TEAM ROCKET";
                pokemon = PokemonMaker.makeTypePokemon(0);
                pokemon2 = PokemonMaker.makeTypePokemon(3);
                break;
            case 3:
                name = "FISHERMAN";
                pokemon = PokemonMaker.makeTypePokemon(1);
                break;
            case 4:
                name = "GARY";
                pokemon = PokemonMaker.makeTypePokemon(3);
                pokemon2 = PokemonMaker.makeTypePokemon(1);
                break;
            default:
                name = "TRAINER";
                pokemon = PokemonMaker.makeTypePokemon(2);
                break;
        }
        
        System.out.println("\nIt's " + name + "!\n");

        opponent = new Opponent(name, randomHealth, randomType);
        opponent.addPokemon(pokemon);
        if(pokemon2 != null){
            opponent.addPokemon(pokemon2);
        }
        return opponent;        
    }
}
