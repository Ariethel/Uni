import java.util.ArrayList;

public class ElencoArticoli {
	public void aggiungiArticolo(Articolo a) {
		articoli.add(a);
	}
	
	public Articolo getArticolo(double x) {
		Articolo trovato = null;
		for (Articolo articolo : articoli) {
			if (articolo.getPrezzo() == x) {
				trovato = articolo;
			}
		}
		return trovato;
	}
	
	public ArrayList<Articolo> cerca(String p){
		ArrayList<Articolo> trovati = null;
		for (Articolo articolo : articoli) {
			if (articolo.getNome().equals(p)) {
				trovati.add(articolo);
			}
		}
		return trovati;
	}
	
	public double dammiTotale() {
		double sum = 0;
		for (Articolo articolo : articoli) {
			sum+= articolo.getPrezzo();
		}
		return sum;
	}
	
	private ArrayList<Articolo> articoli;
}
