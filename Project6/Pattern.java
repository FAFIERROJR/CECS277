import java.io.*;

/**
 * Pattern class
 * Wraps a string containg a short history
 * of user choices
 * @author Francisco Fierro
 * 
 */
public class Pattern implements Serializable{
	/** the history of user choices */
	private String pattern;

	/**
	 * Pattern()
	 * creates a pattern object
	 * which wraps the string pattern
	 * @param  p the pattern as a string
	 */
	public Pattern(String p){
			pattern = p;
	}


	/**
	 * length()
	 * @return the length of the pattern
	 */
	public int length(){
		return pattern.length();
	}

	/**
	 * toString()
	 * 
	 * @return [description]
	 */
	public String toString(){
		return pattern;
	}

	/**
	 * hashCode()
	 * overrides Java's hashCode()
	 * 
	 * @return string pattern's hashCode()
	 */
	@Override
	public int hashCode(){
		return pattern.hashCode();
	}


	/**
	 * equals()
	 * Overrides Java's .equals()
	 * compares two pattern's strings
	 * equal if characters are the same
	 * order matters
	 * 
	 * @param  o the object to compare to
	 * @return   true if equal, otherwise false
	 */
	@Override
	public boolean equals(Object o){
		if(o instanceof Pattern){
			return pattern.equals(((Pattern )o).pattern);
		}
		return false;
	}
}