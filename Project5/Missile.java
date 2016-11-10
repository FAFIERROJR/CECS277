import java.awt.*;
public class Missile{
	private Point start;
	private Point location;
	private Point end;
	private int speed;
	private Color color;
	private int type;
	private boolean active;
	
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
	
	public void move(){
		if(active){
			double dx = end.getX() - location.getX();
			double dy = end.getY() - location.getY();
			double r = speed;
			double magnitude = Math.sqrt(dx * dx + dy * dy);
			if(magnitude <= speed){
				location = new Point((int)end.getX(), (int)end.getY());
			}
			else{
				location = new Point((int)(location.getX() + (dx * r / magnitude)),
						(int)(location.getY() + (dy * r / magnitude)));
			}
		}
		if(location.getX() == end.getX() && location.getY() == end.getY()){
			active = false;
		}
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.drawRect((int)location.getX(), (int)location.getY()
				, 10, 10);
	}
	
	public boolean isActive(){
		return active;
	}
	
	public Point getLocPoint(){
		return new Point((int)location.getX(), (
				int)location.getY());
	}
	
		
		
}
