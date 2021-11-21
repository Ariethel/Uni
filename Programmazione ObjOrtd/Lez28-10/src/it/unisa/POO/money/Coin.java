package it.unisa.POO.money;

public class Coin{
	public Coin(String coinName, int value) {
		this.coinName = coinName;
		this.value = value;
	}
	
	public String getCoinName() {
		return coinName;
	}
	
	public int getValue() {
		return value;
	}
	


	private final String coinName;
	private final int value;
}
