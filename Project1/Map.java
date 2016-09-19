
import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * Class Map
 * handles the management of game areas
 * loading from file
 * displaying area
 * updating revealed locations
 * removing defeated opponents/wild pokemon
 *
 * @author Francisco Fierro
 */
public class Map implements Serializable{
	char [][] map;
	boolean [][] revealed;

    /**
     * Map()
     * basic map constructor
     * initialized arrays to empty 5x5 arrays
     */
    public Map(){
        map = new char[5][5];
        revealed = new boolean[5][5];
	}

    /**
     * generateArea()
     * loads an area into map array from file
     * 
     * @param areaNum the number delineating a particular area
     */
	public void generateArea(int areaNum){
        try{
            Scanner reader = new Scanner(new File("Area" + areaNum + ".txt"));
            
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    map[i][j] = reader.next().charAt(0);
                    revealed[i][j] = false;
                    if(map[i][j] == 'c'){
                        revealed[i][j] = true;
                    }
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("ERROR: Area" + areaNum + ".txt was not found");
        }
	}
	
    /**
     * getCharAtLoc()
     * returns the character at given location
     * 
     * @param  p the given location
     * @return   the char at given location
     */
	public char getCharAtLoc(Point p){
	    return map[(int)p.getX()][(int)p.getY()];
	}
	
    /**
     * displayMap()
     * prints the current area 
     * with player's current location marked as *
     * 
     * @param p the player's location
     */
	public void displayMap(Point p){
        char point;

        for(int i = 0; i < 5; i++){
            System.out.print("|");
            for(int j = 0; j < 5; j++){
                if(revealed[i][j] == true){
                    point = map[i][j];
                }
                else{
                    point = 'X';
                }
                if(p.getX() == i && p.getY() == j){
                        point = '*';
                }
                System.out.print(point + " ");
            }
            System.out.print("|");
            System.out.print("\n");
        }
	}
	
    /**
     * findStartLocation()
     * finds and returns the designated
     * player start location
     * 
     * @return the start location
     */
	public Point findStartLocation(){
	    for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(map[i][j] == 's'){
                    Point p = new Point(i,j);
                    return p;
                }
            }
        }
        return null;
	}
	
    /**
     * reveal()
     * 
     * @param p the point to reveal
     */
	public void reveal(Point p){
	    revealed[(int)p.getX()][(int)p.getY()] = true;
	}
	
	/**
	 * removeOppAtLoc()
	 * removes an opponent from a location
	 * and replaces with nothing 'n'
	 * @param p the point from which to remove opponent
	 */
	public void removeOppAtLoc(Point p){
        map[(int)p.getX()][(int)p.getY()] = 'n';
    }
}