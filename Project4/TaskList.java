import java.util.*;
import java.io.*;

/**
 * TaskList
 * handles to do list
 * @author Francisco Fierro
 */
public class TaskList{
	/**
	 * main()
	 * main function for task list
	 * @param args not used
	 */
	public static void main(String[] args){
		Heap<Job> heap = new Heap<Job>();
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
                        System.out.println("All tasks complete");
                    }
					break;
				case 2:
                    if(!heap.isEmpty()){
                        System.out.println("");
                        System.out.println(heap.getAt(0).toString());
                        System.out.println("");
                    }
                    else{
                        System.out.println("All tasks complete");
                    }
					break;
				case 3:
					newJob(heap);
					break;
				case 4:
					heap.removeMin();
                    if(!heap.isEmpty()){
                        System.out.println("");
                        System.out.println(heap.getAt(0).toString());
                    }
                    else{
                        System.out.println("All tasks complete");
                    }
					break;
				case 5:
                    if(!heap.isEmpty()){
					   postpone(heap);
                    }
                    else{
                        System.out.println("All tasks complete");
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
	 * reads jobs from list into heap
	 * @param h the heap
	 */
	public static void load(Heap<Job> h){
		try{
			Scanner in = new Scanner(new File("taskList.txt"));
			while(in.hasNext()){
				String jobIn = in.nextLine();
				String jobInfo[] = jobIn.split(",");
				String dateInfo[] = jobInfo[1].split("/");
				String timeInfo[] = dateInfo[2].split(" ");
				String timeSplit[] = timeInfo[1].split(":");
				int date[] = {0,0,0,0,0};
				try{
					date[0] = Integer.parseInt(dateInfo[0]);
					date[1] = Integer.parseInt(dateInfo[1]);
					date[2] = Integer.parseInt(timeInfo[0]);
					date[3] = Integer.parseInt(timeSplit[0]);
					date[4] = Integer.parseInt(timeSplit[1]);					
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

	/**
	 * displayMenu()
	 * displays task list options
	 */
	public static void displayMenu(){
        System.out.println("");
		System.out.println("1. List tasks\n2. Current task\n3. Add task\n4. Mark current task as complete\n5. Postpone current task\n6. Quit");
	}


	/**
	 * newJob()
	 * @param h the heap
	 */
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
			System.out.println("Enter task description:");
			name = in.nextLine();
			System.out.println("Enter month due");
			month = CheckInput.checkIntRange(1,12);
			System.out.println("Enter day due");
			day = CheckInput.checkIntRange(1,31);
			System.out.println("Enter year due");
			year = CheckInput.checkIntRange(2016,2100);
			System.out.println("Enter hour due (24 hour format)");
			hour = CheckInput.checkIntRange(1,24);
			System.out.println("Enter minute due");
			min = CheckInput.checkIntRange(0,59);
            System.out.println("");

		}
		catch(Exception e){
			System.out.println("Error reading user input");
		}

		h.add(new Job(name, month, day, year, hour, min));

	}

	/**
	 * postpone()
	 * updates task due date
	 * reintroduces to heap
	 * @param h the heap
	 */
	public static void postpone(Heap<Job> h){
		int month = 0;
		int day = 0;
		int year = 0;
		int hour = 0;
		int min = 0;

		String name = (h.getAt(0).toString().split("\n"))[0];

        System.out.println("Enter month due");
		month = CheckInput.checkIntRange(1,12);
		System.out.println("Enter day due");
		day = CheckInput.checkIntRange(1,31);
		System.out.println("Enter year due");
		year = CheckInput.checkIntRange(2016,2100);
		System.out.println("Enter hour due (24 hour format)");
		hour = CheckInput.checkIntRange(1,24);
		System.out.println("Enter minute due");
		min = CheckInput.checkIntRange(0,59);
        System.out.println("\n");

        h.removeMin();
		Job job = new Job(name, month, day, year, hour,
			min);
		h.add(job);
	}

}