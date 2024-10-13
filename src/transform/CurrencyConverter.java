package transform;

import java.math.BigDecimal;

import model.Currency;
import model.CurrencyFormat;
import model.Money;
import transform.exceptions.InvalidNumberException;

public class CurrencyConverter {
	private Currency currency;
	private Money from;
	private Money to;
	private Number value;
	
	public CurrencyConverter(CurrencyFormat currencyFormat) {
		this.currency = new Currency(currencyFormat);
	}

	public void setFrom(String from) {
		this.from = currency.contains(from);
	}

	public void setTo(String to) {
		this.to = currency.contains(to);
	}

	public void setValue(Number value) {
		if (value.doubleValue() <= 0.0)
			throw new InvalidNumberException("Value is smaller than zero");
		this.value = value;
	}

	public BigDecimal currencyQuotation() {
		return BigDecimal.valueOf(
				format(value.doubleValue() * (from.getBuyingRate() / to.getBuyingRate())));
	}

	private double format(double value) {
		return Double.parseDouble(
				String.format("%.2f", value).replaceAll(",", "."));
	}
}
