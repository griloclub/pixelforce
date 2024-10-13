package utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class YMDDateFormatTest {

	@Test
	public void testConvertDayMonthYearToYearMonthDayConsiderFriday() {
		assertEquals("20161028", new YMDDateFormat("28/10/2016").to());
	}

	@Test
	public void testConvertDayMonthYearToYearMonthDayConsiderSunday() {
		assertEquals("20161028", new YMDDateFormat("30/10/2016").to());
	}

	@Test
	public void testConvertDayMonthYearToYearMonthDayConsiderSaturday() {
		assertEquals("20161028", new YMDDateFormat("29/10/2016").to());
	}

	@Test
	public void testConvertDayMonthYearToYearMonthDayConsiderMonday() {
		assertEquals("20161031", new YMDDateFormat("31/10/2016").to());
	}
}
