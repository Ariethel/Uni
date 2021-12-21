package noleggio;

import java.util.ArrayList;

public class ElencoNoleggi {
	
	public void aggiungiNoleggio(Noleggio n) {
		for (Noleggio noleggio : noleggi) {
			if (noleggio.getFilm().dammiCodice() == n.getFilm().dammiCodice()){
				throw new BadCodeException();
			}
		}
		noleggi.add(n);
	}
	
	
	public double calcolaPenaliRitardi() {
		double totale = 0;
		for (Noleggio noleggio : noleggi) {
			totale += noleggio.getFilm().calcolaPenale(noleggio.getGiorniRitardo());
		}
		
		return totale;
	}
	
	public ArrayList<Noleggio> cerca(String t){
		ArrayList<Noleggio> trovati = new ArrayList<>();
		for (Noleggio noleggio : noleggi) {
			if (noleggio.getFilm().getTitolo().contains(t))
				trovati.add(noleggio);
		}
		
		return trovati;
	}
	
	
	ArrayList<Noleggio> noleggi = new ArrayList<Noleggio>();
}
