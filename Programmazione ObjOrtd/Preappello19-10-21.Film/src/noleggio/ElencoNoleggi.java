package noleggio;

import java.io.Serializable;
import java.util.ArrayList;

public class ElencoNoleggi implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5699846050150098132L;

	public void aggiungiNoleggio(Noleggio n) throws BadIDException {
		if (n.getFilm().getId() < 0) throw new BadIDException();
		noleggi.add(n);
	}
	
	public double calcolaPenaliRitardo() {
		double sum = 0;
		for (Noleggio noleggio : noleggi) {
			sum += noleggio.getFilm().calcolaPenaleRitardo(noleggio.getGiorniRitardo());
		}
		
		return sum;
	}
	
	
	public ArrayList<Noleggio> cerca(String t){
		ArrayList<Noleggio> trovati = new ArrayList<Noleggio>();
		for (Noleggio noleggio : noleggi) {
			if (noleggio.getFilm().getTitolo().contains(t))
				trovati.add(noleggio);
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
