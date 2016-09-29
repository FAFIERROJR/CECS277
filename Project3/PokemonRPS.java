public class PokemonRPS{
	public static void main(String args[]){
		int pWins = 0;
		int cWins = 0;
		int rounds = 0;
		int pInput;
		char pChoice;
		char cChoice;
		int didPWin = 0;
		Computer cpu = new Computer();
		String p = "";

		System.out.println("Welcome to Pokemon: Rock, Paper, Scissors");
		do{
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
				case 3:
					System.out.println("Thanks for playing!");
					System.exit(0);
				default:
					pChoice = 'x';
			}

			p = p + pChoice;

			if(p.length() == 5){
				p = p.substring(1);
			}

			cChoice = cpu.makePrediction(p);
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
				return "Error";
		}
	}
}