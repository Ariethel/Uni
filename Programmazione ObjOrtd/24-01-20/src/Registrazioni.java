import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Registrazioni{
	public void aggiungiRegistrazione(Registrazione r) {
		registrazioni.add(r);
		ArrayList<Registrazione> ordinati = new ArrayList<Registrazione>();
		Registrazione min = null;
		for (Registrazione registrazione1 : registrazioni) {
			min = registrazione1;
			for (Registrazione registrazione2 : registrazioni) {
				if (min.compareTo(registrazione2) > 0) {
					min = registrazione2;
				}
			}
			ordinati.add(min);
		}
		
		registrazioni = ordinati;
		
	}
	
	
	public double dammiTotale() {
		double sum = 0;
		for (Registrazione registrazione : registrazioni) {
			sum += registrazione.calcolaCosto();
		}
		return sum;
	}
	
	public ArrayList<Registrazione> dammiRegistrazionePerTipoPartecipante(int x) throws InvalidParameterException{
		if (x != 1 && x != 0) throw new InvalidParameterException();
		ArrayList<Registrazione> trovati = new ArrayList<Registrazione>();
		if (x == 0) {
			for (Registrazione registrazione : registrazioni) {
				if (registrazione instanceof RegistrazioneStudenti)
					trovati.add(registrazione);
			}
		}
		
		if (x == 1) {
			for (Registrazione registrazione : registrazioni) {
				if (registrazione instanceof RegistrazioneProfessionisti)
					trovati.add(registrazione);
			}
		}
		
		return trovati;
	}
	
	public ArrayList<Registrazione> cerca(GregorianCalendar date){
		ArrayList<Registrazione> trovati = new ArrayList<Registrazione>();
		for (Registrazione registrazione : registrazioni) {
			if (registrazione.getDataRegistrazione().equals(date))
				trovati.add(registrazione);
		}
		
		return trovati;
	}
	
	ArrayList<Registrazione> registrazioni;

	

}
