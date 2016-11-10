import java.awt.*;

public class Explosion extends Rectangle{
	private boolean expanding;
	private boolean active;
	
	public Explosion(Point p){
		expanding = true;
		active = true;
		x = (int) p.getX();
		y = (int) p.getY();	
		height = 10;
		width = 10;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.YELLOW);
		g.drawOval(x, y, width, height);
		
	}
	
	public void move(){
		if(expanding){
			height += 5;
			width += 5;
		}
	}
	
	public boolean isActive(){
		return active;
	}

}
