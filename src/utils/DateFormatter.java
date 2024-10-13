package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class DateFormatter {
	private static final String DATE_SEPARATOR = "/";
	private int day;
	private int month;
	private int year;
	
	public DateFormatter(String dateToSplit) {
		String[] date = dateToSplit.split(DATE_SEPARATOR);
		
		day = Integer.parseInt(date[0]);
		month = Integer.parseInt(date[1]);
		year = Integer.parseInt(date[2]);
	}
	
	public String to() {
		LocalDate date = computeDateOnlyWithWorkingDays();
		
		return date.format(toFormat());
	}
	
	public abstract DateTimeFormatter toFormat();

	private LocalDate computeDateOnlyWithWorkingDays() {
		LocalDate workDate = LocalDate.of(year, month, day);
		
		if (workDate.getDayOfWeek() == DayOfWeek.SATURDAY)
			workDate = workDate.minusDays(1);
		else if (workDate.getDayOfWeek() == DayOfWeek.SUNDAY)
			workDate = workDate.minusDays(2);
		
		return workDate;
	}
}
