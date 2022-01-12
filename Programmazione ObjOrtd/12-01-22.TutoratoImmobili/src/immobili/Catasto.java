package immobili;

import java.util.ArrayList;

public class Catasto {
	public void aggiungi(Immobile i) {
		immobili.add(i);
	}
	
	public double calcolaValore() {
		double sum = 0;
		for (Immobile immobile : immobili) {
			sum += immobile.getValore();
		}
		
		return sum;
	}
	
	public ArrayList<Immobile> cercaImmobili(double value){
		ArrayList<Immobile> trovati = new ArrayList<Immobile>();
		for (Immobile immobile : immobili) {
			if (immobile.getValore() < value)
				trovati.add(immobile);
		}
		return trovati;
	}
	
	public void rimuoviImmobile(Immobile i) {
		for (Immobile immobile : immobili) {
			if (immobile.equals(i))
				immobili.remove(immobile);
		}
	}
	
	
	
	private ArrayList<Immobile> immobili = new ArrayList<Immobile>();
}
