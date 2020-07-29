package helper;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class DaysBetweenCalculate {

	public static long getDays(String fd,String ed)
	{
		LocalDate dateBefore = LocalDate.parse(fd);// date format yyyy-mm-dd
		LocalDate dateAfter = LocalDate.parse(ed);// date format yyyy-mm-dd
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		return noOfDaysBetween;
	}
	
	public static double feesCalculate(String fd,String ed)
	{
		long no=getDays(fd,ed);
		return no*10.0;
	}
	
}
