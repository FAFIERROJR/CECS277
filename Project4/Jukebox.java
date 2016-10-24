import java.util.*;
import java.io.*;

public class Jukebox{
	public static void main(String[] args){
		Heap heap = new Heap<Song>();
		int menuChoice 0;
		Song currentSong;

		load(heap);
		currentSong = heap.getAt(0);

		while(True){
			displayMenu();
			menuChoice = CheckInput.checkIntRange(1,6);

			switch(menuChoice){
				case 1:
					listSongs(heap);
					break;
				case 2;
					System.out.println(currentSong.toString());
					break;
				case 3:
					newSong(heap);
					break;
				case 4:
					heap.removeMin();
					currentSong = heap.getAt(0);
					System.out.println(currentSong.toString());
					break;
				case 5:
					reRate(heap);
					break;
				case 6:
					System.out.println("Goodbye");
					System.out.exit(0);
					break;

			}
		}


	}

	public void load(Heap h){
		Scanner in = new Scanner("songs.txt");
		while(in.hasNext()){
			String[] songInfo = in.nextLine().split(",");
			int rating = 0;
			try{
				rating = Integer.parseInt(songInfo[3]);
			}
			catch(NumberFormatException e){
				System.out.println("Error reading int from file");
			}
			Song song = new Song(songInfo[0], songInfo[1], songInfo[2],
				rating);
			heap.add(song);
		}
	}

	public void displayMenu(){
		System.out.println("1. List songs\n2.Current song\n3.Add song\n
			4. Play next 5. Rate current song\n6. Quit");
	}

	public void listSongs(Heap h){
		for(int i = 0; i < h.size(); i++){
			Song s = h.getAt(i);
			System.out.println(s.toString() + "\n");
		}

	}

	public void newSong(Heap h){
		String title;
		String artist;
		String album;
		int rating;

		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter song title:");
			title = in.next();
			System.out.println("Enter artist name:");
			artist = in.next();
			System.out.println("Enter album name:");
			album = in.next();
			System.out.println("Enter rating");
			rating = CheckInput.checkIntRange(1,5);

		}
		catch(Exception e){
			System.out.println("Error reading user input");
		}

	}

	public void reRate(Heap h){
		String[] songInfo = heap.getAt(0).toString().split("\n");
		int rating;

		System.out.println("Enter new rating");
		
		rating = CheckInput.checkIntRange(1,5);

		Song song = new Song(songInfo[0], songInfo[1], songInfo[2],
			rating);
		heap.add(song);

	}

}