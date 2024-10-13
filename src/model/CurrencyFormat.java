package model;

import java.util.Map;

public interface CurrencyFormat extends ModelFormat {
	Map<String, Money> getInfo();
}
