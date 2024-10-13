package model;

import java.util.HashMap;
import java.util.Map;

public class CurrencyInfoFormat implements CurrencyFormat {
	private static final int MONEY_ID = 1;
	private static final int MONEY_TYPE = 2;
	private static final int MONEY_CODE = 3;
	private static final int MONEY_BUYING_RATE = 4;
	private Map<String, Money> infos;
	private String csvSplitBy = ";";
	
	public CurrencyInfoFormat() {
		infos = new HashMap<String, Money>();
	}

	public String getCSVSplitBy() {
		return csvSplitBy;
	}
	
	public void setCSVSplitBy(String csvSplitBy) {
		this.csvSplitBy = csvSplitBy;
	}
	
	@Override
	public void addLineListener(String fileLine) {
		String[] information = fileLine.split(getCSVSplitBy());

		add(new Money(Integer.parseInt(information[MONEY_ID]),
				information[MONEY_TYPE].charAt(0),
				information[MONEY_CODE],
				Double.parseDouble(information[MONEY_BUYING_RATE].replaceAll(",", ".")))
			);
	}
	
	private void add(Money money) {
		infos.put(money.getCode(), money);
	}
	
	@Override
	public Map<String, Money> getInfo() {
		return infos;
	}
}
