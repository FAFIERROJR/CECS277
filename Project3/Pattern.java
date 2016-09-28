public class Pattern{
	private String pattern;

	public Pattern(String p){
		pattern = p;
	}

	public getPattern(){
		return pattern;
	}

	@Override
	public int hashCode(){
		return pattern.hashCode();
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof String){
			return pattern.equals((String) o);
		}
	}
}