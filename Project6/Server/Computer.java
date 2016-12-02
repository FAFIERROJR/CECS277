import java.io.*;
import java.util.*;

/**
 * Computer.java
 * handles pattern storage and prediction
 * 
 * @author Francisco Fierro
 */
public class Computer implements Serializable{
	/** Hashmap for storing patterns */
	private HashMap<Pattern, Integer> map;



	/**
	 * Computer()
	 * Constructor for Computer object
	 * creates new Hashmap
	 * 
	 * 
	 */
	public Computer(){
		map = new HashMap<Pattern, Integer>();
	}

	/**
	 * addPattern()
	 * adds a pattern to the hashmap
	 * difficulty determines size of patterns
	 * 
	 * @param pIn The latest pattern as a string
	 */
	public void addPattern(String pIn){
        String p = pIn;

		Pattern p1 = null;
		Pattern p2 = null;

		if(p.length() > 3){
			p1 =  new Pattern(p.substring(p.length() - 4));
		}
		if(p.length() > 4){
			p2 = new Pattern(p.substring(p.length() - 5));
		}
		if(p.length() > 3){
			int instances = 1;
			if(map.containsKey(p1)){
				instances = map.get(p1) + 1;
			}
			map.put(p1,instances);
		}
		if(p.length() > 4){
			int instances = 1;
			if(map.containsKey(p2)){
				instances = map.get(p2) + 1;
			}
			map.put(p2,instances);

		}
	}

	/**
	 * makePrediction()
	 * predicts user choice according to
	 * pattern history, which is tracked by the
	 * hashmap
	 * 
	 * @param  pIn the pattern of user's previous choices
	 * @return     the char representing the predicted winning move
	 */
	public char makePrediction(String pIn){
		int choice = 0;
        int instances[] = {0,0,0};
        Pattern p[] = new Pattern[3];


        Pattern p1[] = new Pattern[3];
        Pattern p2[] = new Pattern[3];
        int i1[] = {0,0,0};
        int i2[] = {0,0,0};
        int choice1 = 0;
        int choice2 = 0;
        int max1;
        int max2;
            
        choice1 =(int)(Math.random() * 3);
        choice2 =(int)(Math.random() * 3);


        //4 char pattern       
        if(pIn.length() > 3){
            p1[0] = new Pattern(pIn.substring(
			pIn.length() - 3, pIn.length()) + 'f');
			p1[1] = new Pattern(pIn.substring(
				pIn.length() - 3, pIn.length()) + 'w');
			p1[2] = new Pattern(pIn.substring(
				pIn.length() - 3, pIn.length()) + 'g');

            for(int i = 0; i < 3; i++){
                if(map.containsKey(p1[i])){
                 	i1[i] = map.get(p1[i]);
                }
            }

            int temp1 = 0;
	        for(int i = 1; i < i1.length; i++){
				if(i1[i - 1] < i1[i]){
					temp1 = i;
				}
			}

			if(i1[temp1] > 0){
				choice1 = temp1;
			}
        }


        //5 char pattern
        if(pIn.length() > 4){
          	p2[0] = new Pattern(pIn.substring(
				pIn.length() - 4, pIn.length()) + 'f');
			p2[1] = new Pattern(pIn.substring(
				pIn.length() - 4, pIn.length()) + 'w');
			p2[2] = new Pattern(pIn.substring(
				pIn.length() - 4, pIn.length()) + 'g');

            for(int i = 0; i < 3; i++){
                if(map.containsKey(p2[i])){
                 	i2[i] = map.get(p2[i]);
                }
            }


            int temp2 = 0;
            for(int i = 1; i < i2.length; i++){
				if(i2[i-1] < i2[i]){
					temp2 = i;
				}
			}

			if(i2[temp2] > 1){
				choice2 = temp2;
			}

			//choose 5 char if at least .3 as much as 4 char
			if(choice1 == choice2){
				choice = choice1;
			}
			else if(i1[choice] != 0 && i2[choice2] /i1[choice1] > .3){
				choice = choice2;
			}
			else{
				choice = choice1;
			}
		}


		switch(choice){
				case 0:
					return 'w';

				case 1:
					return 'g';

				case 2:
					return 'f';	
		}
		return 'x';
	}
}