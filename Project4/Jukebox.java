import java.util.*;
import java.io.*;

public class Jukebox{
	public static void main(String[] args){
		Heap<Song> heap = new Heap<Song>();
		int menuChoice;

		load(heap);

		while(true){
			displayMenu();
			menuChoice = CheckInput.checkIntRange(1,6);

			switch(menuChoice){
				case 1:
                    System.out.println("");
					heap.printHeap();
					break;
				case 2:
                    System.out.println("");
					System.out.println(heap.getAt(0).toString());
                    System.out.println("");
					break;
				case 3:
					newSong(heap);
					break;
				case 4:
					heap.removeMin();
					System.out.println(heap.getAt(0).toString());
					break;
				case 5:
					reRate(heap);
					break;
				case 6:
					System.out.println("Goodbye");
					System.exit(0);
					break;

			}
		}


	}

	public static void load(Heap<Song> h){
		try{
			Scanner in = new Scanner(new File("songs.txt"));
			while(in.hasNext()){
				String songIn = in.nextLine();
				String songInfo[] = songIn.split(",");
				int rating = 0;
				try{
					rating = Integer.parseInt(songInfo[3]);
				}
				catch(Exception e){
					System.out.println("Error reading int from file");
				}
				Song song = new Song(songInfo[0], songInfo[1], songInfo[2],
					rating);
				h.add(song);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Error reading file");
		}
	}

	public static void displayMenu(){
        System.out.println("");
		System.out.println("1. List songs\n2. Current song\n3. Add song\n4. Play next\n5. Rate current song\n6. Quit");
	}


	public static void newSong(Heap<Song> h){
		String title = "";
		String artist = "";
		String album = "";
		int rating = 0;

		Scanner in = new Scanner(System.in);
		try{
            System.out.println("");
			System.out.println("Enter song title:");
			title = in.next();
			System.out.println("Enter artist name:");
			artist = in.next();
			System.out.println("Enter album name:");
			album = in.next();
			System.out.println("Enter rating");
			rating = CheckInput.checkIntRange(1,5);
            System.out.println("");

		}
		catch(Exception e){
			System.out.println("Error reading user input");
		}

		h.add(new Song(title, artist, album, rating));

	}

	public static void reRate(Heap<Song> h){
		String[] songInfo = h.getAt(0).toString().split("\n");
		int rating;

        System.out.println("");
		System.out.println("Enter new rating");
        System.out.println("");
		
		rating = CheckInput.checkIntRange(1,5);

        h.removeMin();
		Song song = new Song(songInfo[0], songInfo[1], songInfo[2],
			rating);
		h.add(song);

	}

}