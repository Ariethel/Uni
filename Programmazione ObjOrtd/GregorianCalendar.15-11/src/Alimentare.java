import java.util.GregorianCalendar;

public class Alimentare extends Prodotto {
	
	public Alimentare (int codice, double prezzo, int quantita, Boolean inOfferta, String descrizione, String marca,GregorianCalendar dataScadenza,int peso) {
		super(codice, prezzo, quantita, inOfferta, descrizione, marca);
		this.dataScadenza = dataScadenza;
		this.peso = peso;
	}
	
	public Boolean eScaduto() {
		GregorianCalendar dataAttuale = new GregorianCalendar();
		if (dataAttuale.after(dataScadenza))
			return true;
		else 
			return false;
	}
	
	public Boolean acquista(int p) {
		if (this.getQuantita() > p) {
			this.setQuantita(this.getQuantita()-p);
			return true;
		}else {
			return false;
		}
	}
	
	GregorianCalendar dataScadenza = new GregorianCalendar();
	int peso;
}
