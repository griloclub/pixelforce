package services;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;

import model.CurrencyInfoFormat;
import model.exceptions.InvalidCurrencyException;
import reader.exceptions.QuotationNotFoundException;
import transform.exceptions.InvalidNumberException;
import utils.YMDDateFormat;

public class CurrencyConverterServiceTest {
	private CurrencyConverterService ccs;

	@Test
	public void testConversionUSDToEUR() throws IOException {
		ccs = new CurrencyConverterService(new CurrencyInfoFormat(),
				new YMDDateFormat("26/10/2016"));
		
		assertEquals(91.6, 
				ccs.currencyQuotation("USD", "EUR", 100.0).doubleValue(), 0.01);
	}

	@Test(expected=QuotationNotFoundException.class)
	public void testConversionQuotationNotFound() throws IOException {
		ccs = new CurrencyConverterService(new CurrencyInfoFormat(),
				new YMDDateFormat("28/10/2016"));
		
		assertEquals(91.6, 
				ccs.currencyQuotation("USD", "EUR", 100.0).doubleValue(), 0.01);
	}

	@Test(expected=InvalidCurrencyException.class)
	public void testConversionCurrencyNotFound() throws IOException {
		ccs = new CurrencyConverterService(new CurrencyInfoFormat(),
				new YMDDateFormat("26/10/2016"));
		
		assertEquals(91.6, 
				ccs.currencyQuotation("GGG", "EUR", 100.0).doubleValue(), 0.01);
	} 
	
	@Test(expected=InvalidNumberException.class)
	public void testConversionValueSmallerThanZero() throws IOException {
		ccs = new CurrencyConverterService(new CurrencyInfoFormat(),
				new YMDDateFormat("26/10/2016"));
		
		assertEquals(91.6, 
				ccs.currencyQuotation("USD", "EUR", -100).doubleValue(), 0.01);
	} 
}
