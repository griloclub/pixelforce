package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.ModelFormat;
import reader.exceptions.QuotationNotFoundException;

public class CSVFileReader implements FileFormatReader {
	private BufferedReader csvFileReader;
	private ModelFormat model;
	private String fileName;
	
	public CSVFileReader(String fileName, ModelFormat model) {
		this.fileName = fileName;
		this.model = model;
	}

	@Override
	public void open() throws FileNotFoundException {
		try {
			csvFileReader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			throw new QuotationNotFoundException("File not found");
		}
	}

	@Override
	public void readLineByLine() throws IOException {
		String fileLine;
		while ((fileLine = csvFileReader.readLine()) != null) {
			model.addLineListener(fileLine);
		}
	}

	@Override
	public void close() throws IOException {
		csvFileReader.close();
	}
}
