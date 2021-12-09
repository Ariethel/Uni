import java.io.Serializable;

public class Motociclo extends Automezzo implements Serializable{
	
	
	public Motociclo(String modello, String marca, String targa, int anno, int numRuote, int numPasseggeri) throws TargaErrataException {
		super(modello, marca, targa, anno);
		if (!targa.matches("[A-Z][A-Z]\\d\\d\\d\\d\\d"))
			throw new TargaErrataException("Targa non valida");
		this.numRuote = numRuote;
		this.numPasseggeri = numPasseggeri;
	}
	
	

	@Override
	public String toString() {
		return super.toString() + " Num Ruote: " + getNumRuote() + " Num Passeggeri: " + getNumPasseggeri();
	}



	public int getNumRuote() {
		return numRuote;
	}



	public void setNumRuote(int numRuote) {
		this.numRuote = numRuote;
	}



	public int getNumPasseggeri() {
		return numPasseggeri;
	}



	public void setNumPasseggeri(int numPasseggeri) {
		this.numPasseggeri = numPasseggeri;
	}



	int numRuote, numPasseggeri;
}
