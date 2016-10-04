import java.io.*;

public class Pattern implements Serializable{
	private String pattern;

	public Pattern(String p){
			pattern = p;
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
		try{
			return pattern.equals(((Pattern )o).toString());
		}
		catch(Exception e){
            e.printStackTrace();
			System.out.print("Error comparing patterns");
		}
		return false;
	}
}