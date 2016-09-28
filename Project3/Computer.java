public class Computer{

	HashMap<Pattern, Integer> map = new HashMap<Pattern, Integer>();


	public Pattern addPattern(Pattern p){
		if(p.length >= 4){
			int instances = 1;

			if(map.contains(p)){
				instances = map.get(p) + 1;
			}

			map.add(p,instances)
		}
	}

	public char makePrediction(String p){
		int instances[] = {0,0,0}
		if(p.length < 4 || map.contains(p)){
			for(i = 0; i < p.length; i++){
				switch(p[i]){
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

			int max = 0;
			for(i = 1; i < instances.length; i++){
				if(instances[max] < instances[i]){
					max = i;
				}
			}

			switch(max){
				case 0:
					return 'f';
					break;
				case 1:
					return 'w';
					break;
				case 2:
					return 'g';
					break;			
			}

		}
	}
}