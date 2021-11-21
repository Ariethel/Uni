
public class Elettronico extends Prodotto{
	public Elettronico(int codice, double prezzo, int quantita, Boolean inOfferta, String descrizione, String marca,int anniGaranzia, double prezzoAnnualeGaranzia) {
		super(codice, prezzoAnnualeGaranzia, quantita, inOfferta, descrizione, marca);
		this.anniGaranzia = anniGaranzia;
		this.prezzoAnnualeGaranzia = prezzoAnnualeGaranzia;
	}
	
	public double calcolaCostoGaranzia(int p) {
		return prezzoAnnualeGaranzia*p;
	}
	
	public Boolean acquista(int p) {
		if (this.getQuantita() > p) {
			this.setQuantita(this.getQuantita()-p);
			return true;
		}else {
			return false;
		}
	}
	
	int anniGaranzia;
	double prezzoAnnualeGaranzia;
}
