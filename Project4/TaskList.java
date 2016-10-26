import java.util.*;
import java.io.*;

public class Jukebox{
	public static void main(String[] args){
		Heap<Job> heap = new Heap<Job>();
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

	public static void load(Heap<Job> h){
		try{
			Scanner in = new Scanner(new File("taskList.txt"));
			while(in.hasNext()){
				String jobIn = in.nextLine();
				String jobInfo[] = songIn.split(",");
				String dateInfo[] = jobInfo[1].split("/");
				String timeInfo[] = dateInfo[2].split(" ");
				String timeSplit[] = timeInfo[1].split(":");
				int date[] = {0,0,0,0,0};
				try{
					date[0] = Integer.tryParse(dateInfo[0]);
					date[1] = Integer.tryParse(dateInfo[1]);
					date[2] = Integer.tryParse(timeInfo[0]);
					date[3] = Integer.tryParse(timeSplit[0]);
					date[4] = Integer.tryParse(timeSplit[1]);					
				}
				catch(Exception e){
					System.out.println("Error reading int from file");
				}
				Job job = new Job(jobInfo[0], date[0], date[1], date[2],
					date[3], date[4]);
				h.add(job);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Error reading file");
		}
	}

	public static void displayMenu(){
        System.out.println("");
		System.out.println("1. List tasks\n2. Current task\n3. Add task\n4. Next task\n5. Postpone current task\n6. Quit");
	}


	public static void newJob(Heap<Job> h){
		String name = "";
		int month = 0;
		int day = 0;
		int year = 0;
		int hour = 0;
		int min = 0;

		Scanner in = new Scanner(System.in);
		try{
            System.out.println("");
			System.out.println("Enter song title:");
			name = in.nextLine();
			System.out.println("Enter month due");
			month = CheckInput.checkIntRange(1,12);
			System.out.println("Enter day due");
			day = CheckInput.checkIntRange(1,31);
			System.out.println("Enter year due");
			year = CheckInput.checkIntRange(2016,2100);
			System.out.println("Enter hour due (24 hour format");
			hour = CheckInput.checkIntRange(1,24);
			System.out.println("Enter minute due");
			minute = CheckInput.checkIntRange(0,59);
            System.out.println("");

		}
		catch(Exception e){
			System.out.println("Error reading user input");
		}

		h.add(new Song(title, artist, album, rating));

	}

	public static void reRate(Heap<Job> h){ String[] songInfo =
		h.getAt(0).toString().split("\n"); int rating;

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