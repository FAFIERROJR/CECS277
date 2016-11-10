import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Frame extends JFrame{
	private Panel panel;
	
	public Frame(){
		setBounds(0,0,800,600);
		panel = new Panel();
		getContentPane().add(panel);
	}
	
	public static void main(String args[]){
		Frame f = new Frame();
		f.setTitle("Missile Command");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
