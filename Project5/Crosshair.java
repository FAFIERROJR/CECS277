import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Crosshair {
	private Point center;
	public Crosshair(Point p){
		center = p;
	}
	
	public void draw(Graphics g){
		int halfSize = 10;
		g.setColor(Color.GRAY);
		g.drawLine((int)center.getX() - halfSize, (int)center.getY(), 
				(int)center.getX() + halfSize, (int)center.getY());
		g.drawLine((int)center.getX(), (int)center.getY() - halfSize, 
				(int)center.getX(), (int)center.getY() + halfSize);
	}
	
	public void setLoc(Point p){
		center = p;
	}
	
	public Point getLoc(){
		return center;
	}
	
	public void printLoc(){
		System.out.println(center.getX() +" " + center.getY());
	}
}
