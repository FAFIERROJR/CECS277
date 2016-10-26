import java.lang.Comparable

public class Job implements Comparable<Job>{
	private String taskName;
	private int month;
	private int year;
	private int day;
	private int hour;
	private int minute;

	public Job(String t, int m, int d, int y, int h, int m),{
		taskName = t;
		month = m;
		day = d;
		year = y;
		hour = h;
		minute = m;
	}

	public compareTo(Job j){
		if(year == year){
			if(month = month){
				if(day == day){
					if(hour == hour){
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
			hour + ":" + minute;
	}
}