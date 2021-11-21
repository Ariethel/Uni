package it.unisa.POO.money;
import java.util.ArrayList;
import java.util.Iterator;

public class Portamonete {
	public Portamonete(int startValue) {
		this.total = startValue;
	}

	public void addCoin(Coin aCoin) {
		total += aCoin.getValue();
		coinArray.add(aCoin);
	}

	public void removeCoin(Coin aCoin) {
		for (Coin coin : coinArray) {
			if((coin.getCoinName().equals(aCoin.getCoinName())) && (coin.getValue() == aCoin.getValue())) {
				total -= coin.getValue();
				coinArray.remove(coin);
				break;
			}

		}
	}

	public boolean hasCoin(Coin aCoin) {
		for (Coin coin : coinArray) {
			if((coin.getCoinName().equals(aCoin.getCoinName())) && (coin.getValue() == aCoin.getValue())) {
				return true;
			}
		}
		return false;
	}

	public int getTotal() {
		return total;
	}

	public String toString() {
		for (Coin coin : coinArray) {
			if (coin.getValue() == 50)
				_50cent++;
			if (coin.getValue() == 1)
				_1euro++;
			if (coin.getValue() == 5)
				_5euro++;
		}
		String resoconto = "[50 cent = " + _50cent + ";1 euro = " + _1euro + ";5 euro = " + _5euro + "]";
		return resoconto;

	}

	public boolean equals(Portamonete purse2) {
		System.out.println("Salvadanaio 1: " + this.toString());
		System.out.println("Salvadanaio 2: " + purse2.toString());
		if (this._1euro == purse2.get_1euro() && this._50cent == purse2.get_50cent() && this._5euro == purse2.get_5euro())
			return true;
		else 
			return false;

	}

	public int get_50cent() {
		return _50cent;
	}

	public void set_50cent(int _50cent) {
		this._50cent = _50cent;
	}

	public int get_1euro() {
		return _1euro;
	}

	public void set_1euro(int _1euro) {
		this._1euro = _1euro;
	}

	public int get_5euro() {
		return _5euro;
	}

	public void set_5euro(int _5euro) {
		this._5euro = _5euro;
	}

	private int total;
	private int _50cent,_1euro,_5euro;
	ArrayList<Coin> coinArray = new ArrayList<Coin>();
}
