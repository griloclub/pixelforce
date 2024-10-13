package model;

public class Money {
	private int id;
	private char type;
	private String code;
	private double buyingRate;

	public Money(int id, char type, String code, double buyingRate) {
		this.id = id;
		this.type = type;
		this.code = code;
		this.buyingRate = buyingRate;
	}
	
	public int getId() {
		return id;
	}

	public char getType() {
		return type;
	}

	public String getCode() {
		return code;
	}
	
	public double getBuyingRate() {
		return buyingRate;
	}
}
