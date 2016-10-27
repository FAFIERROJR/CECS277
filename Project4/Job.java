import java.lang.Comparable;

/**
 * Job
 * @author Francisco Fierro
 * 
 */
public class Job implements Comparable<Job>{
	private String taskName;
	private int month;
	private int year;
	private int day;
	private int hour;
	private int minute;

	/**
	 * Job()
	 * basic construxctor
	 * @param  t   the task
	 * @param  mon the month due
	 * @param  d   the day due
	 * @param  y   the year due
	 * @param  h   the hour due
	 * @param  min the minute due
	 */
	public Job(String t, int mon, int d, int y, int h, int min){
		taskName = t;
		month = mon;
		day = d;
		year = y;
		hour = h;
		minute = min;
	}

	/**
	 * compareTo()
	 * overrides Comparable's
	 * @param  j the job to compare to
	 * @return   int describing relative order
	 */
	public int compareTo(Job j){
		if(year == j.year){
			if(month == j.month){
				if(day == j.day){
					if(hour == j.hour){
						return minute - j.minute;
					}
					return hour - j.hour;
				}
				return day - j.day;
			}
			return month - j.month;
		}
		return year - j.year;
	}

	public String toString(){
		return taskName + "\nDue Date: " + month + "/" + day + "/" + year + " " +
			hour + ":" + String.format("%02d", minute);
	}
}