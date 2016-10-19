import java.lang.Comparable;

public class Song implements Comparable{
	private String title;
	private String artist;
	private String album;
	private int rating;

	public Song(String t, String ar, String al, int r){
		title = t;
		artist = ar;
		album = al;
		rating = r;
	}

	public int compareTo(Song s){
		if(rating == s.rating){
			return title.compareTo(s.title);
		}
		return rating - s.rating;
	}

	public String toString(){
		return title +"\n" + artist + "\n"
			+ album + "\n" + rating;
	}
	
}