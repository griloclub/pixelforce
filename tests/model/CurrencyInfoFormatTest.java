package model;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import org.junit.Test;

import reader.CSVFileReader;

public class CurrencyInfoFormatTest {
	private static final String TEST_FILE = "./resources/test.csv";
	private Map<String, Money> infos;
	private CSVFileReader file;
	private CurrencyInfoFormat model;
	
	@Test
	public void testInformationLoadedByListener() throws IOException {
		prepareData();
		infos = model.getInfo();

		Money money = infos.get("AFN");
		assertEquals("AFN",  money.getCode());
		assertEquals('A', money.getType());
		assertEquals(5, money.getId());
		assertEquals(0.04718000, money.getBuyingRate(), 0.0000001);
	}

	private void prepareData() throws FileNotFoundException, IOException {
		model = new CurrencyInfoFormat();
		file = new CSVFileReader(TEST_FILE, model);
		file.open();
		file.readLineByLine();
		file.close();
	}
}
