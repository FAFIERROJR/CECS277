import java.util.*;
import java.io.*;

/**
 * Jukebox
 * plays songs by order of highest rating first
 *
 * @author Francisco Fierro
 */
public class Jukebox{
    /**
     * main()
     * handles Jukebox features
     * @param args not used
     */
	public static void main(String[] args){
		Heap<Song> heap = new Heap<Song>();
		int menuChoice;

		load(heap);

		while(true){
			displayMenu();
			menuChoice = CheckInput.checkIntRange(1,6);

			switch(menuChoice){
				case 1:
                    if(!heap.isEmpty()){
                        System.out.println("");
                        heap.printHeap();
                    }
                    else{
                        System.out.println("No songs in queue");
                    }
					break;
				case 2:
                    if(!heap.isEmpty()){
                        System.out.println("");
                        System.out.println(heap.getAt(0).toString());
                        System.out.println("");
                    }
                    else{
                        System.out.println("No songs in queue");
                    }
					break;
				case 3:
					newSong(heap);
					break;
				case 4:
					heap.removeMin();
                    if(!heap.isEmpty()){
                        System.out.println("");
                        System.out.println(heap.getAt(0).toString());
                    }
                    else{
                        System.out.println("No songs in queue");
                    }
					break;
				case 5:
                    if(!heap.isEmpty()){
					   reRate(heap);
                    }
                    else{
                        System.out.println("No songs in queue");
                    }
					break;
				case 6:
					System.out.println("Goodbye");
					System.exit(0);
					break;

			}
		}


	}

    /**
     * load()
     * reads songs from file into heap
     * @param h the heap
     */
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

    /**
     * displayMenu()
     * displays Jukebox options
     */
	public static void displayMenu(){
        System.out.println("");
		System.out.println("1. List songs\n2. Current song\n3. Add song\n4. Play next\n5. Rate current song\n6. Quit");
	}


    /**
     * promps user for new song info
     * adds song to heap
     * @param h the heap
     */
	public static void newSong(Heap<Song> h){
		String title = "";
		String artist = "";
		String album = "";
		int rating = 0;

		Scanner in = new Scanner(System.in);
		try{
            System.out.println("");
			System.out.println("Enter song title:");
			title = in.nextLine();
			System.out.println("Enter artist name:");
			artist = in.nextLine();
			System.out.println("Enter album name:");
			album = in.nextLine();
			System.out.println("Enter rating");
			rating = CheckInput.checkIntRange(1,5);
            System.out.println("");

		}
		catch(Exception e){
			System.out.println("Error reading user input");
		}

		h.add(new Song(title, artist, album, rating));

	}

    /**
     * reRate
     * allows user to re rate current song
     * re adds to heap
     * @param h the heap
     */
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