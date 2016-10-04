import java.io.*;
import java.util.*;

public class Computer implements Serializable{

	private HashMap<Pattern, Integer> map;

	private int difficulty;

    private int counter;

	public Computer(int d){
		map = new HashMap<Pattern, Integer>();
		difficulty = d;
        counter = 0;
	}

	public void addPattern(String pIn){
        String p = pIn;
        System.out.println("p.length = " + p.length());
		switch(difficulty){
			case 0:
					if(p.length() > 3){
						p = p.substring(p.length() - 4);
						Pattern pat = new Pattern(p);
						int instances = 1;

						if(map.containsKey(pat)){
							instances = map.get(pat) + 1;
						}
						map.put(pat,instances);
					}
				break;
			case 1:
				if(counter == 0 && p.length() > 2){
					p = p.substring(p.length() - 3);
					counter++;
				}
				if(counter == 1 && p.length() > 4){
					p = p.substring(p.length() - 5);
					counter++;
				}
				if(counter == 1 && p.length() > 7){
					p = p.substring(p.length() - 8);
					counter = 0;
				}
                System.out.println("P length = " + p.length());
				if(p.length() > 2){
					Pattern pat = new Pattern(p);
					int instances = 1;
                    System.out.println(pat.toString());


					if(map.containsKey(pat)){
						instances = map.get(pat) + 1;
					}
                    System.out.println("Adding to map");
					map.put(pat,instances);
				}
				break;
			default:
				break;
		}
	}

	public char makePrediction(String pString){
		int choice = 0;
        int instances[] = {0,0,0};

		switch(difficulty){
			case 0:
				if(pString.length() < 4){
					choice = (int)(Math.random() * 3);
				}
				else{
					Pattern p = new Pattern(pString);
					if(!(map.containsKey(p))){
						choice = (int)Math.random() * 3;
					}
					for(int i = 0; i < p.length(); i++){
						switch(p.toString().charAt(i)){
							case 'f':
								instances[0]++;
								break;
							case 'w':
								instances[1]++;
								break;
							case 'g':
								instances[2]++;
								break;
						}
					}

					for(int i = 1; i < instances.length; i++){
						if(instances[choice] < instances[i]){
							choice = i;
						}
					}
				}
				break;
				case 1:
                    Pattern pat = null;
                    if(map.isEmpty()){
                        choice =(int)(Math.random() * 3);
                        System.out.println("Random Choice");
                        break;
                    }
                    else{
                        int max = 0;
                        for(HashMap.Entry<Pattern, Integer> entry : map.entrySet()){
                            if(max < entry.getValue()){
                                pat = entry.getKey();
                                max = entry.getValue();
                            }
                        }
                    }
                    for(int i = 0; i < pat.length(); i++){
                        switch(pat.toString().charAt(i)){
                            case 'f':
                                instances[0]++;
                                break;
                            case 'w':
                                instances[1]++;
                                break;
                            case 'g':
                                instances[2]++;
                                break;
                        }
                    }

                    int sub = 3;
                    switch(counter){
                        case 0:
                            if(pString.length() > 7){
                                sub = 8;
                            }
                            break;
                        case 1:
                            sub = 3;
                            break;
                        case 2:
                            if(pString.length() > 4){
                                sub = 4;
                            }
                            break;
                    }
                    
                    for(int i = pString.length() - sub; i < pString.length(); i++){
                        System.out.print(pString.charAt(i));
                        switch(pString.charAt(i)){
                            case 'f':
                                instances[0]++;
                                break;
                            case 'w':
                                instances[1]++;
                                break;
                            case 'g':
                                instances[2]++;
                                break;
                        }
                    }

                    System.out.println("instances " + instances [0] +  " " + 
                        instances[1] + " " + instances[2]);

                    for(int i = 1; i < instances.length; i++){
                        if(instances[choice] < instances[i]){
                            choice = i;
                        }
                    }
				    break;

				default:
				    break;
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