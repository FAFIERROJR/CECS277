import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Panel extends JPanel implements MouseListener, MouseMotionListener,
	KeyListener{
		
	private City cities[];
	private Battery batteries[];
	private ArrayList<Missile> missiles;
	private ArrayList<Explosion> explosions;
	Crosshair crosshair;
	private ArrayList<Integer> missilesToRemove;
	
	public Panel(){
		int height = 600;
		int width = 800;
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
		
		cities = new City[6];
		for(int i = 0; i < cities.length; i++){
			int padding = 90;
			if(i  > 2){
				padding = 180 ;
			}
			Point tempPoint = new Point(i* 100 + padding, height - 50);
			cities[i] = new City(tempPoint, Color.GREEN);
		}
		batteries = new Battery[3];
		batteries[0] = new Battery(new Point(0, height-50), Color.BLUE);
		batteries[1] = new Battery(new Point(width/2 - 25, height-50), Color.BLUE);
		batteries[2] = new Battery(new Point(width - 50, height-50), Color.BLUE);
		missiles = new ArrayList<Missile>();
		explosions = new ArrayList<Explosion>();
		crosshair = new Crosshair(new Point(width/2,height/2));
		missilesToRemove = new ArrayList<Integer>();
		this.setBackground(Color.BLACK);
		
		Thread thread = new Thread(){
			public void run(){
				try{
					while(true){
						move();
						boom();
						detectHits();
						cleanUp();
						repaint();
						Thread.sleep(50);
						
					}
				}
				catch(InterruptedException e){
					System.out.println("Interrupted");
				}
			}
		};
		
		Thread thread1 = new Thread(){
			public void run(){
				try{
					for(int i = 0; i < 1; i ++){
						enemyFire();
						Thread.sleep(1000);
					}
				}
				catch(InterruptedException e){
					System.out.println("Interrupted");
				}
			}
		};
		
		
		thread.start();
		thread1.start();
	}
	
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i = 0; i < cities.length; i++){
			if(cities[i].isActive()){
				cities[i].draw(g);
			}
		}
		for(int i = 0; i < batteries.length; i++){
			if(batteries[i].getNumMissiles() > 0){
				batteries[i].draw(g);
			}
		}
		
		for(Missile m : missiles){
			if(m.isActive()){
				m.draw(g);
			}
		}
		
		for(Explosion ex: explosions){
			if(ex.isActive()){
				ex.draw(g);
			}
		}
		
		crosshair.draw(g);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e){
		fireClosestBattery();
	}
	
	@Override
	public void mouseMoved(MouseEvent e){
		crosshair.setLoc(new Point(e.getX(), e.getY()));
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		int batteryNum = 0;
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			fireClosestBattery();
		}
		if(e.getKeyCode() == KeyEvent.VK_1){
			batteryNum = 0;
			//fire missile from corresponding battery
			if(batteries[batteryNum].getNumMissiles() > 0){
				batteries[batteryNum].removeMissiles();
				missiles.add(new Missile(new Point((int)batteries[batteryNum].getX(),
						(int)batteries[batteryNum].getY()), 
						new Point((int)crosshair.getLoc().getX(),
						(int)crosshair.getLoc().getY()), 7, 1, Color.BLUE));
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_2){
			batteryNum = 1;
			//fire missile from corresponding battery
			if(batteries[batteryNum].getNumMissiles() > 0){
				batteries[batteryNum].removeMissiles();
				missiles.add(new Missile(new Point((int)batteries[batteryNum].getX(),
						(int)batteries[batteryNum].getY()), 
						new Point((int)crosshair.getLoc().getX(),
						(int)crosshair.getLoc().getY()), 7, 1, Color.BLUE));
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_3){
			batteryNum = 2;
			//fire missile from corresponding battery
			if(batteries[batteryNum].getNumMissiles() > 0){
				batteries[batteryNum].removeMissiles();
				missiles.add(new Missile(new Point((int)batteries[batteryNum].getX(),
						(int)batteries[batteryNum].getY()), 
						new Point((int)crosshair.getLoc().getX(),
						(int)crosshair.getLoc().getY()), 7, 1, Color.BLUE));
			}
			
		}
	}
	
	public void enemyFire(){
		int randomStart = (int)(Math.random() * 800);
		int chooseTarget;
		boolean validChoice = false;
		Point targetLoc = null;
		
		do{
			chooseTarget = (int)(Math.random() * 8);
			switch(chooseTarget){
				case 0:
					if(cities[0].isActive()){
						targetLoc = cities[0].getLocPoint();
						validChoice = true;
					}
					break;
				case 1:
					if(cities[1].isActive()){
						targetLoc = cities[1].getLocPoint();
						validChoice = true;
					}
					break;
				case 2:
					if(cities[2].isActive()){
						targetLoc = cities[2].getLocPoint();
						validChoice = true;
					}
					break;
				case 3:
					if(cities[3].isActive()){
						targetLoc = cities[3
						                   
						                   ].getLocPoint();
						validChoice = true;
					}
					break;
				case 4:
					if(cities[4].isActive()){
						targetLoc = cities[4].getLocPoint();
						validChoice = true;
					}
					break;
				case 5:
					if(cities[5].isActive()){
						targetLoc = cities[5].getLocPoint();
						validChoice = true;
					}
					break;
				case 6:
					if(batteries[0].getNumMissiles() > 0){
						targetLoc = batteries[0].getLocPoint();
						validChoice = true;
					}
					break;
				case 7:
					if(batteries[1].getNumMissiles() > 0){
						targetLoc = cities[1].getLocPoint();
						validChoice = true;
					}
					break;
				case 8:
					if(batteries[2].getNumMissiles() > 0){
						targetLoc = batteries[2].getLocPoint();
						validChoice = true;
					}
					break;
				default:
					System.out.println("All Targets have been destroyed. Game over");
					validChoice = true;
			}
		}while(!validChoice);
		if(targetLoc != null){
			missiles.add(new Missile(new Point(randomStart, 0), targetLoc,
					5, 0, Color.RED));
		}

	}
			
	public void fireClosestBattery(){
		//find closest available battery
		int minIndex = 0;
		double magnitude1, magnitude2;
		double x = batteries[0].getX() - crosshair.getLoc().getX();
		double y = batteries[0].getY() - crosshair.getLoc().getY();
		magnitude1 = Math.sqrt(x * x + y * y);
		for(int i = 1; i < 3; i ++){
			x = batteries[i].getX() - crosshair.getLoc().getX();
			y = batteries[i].getY() - crosshair.getLoc().getY();
			magnitude2 = Math.sqrt(x * x + y * y);
			if(magnitude2 < magnitude1){
				if(batteries[i].getNumMissiles() > 0){
					magnitude1 = magnitude2;
					minIndex = i;
				}
			}	
		}
				
		//fire missile from closest battery
		if(batteries[minIndex].getNumMissiles() > 0){
			batteries[minIndex].removeMissiles();
			missiles.add(new Missile(new Point((int)batteries[minIndex].getX(),
					(int)batteries[minIndex].getY()), 
					new Point((int)crosshair.getLoc().getX(),
					(int)crosshair.getLoc().getY()), 7, 1, Color.BLUE));
		}
	}
	
	public void move(){
		for(Missile m:missiles){
			m.move();
		}
		for(Explosion ex: explosions){
			ex.move();
		}
	}
	
	public void boom(){
		for(Missile m: missiles){
			if(!m.isActive()){
				explosions.add(new Explosion(
						new Point((int)m.getLocPoint().getX(), (int)m.getLocPoint().getY())));
			}
		}
	}
	
	public void detectHits(){
		for(Explosion ex : explosions){
			for(int i = 0; i < missiles.size(); i++){
				if(ex.contains(missiles.get(i).getLocPoint())){
					missilesToRemove.add(i);
				}
			}
			
		}
	}
	
	public void cleanUp(){
		for(Integer i : missilesToRemove){
			missiles.remove(i);
		}
		
		for(int i = 0; i < explosions.size(); i++){
			if(!explosions.get(i).isActive()){
				explosions.remove(i);
			}
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
