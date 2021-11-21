package Rotaia.java;
import java.util.ArrayList;
import java.util.PrimitiveIterator.OfDouble;

public class Treno {
	public Treno(ArrayList<Stazioni> staz,Stazioni partenza, Stazioni arrivo, int posti, int km_tot,double prezzoKm) {
		this.staz = staz;
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.posti = posti;
		this.km_tot = km_tot;
		this.prezzoKm = prezzoKm;
	}
	
	public Treno(ArrayList<Stazioni> staz,Stazioni partenza, Stazioni arrivo, int posti, int km_tot,double prezzoKm,double prezzoRist) {
		this.staz = staz;
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.posti = posti;
		this.km_tot = km_tot;
		this.prezzoKm = prezzoKm;
		this.prezzoRistoranteKm = prezzoRist;
	}
	
	
	public int getFermate() {
		return staz.size();
	}
	
	public double getRicavo(Stazioni partenza, Stazioni arrivo) {
		int kmPercorsi = 0;
		for (Stazioni stazione : staz) {
			if (stazione.getNomeStazione() == arrivo.getNomeStazione()) {
				kmPercorsi+=stazione.kmDaPrec;
				return (prezzoKm*kmPercorsi*this.posti) + (prezzoRistoranteKm * kmPercorsi * this.posti);
			}
				
			kmPercorsi+=stazione.kmDaPrec;
		}
		return 0;
		
	}
	
	ArrayList<Stazioni> staz = new ArrayList<Stazioni>();
	Stazioni partenza = new Stazioni(null, 0, 0, 0);
	Stazioni arrivo = new Stazioni(null, 0, 0, 0);
	int posti;
	int km_tot;
	double prezzoRistoranteKm = 0;
	double prezzoKm;
}
