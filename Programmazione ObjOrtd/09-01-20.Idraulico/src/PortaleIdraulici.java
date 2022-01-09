import java.util.ArrayList;

public class PortaleIdraulici {
	
	public void aggiungi(Idraulico i) {
		idraulici.add(i);
	}
	
	public void effettuaIntervento(int mat, Interventi i) {
		for (Idraulico idraulico : idraulici) {
			if (idraulico.getMatricola() == mat)
				idraulico.effettuaIntervento(i);
		}
	}
	
	public Idraulico piuInterventi() {
		int max = 0;
		Idraulico i = null;
		for (Idraulico idraulico : idraulici) {
			if (idraulico.getNumInterventi() > max) {
				max = idraulico.getNumInterventi();
				i = idraulico;
				
			}
		}
		
		return i;
	}
	
	
	private ArrayList<Idraulico> idraulici;
}
