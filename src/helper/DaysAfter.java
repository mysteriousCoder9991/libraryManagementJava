package helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;

public class DaysAfter {
	static String newDate1;

	public static String process(String oldDate, int days) {
		// Given Date in String format
		// System.out.println("Date before Addition: "+oldDate);
		// Specifying date format that matches the given date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		try {
			// Setting the date to the given date
			c.setTime(sdf.parse(oldDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, days);
		// Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		// Displaying the new Date after addition of Days
		newDate1 = newDate.substring(6, 10) + "-" + newDate.substring(3, 5) + "-" + newDate.substring(0, 2);
		return newDate;
	}

	public static String convertDate(String od) {
		newDate1 = od.substring(6, 10) + "-" + od.substring(3, 5) + "-" + od.substring(0, 2);
		System.out.println(newDate1);
		return newDate1;
	}

	/*public static void main(String agrs[]) {
		// String nd=process("2020-01-12",7);
		String nd1 = process("31-12-2020", 7);
		System.out.println("new date  = " + nd1);
	}*/

}