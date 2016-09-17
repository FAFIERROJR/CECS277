import java.util.*;
import java.io.*;
import java.awt.*;

public class Map{
	char [][] map;
	boolean [][] revealed;
    
    public Map(){
        map = new char[5][5];
        revealed = new boolean[5][5];
	}
	public void generateArea(int areaNum){
        try{
            Scanner reader = new Scanner(new File("Area" + areaNum + ".txt"));
            
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    map[i][j] = reader.next().charAt(0);
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
	
	public char getCharAtLoc(Point p){
	    return map[(int)p.getX()][(int)p.getY()];
	}
	
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
	
	public void reveal(Point p){
	    revealed[(int)p.getX()][(int)p.getY()] = true;
	}
	
	public void removeOppAtLoc(Point p){
        map[(int)p.getX()][(int)p.getY()] = 'n';
    }
}