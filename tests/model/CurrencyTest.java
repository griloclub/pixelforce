package model;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import model.exceptions.InvalidCurrencyException;
import reader.CSVFileReader;

public class CurrencyTest {
	private static final String TEST_FILE = "./resources/test.csv";
	private CSVFileReader file;
	private CurrencyInfoFormat model;
	private Currency currency;

	@Before
	public void setUp() throws FileNotFoundException, IOException {
		prepareData();
		currency = new Currency(model);
	}
	
	@Test
	public void testMoneyFound() {
		Money money = currency.contains("AFN");
		assertNotNull(money);
	}
	
	@Test(expected=InvalidCurrencyException.class)
	public void testMoneyNotFound() {
		Money money = currency.contains("IDI");
		assertNotNull(money);
	}

	private void prepareData() throws FileNotFoundException, IOException {
		model = new CurrencyInfoFormat();
		file = new CSVFileReader(TEST_FILE, model);
		file.open();
		file.readLineByLine();
		file.close();
	}
}
