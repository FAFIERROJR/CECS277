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
		g.fillOval(x - width/2, y - height/2, width, height);
		
	}
	
	public void move(){
		if(expanding){
			height += 5;
			width += 5;
		}
		if(height == 70){
			expanding = false;
			active = false;
		}
	}
	
	public boolean isActive(){
		return active;
	}

}
