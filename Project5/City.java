import java.awt.*;

public class City extends Rectangle{
	
	private boolean active;

	private Color color;
	
	public City(Point loc, Color c){
		active = true;
		x = (int)loc.getX();
		y = (int)loc.getY();
		height = 50;
		width = 50;
		color = c;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}
	
	public boolean isActive(){
		return active;
	}

	public boolean isHit(Point p){
		 if(this.contains(p)){
			 active = false;
			 return true;
		 }
		 return false;
	}
	
	public Point getLocPoint(){
		return new Point((int)getX(), (int)getY());
	}
}