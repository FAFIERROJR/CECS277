import java.awt.*;

/**
 * City
 * the in game cities a player must defend
 * @author Francisco Fierro
 *
 */
public class City extends Rectangle{
	/** true  only if city is still in play  **/
	private boolean active;
	/** the city's color **/
	private Color color;
	
	/**
	 * City()
	 * constructor
	 * @param loc	the City's top left point
	 * @param c		the City's color
	 */
	public City(Point loc, Color c){
		active = true;
		x = (int)loc.getX();
		y = (int)loc.getY();
		height = 50;
		width = 50;
		color = c;
	}
	
	/**
	 * draw()
	 * draws city as rectangle
	 * @param g	the graphics object
	 */
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
	/**
	 * isActive
	 * @return	true if in play, else false
	 */
	public boolean isActive(){
		return active;
	}

	/**
	 * isHit()
	 * returns true if city is hit by missile
	 * else false
	 * @param p	the missile's location
	 * @return 	whether the city has been hit
	 */
	public boolean isHit(Point p){
		 if(this.contains(p)){
			 active = false;
			 return true;
		 }
		 return false;
	}
	
	/**
	 * getLocPoint()
	 * @return the city's top left Point
	 */
	public Point getLocPoint(){
		return new Point((int)getX(), (int)getY());
	}
}