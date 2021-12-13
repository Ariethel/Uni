import java.io.Serializable;
import java.util.ArrayList;

public class ListaStanze implements Serializable{

		public ListaStanze(ArrayList<Stanze> stanze) {
			this.stanze = stanze;
		}
		
		public void addPrenotazione(Stanze pr) {
			stanze.add(pr);
		}
		
		public void removePrenotazione(Stanze pr) {
			stanze.remove(pr);
		}
		
		
		
		private ArrayList<Stanze> stanze;
	}

