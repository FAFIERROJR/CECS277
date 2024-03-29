/**
 * OpponentMaker class
 * contains static functions to be used by main
 * to create Opponents
 *
 * @author Francisco Fierro
 *
 */
 
import java.util.*;
import java.io.*;

public class OpponentMaker{
	private ArrayList<Opponent> opponentList;

	/**
     * OpponentMaker()
     * Constructor
     * Initializes ArrayList<Opponent>
     * with opponent templates read from file
     * "OpponentList.txt"
     */
	public OpponentMaker(){
		int hp;
		String name;
		String atkSpeech;
		String winSpeech;
		String lossSpeech;
		String fileName = "OpponentList.txt";
        opponentList = new ArrayList<Opponent>();
		
		try{
			Scanner reader = new Scanner(new File(fileName));

			while(reader.hasNext()){
				name = reader.nextLine();
				hp = reader.nextInt();
                reader.nextLine();
				atkSpeech = reader.nextLine();
                atkSpeech = atkSpeech.replace('#', '\n');
                lossSpeech = reader.nextLine();
                lossSpeech = lossSpeech.replace('#', '\n');
				winSpeech = reader.nextLine();
                winSpeech = winSpeech.replace('#', '\n');
				
                Opponent opp = new Opponent(name, hp, atkSpeech, lossSpeech, winSpeech);
				opponentList.add(opp);
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			System.out.print(fileName + " not found");
		}
	}

    /**
     * makeRandomOpponent()
     * makes and returns a random opponent
     * from the ArrayList templates
     *
     * @return  the randomly generated opponent
     */
    public Opponent makeRandomOpponent(){
        Opponent opponent;
        Pokemon pokemon = null;
        Pokemon pokemon2 = null;
        int random;
        
        random = (int) (Math.round(Math.random() * 2));
        
        opponent = new Opponent(opponentList.get(random).getName(), opponentList.get(random).getHp(),
        	opponentList.get(random).attackSpeech(), opponentList.get(random).lossSpeech(),
        	opponentList.get(random).winSpeech());

        if(opponent.getName().equals("Lass")){
            pokemon = PokemonMaker.makeTypePokemon(2);
        }
        else if(opponent.getName().equals("Bug Catcher")){
            pokemon = PokemonMaker.makeTypePokemon(1);
        }
        else if(opponent.getName().equals("Team Rocket")){
            pokemon = PokemonMaker.makeTypePokemon(0);
            pokemon2 = PokemonMaker.makeTypePokemon(3);
        }
        opponent.addPokemon(pokemon);
        if(pokemon2 != null){
        	opponent.addPokemon(pokemon2);
    	}
        
        System.out.println("\nIt's " + opponent.getName() + "!");

        return opponent;        
    }
}
