import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Crosshair.java
 * handles the onscreen crosshair
 * @author frank
 *
 */
public class Crosshair {
	private Point center;
	public Crosshair(Point p){
		center = p;
	}
	
	/**
	 * draw()
	 * draws the crosshair
	 * @param g	the graphics object
	 */
	public void draw(Graphics g){
		int halfSize = 10;
		g.setColor(Color.GRAY);
		g.drawLine((int)center.getX() - halfSize, (int)center.getY(), 
				(int)center.getX() + halfSize, (int)center.getY());
		g.drawLine((int)center.getX(), (int)center.getY() - halfSize, 
				(int)center.getX(), (int)center.getY() + halfSize);
	}
	
	/**
	 * setLoc()
	 * sets the crosshair location
	 * @param p the location to set to
	 */
	public void setLoc(Point p){
		center = p;
	}
	
	/**
	 * getLoc()
	 * gets the crosshair's location
	 * @return the crosshair's location as a Point
	 */
	public Point getLoc(){
		return center;
	}
	
}
