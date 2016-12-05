import java.net.*;
import java.io.*;
import java.util.*;
/**
 * Server.java
 * Handles all game aspects except GUI and User input
 * @author Francisco Fierro
 */
public class Server extends Thread{
	private ServerSocket server;
	private Socket sock;
	private BufferedReader read;
	private PrintStream write;
	private Computer cpu;
	private String patternString;
	private int pWins;
	private int cWins;
	private int rounds;
	private char cChoice;

	/**
	 * Server()
	 * Initializes networking objects and
	 * game variables
	 */
	public Server(){
		try{
			server = new ServerSocket(1080);
			sock = server.accept();
			read = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			write = new PrintStream(sock.getOutputStream());
			patternString = "";
			File f = new File("Computer.dat");
			if(f.exists()){
				cpu = load();
			}
			else cpu = new Computer();
			pWins = 0;
			cWins = 0;
			rounds = 0;

		}
		catch(IOException e){
			e.printStackTrace();
		}
	}


	/**
	 * run()
	 * Waits for input from client
	 * then runs an iteration of the game
	 */
	public void run(){
		while(true){
			try{
				patternString = read.readLine();
				game();
			}
			catch(IOException e){
				e.printStackTrace();
				try{
					server.close();
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * main()
	 * Instantiates a Server and starts its thread
	 * @param args[] [description]
	 */
	public static void main(String args[]){
		Server s = new Server();
		s.start();
	}

	/**
	 * game()
	 * Acts as the main function for the game
	 * Makes prediction, stores pattern, determines outcome
	 * saves to file, and sends results to client
	 */
	public void game(){
		int pInput;
		char pChoice = patternString.charAt(patternString.length() - 1);
		int didPWin = 0;

            //make a prediction
			cChoice = cpu.makePrediction(patternString.substring(0,patternString.length() - 1));

			//add pattern to cpu
			cpu.addPattern(patternString);

            //determine outcome
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
			save(cpu);
			send(didPWin);
	}


	public int determineOutcome(char pChoice, char cChoice){
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
	public Computer load(){
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

	public void send(int didPWin){
		write.println( cChoice + ","+ didPWin + "," + pWins + "," + cWins + "," + rounds);
	}


}