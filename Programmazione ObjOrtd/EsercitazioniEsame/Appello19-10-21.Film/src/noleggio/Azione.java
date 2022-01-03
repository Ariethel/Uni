package noleggio;

public class Azione extends Film{
	public Azione(String codice, String titolo) {
		super(codice, titolo);
	}

	public double calcolaPenaleRitardo(int giorniRitardo){
		return 3.00*giorniRitardo;
	}
	
	public String dammiCodice() {
		return codice;
	}
	
	public String dammiTitolo() {
		return titolo;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public boolean equals(Film f) {
		return super.equals(f);
	}

	public String toString() {
		return super.toString();
	}
	
	private String codice, titolo;
}
