package noleggio;

public class Film {
	public Film(String codice, String titolo) {
		this.codice = codice;
		this.titolo = titolo;
	}

	public String dammiCodice() {
		return codice;
	}
	
	public String dammiTitolo() {
		return titolo;
	}
	
	public double calcolaPenaleRitardo(int giorniRitardo){
		return 2*giorniRitardo;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public boolean equals(Film f) {
		return (codice.equals(f.dammiCodice()) && titolo.equals(f.dammiTitolo()));
	}

	public String toString() {
		return "[codice " + dammiCodice() + ", titolo " + dammiTitolo() + "]";
	}


	private String codice,titolo;
}
