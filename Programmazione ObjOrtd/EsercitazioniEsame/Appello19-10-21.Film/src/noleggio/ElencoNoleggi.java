package noleggio;

import java.util.ArrayList;

public class ElencoNoleggi {
	
	public void aggiungNoleggio(Noleggio n) {
		for (Noleggio noleggio : noleggi) {
			if (n.dammiCodice().equals(noleggio.dammiCodice()))
				throw new BadCodeException(); 
		}
		noleggi.add(n);
	}
	
	public double calcolaPenaliRitardo() {
		double sum = 0;
		for (Noleggio noleggio : noleggi) {
			sum+= noleggio.getFilm().calcolaPenaleRitardo(noleggio.getGiorniRitardo());
		}
		
		return sum;
	}
	
	public ArrayList<Noleggio> cerca(String t){
		ArrayList<Noleggio> trovati = new ArrayList<Noleggio>();
		for (Noleggio noleggio : noleggi) {
			if (noleggio.getFilm().dammiTitolo().contains(t)) trovati.add(noleggio);
		}
		
		return trovati;
	}
	
	
	
	public ArrayList<Noleggio> getNoleggi() {
		return noleggi;
	}

	public void setNoleggi(ArrayList<Noleggio> noleggi) {
		this.noleggi = noleggi;
	}



	private ArrayList<Noleggio> noleggi = new ArrayList<Noleggio>();
}
