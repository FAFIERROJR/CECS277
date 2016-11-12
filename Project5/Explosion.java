import java.awt.*;

/**
 * Explosion.java
 * represents an explosion in game
 * @author Francisco Fierro
 *
 */
public class Explosion extends Rectangle{
	/**is the explosion growing **/
	private boolean expanding;
	/**is the explosion still in play **/
	private boolean active;
	
	/**
	 * Explosion()
	 * constructor
	 * @param p	the top left corner of the explosion
	 */
	public Explosion(Point p){
		expanding = true;
		active = true;
		x = (int) p.getX();
		y = (int) p.getY();	
		height = 10;
		width = 10;
	}
	
	/**
	 * draw()
	 * contains instructions on how to draw explosion
	 * @param g the graphics object with which to draw
	 */
	public void draw(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillOval(x - width/2, y - height/2, width, height);
		
	}
	
	/**
	 * move()
	 * handles expansion and lifetime of explosion
	 */
	public void move(){
		if(expanding){
			height += 10;
			width += 10;
		}
		if(height >= 200){
			expanding = false;
			active = false;
		}
	}
	
	/**
	 * isActive()
	 * @return whether the explosion is still in play
	 */
	public boolean isActive(){
		return active;
	}

}
