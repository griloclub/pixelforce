package transform;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import model.CurrencyInfoFormat;
import model.exceptions.InvalidCurrencyException;
import reader.CSVFileReader;
import transform.exceptions.InvalidNumberException;

public class CurrencyConverterTest {
	private CurrencyConverter cc;
	private static final String TEST_FILE = "resources/test.csv";
	private CSVFileReader file;
	private CurrencyInfoFormat model;

	@Before
	public void setUp() throws FileNotFoundException, IOException {
		prepareData();
		cc = new CurrencyConverter(model);
	}
	
	@Test
	public void testConversionAFNToETB() {
		cc.setFrom("AFN");
		cc.setTo("ETB");
		cc.setValue(100.0);
		
		assertEquals(33.94, cc.currencyQuotation().doubleValue(), 0.01);
	}

	@Test(expected=InvalidCurrencyException.class)
	public void testConversionWithInvalidCurrency() {
		cc.setFrom("ANN");
		cc.setTo("ETB");
		cc.setValue(100.0);
		
		assertEquals(33.94, cc.currencyQuotation().doubleValue(), 0.01);
	}

	@Test(expected=InvalidNumberException.class)
	public void testConversionWithValueSmallerThanZero() {
		cc.setFrom("AFN");
		cc.setTo("ETB");
		cc.setValue(-10);
		
		assertEquals(33.94, cc.currencyQuotation().doubleValue(), 0.01);
	}

	private void prepareData() throws FileNotFoundException, IOException {
		model = new CurrencyInfoFormat();
		file = new CSVFileReader(TEST_FILE, model);
		file.open();
		file.readLineByLine();
		file.close();
	}
}
