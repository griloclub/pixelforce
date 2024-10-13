package reader;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import org.junit.Test;

import model.ModelFormat;
import reader.CSVFileReader;
import reader.exceptions.QuotationNotFoundException;

public class CSVFileReaderTest {
	private static final String FILE_NOT_FOUND = "resources/filestest.csv";
	private static final String TEST_FILE = "resources/test.csv";
	private CSVFileReader file;
	private ModelFormat model;
	
	@Test(expected=QuotationNotFoundException.class)
	public void testFileNotExist() throws FileNotFoundException {
		model = new ModelFormatFake();
		file = new CSVFileReader(FILE_NOT_FOUND, model);
		assertNotNull(file);
		file.open();
	}

	@Test
	public void testFileFound() throws FileNotFoundException {
		model = new ModelFormatFake();
		file = new CSVFileReader(TEST_FILE, model);
		assertNotNull(file);
		file.open();
	}
}
