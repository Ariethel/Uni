package scuolasci;

import java.util.ArrayList;

public class ElencoCorsi<T extends Corso>{
	
	public void aggiungiCorso(T c) {
		corsi.add(c);
	}
	
	public T rimuoviCorso(int i) {
		Object obj = corsi.get(i);
		corsi.remove(i);
		return (T) obj;
		
	}
	
	public T daiCorso(int i) {
		Object obj = corsi.get(i);
		return (T) obj;
	}
	
	public ArrayList<T> dammiCorsi(String tipo){
		ArrayList<T> trovati = new ArrayList<T>();
		for (T t : trovati) {
			if (t.getTipo().equals(tipo)) trovati.add(t);			
		}
		
		return trovati;
	}
	
	ArrayList<T> corsi = new ArrayList<T>();
}
