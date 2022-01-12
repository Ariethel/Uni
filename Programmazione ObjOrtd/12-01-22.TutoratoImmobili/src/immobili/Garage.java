package immobili;

import java.util.Objects;

public class Garage extends Immobile{
	public Garage(int id, String indirizzo, String proprietario, double valore, int posti) {
		super(id, indirizzo, proprietario, valore);
		this.posti = posti;
	}
	
	
	public int getPosti() {
		return posti;
	}


	public void setPosti(int posti) {
		this.posti = posti;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Immobile other = (Garage) obj;
		return id == other.id && Objects.equals(indirizzo, other.indirizzo)
				&& Objects.equals(proprietario, other.proprietario)
				&& Double.doubleToLongBits(valore) == Double.doubleToLongBits(other.valore);
	}



	private int posti;
}
