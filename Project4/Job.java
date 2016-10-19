import java.lang.Comparable

public class Job implements Comparable{
	private String taskName;
	private int dueDate;

	public Job(String t, int d){
		taskName = t;
		dueDate = d;
	}

	public compareTo(Job j){
		if (dueDate == j.dueDate){
			return taskName.compareTo(j.taskName);
		}
		return dueDate - j.dueDate;
	}

	public String toString(){
		return taskName + "\nDue Date: " + dueDate;
	}
}