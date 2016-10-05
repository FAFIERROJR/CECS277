import java.io.*;
import java.util.*;

public class Computer implements Serializable{

	private HashMap<Pattern, Integer> map;

	private int difficulty;

	public Computer(int d){
		map = new HashMap<Pattern, Integer>();
		difficulty = d;
	}

	public void addPattern(String pIn){
        String p = pIn;
		switch(difficulty){
			case 0:
					if(p.length() > 3){
						p = p.substring(p.length() - 4);
						System.out.println(p);
						Pattern pat = new Pattern(p);
						int instances = 1;

						if(map.containsKey(pat)){
							instances = map.get(pat) + 1;
						}
						map.put(pat,instances);
					}
				break;
			case 1:
				Pattern p1 = null;
				Pattern p2 = null;

				if(p.length() > 2){
					p1 =  new Pattern(p.substring(p.length() - 3));
				}
				if(p.length() > 4){
					p2 = new Pattern(p.substring(p.length() - 5));
				}
				if(p.length() > 2){
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
				break;
			default:
				break;
		}
	}

	public char makePrediction(String pIn){
		int choice = 0;
        int instances[] = {0,0,0};
        Pattern p[] = new Pattern[3];

        System.out.println(pIn.length());

		switch(difficulty){
			case 0:
				choice = (int)(Math.random() * 3);
				
				if(pIn.length() > 3){
					p[0] = new Pattern(pIn.substring(
						pIn.length() - 3, pIn.length()) + 'f');
					System.out.println(p[0].toString());
					p[1] = new Pattern(pIn.substring(
						pIn.length() - 3, pIn.length()) + 'w');
					System.out.println(p[1].toString());
					p[2] = new Pattern(pIn.substring(
						pIn.length() - 3, pIn.length()) + 'g');

					for(int i = 0; i < 3; i++){
						if(map.containsKey(p[i])){
							instances[i] = map.get(p[i]);
						}
					}

					int temp = 0;
					System.out.println(instances[0]);
					for(int i = 1; i < instances.length; i++){
						System.out.println(instances[i]);
						if(instances[i-1] < instances[i]){
							temp = i;
						}
					}
					choice = temp;
					System.out.println(choice);
				}

				break;
							
			case 1:
                Pattern p1[] = new Pattern[3];
                Pattern p2[] = new Pattern[3];
                int i1[] = new int[3];
                int i2[] = new int[3];
                int choice1 = 0;
                int choice2 = 0;
                int max1;
                int max2;

                choice1 =(int)(Math.random() * 3);
                choice2 =(int)(Math.random() * 3);
                       
              	if(pIn.length() > 2){
              		p1[0] = new Pattern(pIn.substring(
						pIn.length() - 3, pIn.length()) + 'f');
					p1[1] = new Pattern(pIn.substring(
						pIn.length() - 3, pIn.length()) + 'w');
					p1[2] = new Pattern(pIn.substring(
						pIn.length() - 3, pIn.length()) + 'g');

                    for(int i = 0; i < 2; i++){
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
					choice1 = temp1;

                }


                if(pIn.length() > 4){
              		p2[0] = new Pattern(pIn.substring(
						pIn.length() - 3, pIn.length()) + 'f');
					p2[1] = new Pattern(pIn.substring(
						pIn.length() - 3, pIn.length()) + 'w');
					p2[2] = new Pattern(pIn.substring(
						pIn.length() - 3, pIn.length()) + 'g');

                    for(int i = 0; i < 2; i++){
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
					choice2 = temp2;

					System.out.println(choice1 + " " + choice2);
					if(choice1 == choice2){
						choice = choice1;
					}
					else if(i2[choice2] >= i1[choice1]){
						choice = choice2;
					}
					else{
						choice = choice1;
					}
                	break;
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