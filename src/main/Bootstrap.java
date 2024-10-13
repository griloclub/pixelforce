package main;

import java.io.IOException;

import model.CurrencyInfoFormat;
import services.CurrencyConverterService;
import utils.YMDDateFormat;

public class Bootstrap {

	public static void main(String[] args) throws IOException {
		try {
		CurrencyConverterService ccs = new CurrencyConverterService(new CurrencyInfoFormat(),
				new YMDDateFormat("26/10/2016"));
		
		System.out.println(ccs.currencyQuotation("USD", "EUR", 100.0));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
