public class PokemonMaker{
    public static Pokemon makeWildPokemon(){
        Pokemon pokemon;
        int random = (int) Math.round(Math.random() * 7);

        switch(random){
            case 0:
                pokemon = new Pikachu();
                break;
            case 1:
                pokemon = new Zapdos();
                break;
            case 2:
                pokemon = new Charmander();
                break;
            case 3:
                pokemon = new Ponyta();
                break;
            case 4:
                pokemon = new Squirtle();
                break;
            case 5:
                pokemon = new Staryu();
                break;
            case 6:
                pokemon = new Bulbasaur();
                break;
            case 7:
                pokemon = new Oddish();
                break;
            default:
                pokemon = new Pikachu();
                break;
        }
        
        return pokemon;
    }

    public static Pokemon makeTypePokemon(int type){
        int random = (int)Math.round(Math.random());
        Pokemon pokemon;

        switch(type){
            case 0:
                if(random == 0){
                    pokemon = new Charmander();
                }
                else{
                    pokemon = new Ponyta();
                }
                break;
            case 1:
                if(random == 0){
                    pokemon = new Squirtle();
                }
                else{
                    pokemon = new Staryu();
                }
                break;
            case 2:
                if(random == 0){
                    pokemon = new Bulbasaur();
                }
                else{
                    pokemon = new Oddish();
                }
                break;
            case 3:
                if(random == 0){
                    pokemon = new Pikachu();
                }
                else{
                    pokemon = new Zapdos();
                }
                break;
            default:
                pokemon = new Pikachu();
                break;
    
        }
    
        return pokemon;
    }

    public static Pokemon makePokemonStart(int start){
        Pokemon pokemon;
        switch(start){
            case 1:
                    pokemon = new Charmander();
            case 2:
                    pokemon = new Squirtle();

            case 3:
                    pokemon = new Bulbasaur();
                break;
            case 4:
                    pokemon = new Pikachu();
            default:
                pokemon = new Pikachu();
                break;
        }
        return pokemon;
    }
}
