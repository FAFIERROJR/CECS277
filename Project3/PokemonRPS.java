import java.util.*;
import java.io.*;

/**
 * PokemonRPS
 * the main class for Pokemon Rock, Paper, Scissors
 *
 * @author Francisco Fierro
 */

public class PokemonRPS{
	public static void main(String args[]){
		int pWins = 0;
		int cWins = 0;
		int rounds = 0;
		int pInput;
		char pChoice;
		char cChoice;
		int didPWin = 0;
		String p = "";
        Computer cpu;
        int lChoice = 0;
		File f = new File("Computer.dat");

		if(f.exists()){
			loadMenu();
			lChoice = CheckInput.checkIntRange(1,2);
			if(lChoice == 1){
				cpu = load();
			}
            else{
                cpu = new Computer();
            }
        }
        else{
            cpu = new Computer();
        }
		

		System.out.println("Welcome to Pokemon: Rock, Paper, Scissors");
		do{

            //make a predication
			cChoice = cpu.makePrediction(p);

            //player chooses
			displayMenu();
			pInput = CheckInput.checkIntRange(1,4) - 1;

			switch(pInput){
				case 0:
					pChoice = 'f';
					break;
				case 1:
					pChoice = 'w';
					break;
				case 2:
					pChoice = 'g';
					break;
				case 3:
					System.out.println("Would you like to save?\n1. Yes\n2. No");
					int saveChoice = CheckInput.checkIntRange(1,2);
					if(saveChoice == 1){
						save(cpu);
					}
					System.out.println("Thanks for playing!");
					System.exit(0);
				default:
					pChoice = 'x';
			}

			p = p + pChoice;

			if(p.length() == 21){
				p = p.substring(1);
			}

			cpu.addPattern(p);

            //determine and display outcome
			didPWin = determineOutcome(pChoice, cChoice);

			switch(didPWin){
				case -1:
					cWins++;
					rounds++;
					break;
				case 1:
					pWins++;
					rounds++;
					break;
				default:
					break;
			}

			displayOutcome(pChoice, cChoice, didPWin, pWins, cWins, rounds);
			
		}while(pInput != -1);


	}

    /**
     * displayMenu()
     * displays menu for player choices
     * 
     */
	public static void displayMenu(){
		System.out.println("1. Fire\n2. Water\n3. Grass\n4. Quit");
	}

	public static int determineOutcome(char pChoice, char cChoice){
		if(pChoice == cChoice){
			return 0;
		}
		if(pChoice == 'f' && cChoice == 'g'){
			return 1;
		}
		if(pChoice == 'w' && cChoice == 'f'){
			return 1;
		}
		if(pChoice == 'g' && cChoice == 'w'){
			return 1;
		}
		return -1;
	}

    /**
     * displayOutcome()
     * displays outcome readout
     * @param pChoice char representing player choice
     * @param cChoice char representing cpu choice
     * @param didPWin integer representing win/loss/draw
     * @param pWins   number of player wins
     * @param cWins   number of computer wins
     * @param rounds  number of decisive rounds
     */
	public static void displayOutcome(char pChoice, char cChoice, int didPWin, int pWins,
	int cWins, int rounds){
        int pWinper = 0;
        int cWinper = 0;

        if(rounds != 0){
            pWinper = 100* pWins / rounds;
            cWinper = 100 * cWins / rounds;
        }

		System.out.println("You chose  " + translateChoice(pChoice));
		System.out.println("CPU chooses " + translateChoice(cChoice));

		if(didPWin == 1){
			System.out.println("You win!");
		}
		else if (didPWin == -1){
			System.out.println("You lose!");
		}
		else{
			System.out.println("Draw!");
		}
		System.out.print("\nPlayer Wins: " + pWins + " Player Win %: "  +
			pWinper);
		System.out.print(" CPU Wins: " + cWins
			+ " CPU Win %: " + cWinper +"\n");
	}


    /**
     * translateChoice()
     * translates a player/cpu choice from char to string
     * containing the corresponding word
     * 
     * @param  choice char representing cpu/player choice
     * @return        corresponding word: Fire, Water, Grass
     */
	public static String translateChoice(char choice){
		switch(choice){
			case 'f':
				return "Fire";
			case 'w':
				return "Water";
			case 'g':
				return "Grass";
			default:
				return "";
		}
	}

    /**
     * save
     * saves the computer object to file
     * 
     * @param c the computer object
     */
	public static void save(Computer c){
		File f = new File("Computer.dat");

		try{
			ObjectOutputStream writer = new ObjectOutputStream(
				new FileOutputStream(f));
			writer.writeObject(c);
			writer.close();
		}
		catch(IOException e){
			System.out.println("Error writing to file");
		}
    }


    /**
     * load()
     * loads computer object from file
     * @return the loaded computer object
     */
	public static Computer load(){
		File f = new File("Computer.dat");
		Computer c = new Computer();
		try{
			if(f.exists()){
				ObjectInputStream reader = new ObjectInputStream(
					new FileInputStream(f));
				c = (Computer) reader.readObject();
				reader.close();
			}
		}
		catch(IOException e){
			System.out.println("Error reading file");
		}
		catch(ClassNotFoundException e){
			System.out.print("Class mismatch when reading from file");
		}

		return c;
	}

    /**
     * loadMenu()
     * displays menu for loading saved computer
     */
	public static void loadMenu(){
		System.out.println("Game save found\n1. Use Saved Computer\n2. New Game");
	}
}