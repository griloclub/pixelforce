package model;

import java.util.Map;

import model.exceptions.InvalidCurrencyException;

public class Currency {
	private Map<String, Money> infos;
	
	public Currency(CurrencyFormat model) {
		infos = model.getInfo();
	}
	
	public Money contains(String code) {
		if (!infos.containsKey(code))
			throw new InvalidCurrencyException("Currency not exist on this file");
		return infos.get(code);
	}
}
