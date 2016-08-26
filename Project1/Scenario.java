
public class Scenario{
    private String[] textArray;
    private int[] pokeArray;
        

    public Scenario(){
         textArray = new String[] {"\nA wild Charmander appeared",
            "\nA wild Pikachu appeared",
            "\nIt's Misty!\nMisty: Have you seen my bike?",
            "\nIt's you rival, Gary\n Gary: You're pokemon are weak.",
            "\nIt's a Team Rocket thug. Thug: Youre the kid who's been meddling in our work"};
        pokeArray = new int[] {2,1,1,2,1};
    }

    public String getScenario(int choice){
        return textArray[choice];
    }

    public Pokemon getPokemon(int choice){
        Pokemon pokemon;
        if(pokeArray[choice] == 1){
            pokemon = new Pikachu();
        }
        else{
            pokemon = new Charmander();
        }
        return pokemon;
    }

    public int length(){
        return textArray.length;
    }
}
    
