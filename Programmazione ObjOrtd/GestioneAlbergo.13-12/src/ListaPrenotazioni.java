import java.io.Serializable;
import java.util.ArrayList;

public class ListaPrenotazioni implements Serializable{

		public ListaPrenotazioni(ArrayList<Prenotazioni> prenotazioni) {
			this.prenotazioni = prenotazioni;
		}
		
		public void addPrenotazione(Prenotazioni pr) {
			prenotazioni.add(pr);
		}
		
		public void removePrenotazione(Prenotazioni pr) {
			prenotazioni.remove(pr);
		}
		
		
		
		private ArrayList<Prenotazioni> prenotazioni;
	}

