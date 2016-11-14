import java.awt.*;

/**
 * Battery
 * stores missiles
 * @author Francisco Fierro
 *
 */
public class Battery extends Rectangle{
	/**  the number of missiles in the battery **/
	private int numMissiles;
	/** the battery's color **/
	private Color color;
	
	/** 
	 * Battery()
	 * constructor
	 * @param loc 	the battery's upper left corner
	 * @param c		the battery's color
	 */
	public Battery(Point loc, Color c){
		x = (int) loc.getX();
		y = (int) loc.getY();
		width = 50;
		height = 50;
		color = c;
		numMissiles = 10;
	}
	
	/**
	 * draw()
	 * draws the battery
	 * @param g	the graphics object
	 */
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setFont(new Font("Arial", Font.PLAIN, 16));
		g.setColor(Color.WHITE);
		g.drawString(""+ numMissiles, x + width/3, y + height/2);
	}
	
	/**
	 * getNumMissiles
	 * @return the number of missiles
	 */
	public int getNumMissiles(){
		return numMissiles;
	}
	
	/**
	 * removeMissiles(){
	 * decrements the number of missiles
	 */
	public void removeMissiles(){
		if(numMissiles > 0){
			numMissiles--;
		}
		else{
			System.out.println("Error: missiles already depleted");
		}
	}
	
	/**
	 * getLocPoint()
	 * @return the battery's upper left Point
	 */
	public Point getLocPoint(){
		return new Point((int)getX(), (int)getY());
	}
	
	/**
	 * isHit
	 * determines if battery has been hit by a missile
	 * @param p	the missile's location
	 * @return	whether the battery has been hit
	 */
	public boolean isHit(Point p){
		 if(this.contains(p)){
			 numMissiles = 0;
			 return true;
		 }
		 return false;
	}
}
