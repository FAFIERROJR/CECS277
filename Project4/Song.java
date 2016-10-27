import java.lang.Comparable;

/**
 * Song class
 * stores and handles a song
 *
 * @author Francisco Fierro
 */
public class Song implements Comparable<Song>{
	/** the name of the song */
	private String title;
	/** the performing artist */
	private String artist;
	/** the corresponding album  */
	private String album;
	/**the user's rating of the song */
	private int rating;

	/**
	 * Song()
	 * basic constructor
	 * @param  t  the title
	 * @param  ar the artist
	 * @param  al the album
	 * @param  r  the rating
	 * 
	 */
	public Song(String t, String ar, String al, int r){
		title = t;
		artist = ar;
		album = al;
		rating = r;
	}

	/**
	 * compareTo()
	 * you should know this one
	 * @param  s the song to which to compare
	 * @return   int describing relative order
	 */

	@Override
	public int compareTo(Song s){
		if(rating == s.rating){
			return title.compareTo(s.title);
		}
		return s.rating - rating;
	}

	/**
	 * toString
	 * converts song data into string
	 * @return the all song's data as a String
	 */
	public String toString(){
		return title +"\n" + artist + "\n"
			+ album + "\n" + rating + " stars";
	}
	
}