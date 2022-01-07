package noleggio;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;

public class ElencoNoleggi {
	void aggiungiNoleggio(Noleggio n) {
		noleggi.add(n);
		int min = 0;
		ArrayList<Noleggio> ordinati = new ArrayList<Noleggio>();
		for (Noleggio noleggio : noleggi) {
			if (min == 0 || noleggio.getIdCliente())
		}
	}
	
	private ArrayList<Noleggio> noleggi;
}
