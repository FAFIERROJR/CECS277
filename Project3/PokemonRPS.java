import java.util.*;
import java.io.*;

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
		int difficulty = 0;

		File f = new File("Computer.dat");

		if(f.exists()){
			int lChoice;
			loadMenu();
			lChoice = CheckInput.checkIntRange(1,2);
			if(lChoice == 1){
				difficulty = 1;
			}

		}
		
		Computer cpu = new Computer(difficulty);

		System.out.println("Welcome to Pokemon: Rock, Paper, Scissors");
		do{

			cChoice = cpu.makePrediction(p);
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
					System.out.println("Thanks for playing!");
					save(cpu);
					System.exit(0);
				default:
					pChoice = 'x';
			}

			p = p + pChoice;

			if(p.length() == 21){
				p = p.substring(1);
			}

			cpu.addPattern(p);

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

	public static void displayOutcome(char pChoice, char cChoice, int didPWin, int pWins,
	int cWins, int rounds){
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
			((double)pWins / rounds));
		System.out.print(" CPU Wins: " + cWins
			+ " CPU Win %: " + ((double)cWins/rounds) +"\n");
	}

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

	public static Computer load(){
		File f = new File("Computer.dat");
		Computer c = new Computer(0);
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

	public static void loadMenu(){
		System.out.print("Game save found\n1. Continue\n2. New Game");
	}
}