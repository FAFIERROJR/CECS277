import java.awt.*;
/**
 * Missile.java
 * represents a missile object in game
 * @author Francisco Fierro
 *
 */
public class Missile{
	/**the missile's start location **/
	private Point start;
	/** the missile's current location **/
	private Point location;
	/** the missile's end location **/
	private Point end;
	/** the missile's speed **/
	private int speed;
	/** the missile's fill color **/
	private Color color;
	/** 0 if enemy missile, 1 if player missile **/
	private int type;
	/** true if in playe, else false **/
	private boolean active;
	/** amount to move on x axis **/
	private double moveAmtX;
	/** amount to move on y axis **/
	private double moveAmtY;
	
	/**
	 * Missile()
	 * constructor
	 * @param s		the start Point
	 * @param e		the end Point
	 * @param sp	the speed
	 * @param t		the type
	 * @param c		the color
	 */
	public Missile(Point s, Point e, int sp,
			int t, Color c){
		start = new Point((int)s.getX(), (int)s.getY());
		location = new Point((int)s.getX(), (int)s.getY());
		end = new Point((int)e.getX(), (int)e.getY());
		speed = sp;
		type = t;
		color = c;
		active = true;
	}
	
	/**
	 * move()
	 * handles translation and lifetime of missile
	 * 
	 */
	public void move(){
		if(active){
			moveAmtX = end.getX() - location.getX();
			moveAmtY= end.getY() - location.getY();
			double r = speed;
			double magnitude = Math.sqrt(moveAmtX * moveAmtX + moveAmtY * moveAmtY);
			if(magnitude <= speed){
				location = new Point((int)end.getX(), (int)end.getY());
			}
			else{
				location = new Point((int)(location.getX() + (moveAmtX * r / magnitude)),
						(int)(location.getY() + (moveAmtY * r / magnitude)));
			}
		}
		if(location.getX() == end.getX() && location.getY() == end.getY()){
			active = false;
		}
	}
	
	
	/**
	 * draw()
	 * draws the missile in panel
	 * @param g	the Graphics object
	 */
	public void draw(Graphics g){
		g.setColor(color);
		g.fillRect((int)location.getX() - 5, (int)location.getY() -5
				, 10, 10);
	}
	
	/**
	 * isActive9)
	 * @return	whether the missile is still in play as a boolean
	 */
	public boolean isActive(){
		return active;
	}
	
	/**
	 * getLocPoint()
	 * @return	the missile's current location as a Point
	 */
	public Point getLocPoint(){
		return new Point((int)location.getX(), (
				int)location.getY());
	}
	
	/**
	 * getType(){
	 * 
	 * @return the type of missile; enemy or player
	 */
	public int getType(){
		return type;
	}
		
		
}
