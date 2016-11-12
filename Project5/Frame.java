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
	private Panel panel;
	
	/**
	 * Frame()
	 * constructor
	 * instantiates a panel
	 * sets resolution
	 */
	public Frame(){
		setBounds(0,0,800,600);
		panel = new Panel();
		getContentPane().add(panel);
	}
	
	/**
	 * main()
	 * instantiates Frame
	 * @param args	the ol' args[]
	 */
	public static void main(String args[]){
		Frame f = new Frame();
		f.setTitle("Missile Command");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
