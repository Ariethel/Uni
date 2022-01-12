package immobili;

import java.util.Objects;

public class Immobile {
	public Immobile(int id, String indirizzo, String proprietario, double valore) {
		this.id = id;
		this.indirizzo = indirizzo;
		this.proprietario = proprietario;
		this.valore = valore;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public double getValore() {
		return valore;
	}
	public void setValore(double valore) {
		this.valore = valore;
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
		Immobile other = (Immobile) obj;
		return id == other.id && Objects.equals(indirizzo, other.indirizzo)
				&& Objects.equals(proprietario, other.proprietario)
				&& Double.doubleToLongBits(valore) == Double.doubleToLongBits(other.valore);
	}


	@Override
	public String toString() {
		return "Immobile [id=" + id + ", indirizzo=" + indirizzo + ", proprietario=" + proprietario + ", valore="
				+ valore + "]";
	}







	protected int id;
	protected String indirizzo;
	protected String proprietario;
	protected double valore;
}
