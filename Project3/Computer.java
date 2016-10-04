import java.io.*;
import java.util.*;

public class Computer implements Serializable{

	private HashMap<Pattern, Integer> map;

	private int difficulty;

	public Computer(int d){
		map = new HashMap<Pattern, Integer>();
		difficulty = d;
	}

	public void addPattern(String pString){
        String p;
		switch(difficulty){
			case 0:
					if(p.size() > 3){
						p = psubstring(p.size() - 4, p.size() - 1);
						Pattern p = new Pattern(pString);
						int instances = 1;

						if(map.containsKey(p)){
							instances = map.get(p) + 1;
						}
						map.put(p,instances);
					}
				break;
			case 1:
				int counter = 0;
				if(counter == 0 && p.size() > 2){
					p = substring(p.size() - 3, p.size() - 1);
					count++;
				}
				if(counter == 1 && p.size() > 4){
					p = substring(p.size() - 5, p.size() - 1);
					count++;
				}
				if(counter == 1 && p.size() > 7){
					p = substring(p.size() - 8, p.size() - 1);
					count = 0;
				}
				if(p.size > 2){
					Pattern p = new Pattern(pString);
					int instances = 1;

					if(map.containsKey(p)){
						instances = map.get(p) + 1;
					}
					map.put(p,instances);
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
                    if(map.empty()){
                    choice = (int)(Math.random() * 3);
                    }
                    else{
                        Pattern p;
                        int max = 0;
                        for(Pattern pat : map.keySet()){
                            if(max < map.get(pat)){
                                Pattern = pat;
                                max = map.get(pat);
                            }
                        }
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