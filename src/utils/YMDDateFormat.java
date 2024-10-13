package utils;

import java.time.format.DateTimeFormatter;

public class YMDDateFormat extends DateFormatter {

	public YMDDateFormat(String dateToSplit) {
		super(dateToSplit);
	}

	@Override
	public DateTimeFormatter toFormat() {
		return DateTimeFormatter.ofPattern("yyyyMMdd");
	}
}
