package services;

import java.io.IOException;
import java.math.BigDecimal;

import model.CurrencyFormat;
import reader.CSVFileReader;
import reader.FileFormatReader;
import transform.CurrencyConverter;
import utils.DateFormatter;
import utils.FileNameFormatter;

public class CurrencyConverterService {
	private CurrencyConverter cc;
	private FileFormatReader file;
	
	public CurrencyConverterService(CurrencyFormat currencyFormat, 
									DateFormatter date) throws IOException {
		this.file = new CSVFileReader(FileNameFormatter.format(date.to()),
							currencyFormat);
		prepareData();
		cc = new CurrencyConverter(currencyFormat);
	}
	
	private void prepareData() throws IOException {
		file.open();
		file.readLineByLine();
		file.close();
	}

	public BigDecimal currencyQuotation(String from, String to, 
			Number value) {
		cc.setFrom(from);
		cc.setTo(to);
		cc.setValue(value);
		
		return cc.currencyQuotation();
	}
}
