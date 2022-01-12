package immobili;

import java.util.Objects;

public class Appartamento extends Immobile{
	public Appartamento(int id, String indirizzo, String proprietario, double valore, int stanze, int balconi) {
		super(id, indirizzo, proprietario, valore);
		this.stanze = stanze;
		this.balconi = balconi;
	}
	
	

	public int getStanze() {
		return stanze;
	}



	public void setStanze(int stanze) {
		this.stanze = stanze;
	}



	public int getBalconi() {
		return balconi;
	}



	public void setBalconi(int balconi) {
		this.balconi = balconi;
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
		Immobile other = (Appartamento) obj;
		return id == other.id && Objects.equals(indirizzo, other.indirizzo)
				&& Objects.equals(proprietario, other.proprietario)
				&& Double.doubleToLongBits(valore) == Double.doubleToLongBits(other.valore);
	}




	private int stanze, balconi;
}
