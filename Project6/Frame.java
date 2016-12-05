import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Frame.java
 * The GUIs Frame object
 * @author Francisco Fierro
 *
 */

public class Frame extends JFrame{
	/** the GUIs Panel object **/
	private Client client;
	
	/**
	 * Frame()
	 * constructor
	 * instantiates a Client
	 * sets resolution
	 */
	public Frame(){
		setBounds(0,0,800,600);
		client = new Client();
		getContentPane().add(client);
	}
	
	/**
	 * main()
	 * instantiates Frame
	 * @param args	the ol' args[]
	 */
	public static void main(String args[]){
		Frame f = new Frame();
		f.setTitle("Pokemon: Versus Alakazam");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
