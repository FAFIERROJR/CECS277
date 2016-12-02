import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;

/**
 * Panel
 * the GUIs panel object
 * @author Francisco Fierro
 *
 */
public class Client extends JPanel implements ActionListener{
	private Socket sock;
	private BufferedReader read;
	private PrintStream write;
	private JButton fireBtn;
	private JButton waterBtn;
	private JButton grassBtn;
	private int playerChoice;
	private String pattern;
	private int outcome;
	private int pWins;
	private int cWins;
	private int rounds;
	private char cChoice;

	/**
	 * Client()
	 * initializes all GUI and client networking stuff
	 * contains thread for reading from server
	 */
	public Client(){
		try{
			sock = new Socket("localhost", 1080);
			read = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			write = new PrintStream(sock.getOutputStream());
		}
		catch(IOException e){
			e.printStackTrace();
		}

		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.WHITE);
		try{
			Image fireImg = ImageIO.read(getClass().getResource(("fire.jpg"))).getScaledInstance(100,100,Image.SCALE_DEFAULT);
			fireBtn = new JButton();
			fireBtn.setIcon(new ImageIcon(fireImg));
			Image waterImg = ImageIO.read(getClass().getResource(("water.jpg"))).getScaledInstance(100,100,Image.SCALE_DEFAULT);
			waterBtn = new JButton();
			waterBtn.setIcon(new ImageIcon(waterImg));
			Image grassImg = ImageIO.read(getClass().getResource(("grass.jpg"))).getScaledInstance(100,100,Image.SCALE_DEFAULT);
			grassBtn = new JButton();
			grassBtn.setIcon(new ImageIcon(grassImg));
			fireBtn.addActionListener(this);
			waterBtn.addActionListener(this);
			grassBtn.addActionListener(this);
			add(fireBtn);
			add(waterBtn);
			add(grassBtn);

			pattern = "";
			outcome = -2;

			Thread thread = new Thread(){
				public void run(){
					while(true){
						repaint();
						receive();
					}
				}
			};
			thread.start();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * paintComponent()
	 * paints the text readout
	 * @param g the Graphics Object
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		if(outcome != -2){
			g.setColor(Color.BLACK);
			String cChoiceString = translateChoice();
			g.drawString("Computer chose " + cChoiceString, 250, 200);
			String outcomeString = "";
			switch(outcome){
				case -1:
					outcomeString = "You lose!";
					break;
				case 0:
					outcomeString = "Draw!";
					break;
				case 1 : 
					outcomeString = "You Win!";
					break;
			}
			g.drawString(outcomeString, 250, 300);
			int pWinper = 0;
        	int cWinper = 0;

	        if(rounds != 0){
	            pWinper = 100* pWins / rounds;
	            cWinper = 100 * cWins / rounds;
	        }

			String pStatsString = "\nPlayer Wins: " + pWins + " Player Win %: "  +
				pWinper;
			g.drawString(pStatsString, 250, 400);
			String cStatsString = " CPU Wins: " + cWins
				+ " CPU Win %: " + cWinper +"\n";
			g.drawString(cStatsString, 250, 500);

		}


	}

	/**
	 * actionPerformed()
	 * reads user input and calls send()
	 * @param a the action event
	 */
	public void actionPerformed(ActionEvent a){
		if(a.getSource() == fireBtn){
			pattern = pattern + 'f';
		}
		if(a.getSource() == waterBtn){
			pattern = pattern + 'w';
		}
		if(a.getSource() == grassBtn){
			pattern = pattern + 'g';
		}
		send();
	}


	/**
	 * send()
	 * sends the player's choice to server
	 */
	public void send(){
		if(pattern.length() > 20){
			pattern = pattern.substring(1);
		}
		write.println(pattern);
	}

	/**
	 * receive()
	 * reads computer choice, round outcome, and
	 * win/lose stats from server
	 */
	public void receive(){
		try{
			String input[] = read.readLine().split(",");
			cChoice = input[0].charAt(0);
			try{
				outcome = Integer.parseInt(input[1]);
				pWins = Integer.parseInt(input[2]);
				cWins = Integer.parseInt(input[3]);
				rounds = Integer.parseInt(input[4]);
			}catch(InputMismatchException e){
				e.printStackTrace();
			}

		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	/**
	 * translateChoice
	 * translates the player's choice from char to String
	 * @return the string representing the player's choice
	 */
	public String translateChoice(){
		switch(cChoice){
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

}