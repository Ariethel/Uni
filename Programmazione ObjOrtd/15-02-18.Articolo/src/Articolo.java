import java.util.Objects;

import javax.sound.midi.Soundbank;

public class Articolo {
	public Articolo(String nome, String provenienza, int codice, double prezzo) {
		this.nome = nome;
		Provenienza = provenienza;
		this.codice = codice;
		this.prezzo = prezzo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProvenienza() {
		return Provenienza;
	}
	public void setProvenienza(String provenienza) {
		Provenienza = provenienza;
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
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
		Articolo other = (Articolo) obj;
		return Objects.equals(Provenienza, other.Provenienza) && codice == other.codice
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(prezzo) == Double.doubleToLongBits(other.prezzo);
	}

	@Override
	public String toString() {
		return "Articolo [nome=" + nome + ", Provenienza=" + Provenienza + ", codice=" + codice + ", prezzo=" + prezzo
				+ "]";
	}

	

	private String nome, Provenienza;
	private int codice;
	private double prezzo;
}
