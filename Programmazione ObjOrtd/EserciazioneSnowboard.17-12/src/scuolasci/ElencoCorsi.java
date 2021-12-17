package scuolasci;

import java.util.ArrayList;
import java.util.Iterator;

public class ElencoCorsi {

	public ElencoCorsi() {
		// TODO Auto-generated constructor stub
	}
	
	public void aggiungiCorso(Corso c) {
		this.corsi.add(c);
	}
	
	public Corso daiCorso(int i) {
		Corso[] c = (Corso[]) corsi.toArray();
		return c[i];
	}
	
	public Corso cancellaCorso(int i) {
		Corso c = corsi.get(i);
		corsi.remove(i);
		return c;
	
	}
	
	public ArrayList<Corso> dammiCorsi(String tipo){
		ArrayList<Corso> trovati = null;
		if (tipo.equalsIgnoreCase("CorsoSci")) {
			for (Corso corso : corsi) {
				if (corso instanceof CorsoSci)
					trovati.add(corso);
			}
		}else if (tipo.equalsIgnoreCase("CorsoSnowboard")) {
			for (Corso corso : trovati) {
				if (corso instanceof CorsoSnowboard)
					trovati.add(corso);
			}
		}
		
		return trovati;
	}
	
	
	
	public ArrayList<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(ArrayList<Corso> corsi) {
		this.corsi = corsi;
	}



	private ArrayList<Corso> corsi = new ArrayList<>();
	
}
