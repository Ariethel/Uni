import java.io.Serializable;

public class Autoveicolo extends Automezzo implements Serializable{
	
	
	public Autoveicolo(String modello, String marca, String targa, int anno, String alimentazione, int numPorte, int numPosti) throws TargaErrataException {
		super(modello, marca, targa, anno);
		if (!targa.matches("[A-Z][A-Z]\\d\\d\\d[A-Z][A-Z]"))
			throw new TargaErrataException("Targa non valida");
		this.alimentazione = alimentazione;
		this.numPorte = numPorte;
		this.numPosti = numPosti;
	}
	
	
	
	
	@Override
	public String toString() {
		return super.toString() + " Alimentazione: " + getAlimentazione() + " Num Porte: " + getNumPorte() + " Num Posti: " + getNumPosti();
	}




	public String getAlimentazione() {
		return alimentazione;
	}




	public void setAlimentazione(String alimentazione) {
		this.alimentazione = alimentazione;
	}




	public int getNumPorte() {
		return numPorte;
	}




	public void setNumPorte(int numPorte) {
		this.numPorte = numPorte;
	}




	public int getNumPosti() {
		return numPosti;
	}




	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}




	private String alimentazione;
	private int numPorte,numPosti;
}
