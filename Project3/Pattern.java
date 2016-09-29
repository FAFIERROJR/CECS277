import java.io.*;

public class Pattern implements Serializable{
	private String pattern;

	public Pattern(String p){
		if(p.length() == 4){
			pattern = p;
		}
	}

	public int length(){
		return pattern.length();
	}

	public String toString(){
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
		return false;
	}
}