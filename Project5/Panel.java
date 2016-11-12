import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Panel
 * the GUIs panel object
 * @author Francisco Fierro
 *
 */
public class Panel extends JPanel implements MouseListener, MouseMotionListener,
	KeyListener{
	/** contains the six cities **/
	private City cities[];
	/** contains the three batteries **/
	private Battery batteries[];
	/** contains active missiles **/
	private ArrayList<Missile> missiles;
	/** contains active explosions **/
	private ArrayList<Explosion> explosions;
	/** crosshair for player aiming **/
	Crosshair crosshair;
	/** contains references to missiles to be removed in missiles **/
	private ArrayList<Missile> missilesToRemove;
	/** contains references to explosions to be added to explosions **/
	private ArrayList<Explosion> explosionsToAdd;
	/** the player's current game score **/
	int playerScore;
	/** the all-time high score **/
	int highScore;
	/** if the round has just begun; to avoid superfluous point awarding **/
	boolean roundBegin;
	
	/**
	 * Panel()
	 * constructor
	 * contains two threads
	 * thread1 handles enemy missile firing
	 * thread handle everything else
	 */
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
		missilesToRemove = new ArrayList<Missile>();
		explosionsToAdd = new ArrayList<Explosion>();
		playerScore = 0;
		highScore = 0;
		roundBegin = true;
		
		highScore = readHighScore();
		
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
						if(isEnd()){
							endRound();
						}
						Thread.sleep(40);
						
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
					while(true){
						for(int i = 0; i < 20; i ++){
							enemyFire();
							Thread.sleep(1800);
						}
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
	
	
	/**
	 * paintComponent()
	 * handles all drawing
	 * @param g the graphics object
	 */
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		g.setColor(Color.WHITE);
		g.drawString("High Score = " + highScore, 0, 20);
		g.drawString("Player Score = " + playerScore, 0, 40);
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
	
	
	/**
	 * mouseClicked()
	 * handles mouse click event
	 * fires player missile to crosshair from closest battery
	 * @param e	the mouse click event
	 */
	@Override
	public void mouseClicked(MouseEvent e){
		fireClosestBattery();
	}
	
	/**
	 * mouseMovement()
	 * handles mouse moved event
	 * updates crosshair location
	 * @param e	the mouse moved event
	 */
	@Override
	public void mouseMoved(MouseEvent e){
		crosshair.setLoc(new Point(e.getX(), e.getY()));
	}
	
	/**
	 * keyPressed()
	 * handles pressing of space bar and 1,2,3 keys
	 * fires from closest or corresponding battery
	 * @param e	the key pressed event
	 */
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
						(int)crosshair.getLoc().getY()), 10, 1, Color.BLUE));
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
						(int)crosshair.getLoc().getY()), 20, 1, Color.BLUE));
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
						(int)crosshair.getLoc().getY()), 10, 1, Color.BLUE));
			}
			
		}
	}
	
	/**
	 * endRound()
	 * handles ending of current round and start of new round
	 * awards points for surviving cities and missiles
	 */
	public void endRound(){
		boolean didPlayerWin = false;
		for(int i = 0; i < cities.length; i++){
			if(!roundBegin && cities[i].isActive()){
				didPlayerWin = true;
				playerScore += 1000;
			}
		}
		for(int i = 0; i < batteries.length; i++ ){
			playerScore += batteries[i].getNumMissiles() * 500;
		}
		roundBegin = false;
		
		if(!didPlayerWin){
			playerScore = 0;
		}
		int height = 600;
		int width = 800;
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
		missilesToRemove = new ArrayList<Missile>();
		explosionsToAdd = new ArrayList<Explosion>();
		roundBegin = true;
		
		if(playerScore > highScore){
			highScore = playerScore;
			recordHighScore(highScore);
		}
	}
	
	/**
	 * enemyFire()
	 * handles firing of an enemy missile
	 */
	public void enemyFire(){
		int randomStart = (int)(Math.random() * 800);
		int chooseTarget;
		Point targetLoc = null;
		boolean validChoice = false;
		boolean noValidChoice[] = new boolean[9];
		
		do{
			chooseTarget = (int)(Math.random() * 9);
			validChoice = true;
			for(int i = 0; i < noValidChoice.length; i++){
				if(!noValidChoice[i]){
					validChoice = false;
				}
			}
			switch(chooseTarget){
				case 0:
					if(cities[0].isActive()){
						targetLoc = cities[0].getLocPoint();
						validChoice = true;
					}
					else{
						noValidChoice[0] = true;
					}
					break;
				case 1:
					if(cities[1].isActive()){
						targetLoc = cities[1].getLocPoint();
						validChoice = true;
					}
					else{
						noValidChoice[1] = true;
					}
					break;
				case 2:
					if(cities[2].isActive()){
						targetLoc = cities[2].getLocPoint();
						validChoice = true;
					}
					else{
						noValidChoice[2] = true;
					}
					break;
				case 3:
					if(cities[3].isActive()){
						targetLoc = cities[3].getLocPoint();
						validChoice = true;
					}
					else{
						noValidChoice[3] = true;
					}
					break;
				case 4:
					if(cities[4].isActive()){
						targetLoc = cities[4].getLocPoint();
						validChoice = true;
					}
					else{
						noValidChoice[4] = true;
					}
					break;
				case 5:
					if(cities[5].isActive()){
						targetLoc = cities[5].getLocPoint();
						validChoice = true;
					}
					else{
						noValidChoice[5] = true;
					}
					break;
				case 6:
					if(batteries[0].getNumMissiles() > 0){
						targetLoc = batteries[0].getLocPoint();
						validChoice = true;
					}
					else{
						noValidChoice[6] = true;
					}
					break;
				case 7:
					if(batteries[1].getNumMissiles() > 0){
						targetLoc = batteries[1].getLocPoint();
						validChoice = true;
					}
					else{
						noValidChoice[7] = true;
					}
					break;
				case 8:
					if(batteries[2].getNumMissiles() > 0){
						targetLoc = batteries[2].getLocPoint();
						validChoice = true;
					}
					else{
						noValidChoice[8] = true;
					}
					break;
			}
		}while(!validChoice);
		if(targetLoc != null){
			missiles.add(new Missile(new Point(randomStart, 0), targetLoc,
					5, 0, Color.RED));
		}

	}
			
	/**
	 * fireClosesBattery()
	 * handles firing of player missile from closest battery
	 */
	public void fireClosestBattery(){
		//find closest available battery
		int minIndex = 0;
		double magnitude1, magnitude2;
		double x;
		double y;
		magnitude1 = 10000000;
		for(int i = 0; i < 3; i ++){
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
		if(minIndex >= 0 && batteries[minIndex].getNumMissiles() > 0){
			int speed = 10;
			batteries[minIndex].removeMissiles();
			if(minIndex == 1){
				speed =+ 10;
			}
			missiles.add(new Missile(new Point((int)batteries[minIndex].getX(),
					(int)batteries[minIndex].getY()), 
					new Point((int)crosshair.getLoc().getX(),
					(int)crosshair.getLoc().getY()), speed, 1, Color.BLUE));
		}
	}
	
	/**
	 * move()
	 * handles movement of missiles and explosions
	 */
	public void move(){
		for(Missile m:missiles){
			m.move();
		}
		for(Explosion ex: explosions){
			ex.move();
		}
	}
	
	/**
	 * boom()
	 * handles creation of explosions
	 */
	public void boom(){
		for(Missile m: missiles){
			if(!m.isActive()){
				System.out.println("Adding explosion");
				explosions.add(new Explosion(
						new Point((int)m.getLocPoint().getX(), (int)m.getLocPoint().getY())));
				for(int i = 0; i < cities.length; i ++){
					cities[i].isHit(m.getLocPoint());
				}
				for(int i = 0; i < batteries.length; i ++){
					batteries[i].isHit(m.getLocPoint());
				}
			}
		}
	}
	
	/**
	 * detectHits()
	 * handles hit detection
	 * and determines what to clean up
	 * and secondary explosions
	 */
	public void detectHits(){
		for(int i = 0; i < explosions.size(); i++){
			for(int j = 0; j < missiles.size(); j++){
				if(explosions.get(i).contains(missiles.get(j).getLocPoint())){
					missilesToRemove.add(missiles.get(j));
					explosionsToAdd.add(new Explosion(missiles.get(j).getLocPoint()));
				}
			}
			
		}
		for(Explosion ex: explosionsToAdd){
			explosions.add(ex);
		}
		explosionsToAdd.clear();
	}
	
	/**
	 * cleanUp()
	 * handles removal of missiles and explosions
	 */
	public void cleanUp(){
		for(Missile m: missilesToRemove){
			missiles.remove(m);
		}
		
		for(int i = 0; i < explosions.size(); i++){
			if(!explosions.get(i).isActive()){
				System.out.println("Removing..");
				explosions.remove(i);
			}
		}
	}
	
	/**
	 * readHighScore()
	 * reads in high score from file
	 * @return	the recorded high score
	 */
	public int readHighScore(){
		int highScore = 0;
		try{
			Scanner in = new Scanner(new File("score.text"));
			highScore = in.nextInt();
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println("file not found");
		}
		return highScore;	
	}
	
	/**
	 * recordHighScore()
	 * writes the high score to file
	 * @param score	the score to record
	 */
	public void recordHighScore(int score){
		try{
			PrintWriter writer = new PrintWriter("score.text");
			writer.println(score);
			writer.close();
		}
		catch(IOException e){
			System.out.println("Error reading score");
		}
	}
	
	/**
	 * isEnd()
	 * determines if round has ended
	 * @return whether round has ended
	 */
	public boolean isEnd(){
		boolean validCities[] = new boolean[6];
		boolean didPlayerWin = false;
		for(int i = 0; i < validCities.length; i++){
			if(cities[i].isActive()){
				didPlayerWin = true;
			}
		}
		if(!didPlayerWin){
			return true;
		}
		if(missiles.isEmpty()){
			return true;
		}
		return false;
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
