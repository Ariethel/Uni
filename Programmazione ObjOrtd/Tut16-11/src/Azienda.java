import java.util.ArrayList;

public class Azienda {
	public Azienda(ArrayList<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}
	
	public double getTotaleStipendi() {
		for (Dipendente dip : dipendenti) {
			totaleStipendi += dip.getStipendio();
		}
		
		return totaleStipendi;
	}
	
	public ArrayList<Dipendente> getDipendentiPartTime(){
		ArrayList<Dipendente> trovati = new ArrayList<Dipendente>();
		for (Dipendente dip : dipendenti) {
			if (dip instanceof DipendentePartTime)
				trovati.add(dip);
		}
		
		return trovati;
	} 
	
	public ArrayList<Dipendente> getDipendentiFullTime(){
		ArrayList<Dipendente> trovati = new ArrayList<Dipendente>();
		for (Dipendente dip : dipendenti) {
			if (dip instanceof DipendenteFullTime)
				trovati.add(dip);
		}
		
		return trovati;
	} 
	
	public double cercaMax(ArrayList<Dipendente> dipend) {
		double max = 0;
		for (Dipendente dip : dipend) {
			if (max == 0 || dip.getStipendio() > max)
				max = dip.getStipendio();
		}
		return max;
	}
	
	
	public String cercaStipendioPiuAlto() {
		double max = cercaMax(this.dipendenti);
		ArrayList<Dipendente> trovati = new ArrayList<Dipendente>();
		for (Dipendente dip : this.dipendenti) {
			if (dip.getStipendio() == max)
				trovati.add(dip);
		}
		
		
		for (Dipendente dip : trovati) {
			System.out.println("Dipendente [" + dip.getMatricola() + ", " + dip.getStipendio()+ "]");
		}
		return ("\n");
	}
	
	
	public void licenziaDipendenti(int max) {
		ArrayList<Dipendente> partTime = this.getDipendentiPartTime();
		for (Dipendente dip : partTime) {
			if (((DipendentePartTime) dip).getMalattia() > max)
				this.dipendenti.remove(dip);
				
		}
	}
	
	ArrayList<Dipendente> dipendenti = new ArrayList<Dipendente>();
	double totaleStipendi;
	
}
