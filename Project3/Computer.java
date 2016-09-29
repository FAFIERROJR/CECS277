import java.util.*;

public class Computer{

	private HashMap<Pattern, Integer> map;

	public Computer(){
		map = new HashMap<Pattern, Integer>();
	}

	public void addPattern(String pString){
		if(pString.length() == 4){
			Pattern p = new Pattern(pString);
			int instances = 1;

			if(map.containsKey(p)){
				instances = map.get(p) + 1;
			}

			map.put(p,instances);
		}
	}

	public char makePrediction(String pString){
		int instances[] = {0,0,0};
		int choice = 0;

		if(pString.length() < 4){
			choice = (int)Math.random() * 3;
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