import java.awt.*;

public class Battery extends Rectangle{
	private int numMissiles;
	private Color color;
	
	public Battery(Point loc, Color c){
		x = (int) loc.getX();
		y = (int) loc.getY();
		width = 50;
		height = 50;
		color = c;
		numMissiles = 10;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.drawRect(x, y, width, height);
	}
	
	public int getNumMissiles(){
		return numMissiles;
	}
	
	public void removeMissiles(){
		if(numMissiles > 0){
			numMissiles--;
		}
		else{
			System.out.println("Error: missiles already depleted");
		}
	}
	
	public Point getLocPoint(){
		return new Point((int)getX(), (int)getY());
	}
	
	public boolean isHit(Point p){
		 if(this.contains(p)){
			 numMissiles = 0;
			 return true;
		 }
		 return false;
	}
}
