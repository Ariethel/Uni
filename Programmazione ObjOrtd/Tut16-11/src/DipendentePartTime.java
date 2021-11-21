
public class DipendentePartTime extends Dipendente{
	public DipendentePartTime(String matricola, double stipendio, double straordinario){
		super(matricola, stipendio, straordinario);
		malattia = 0;
		
	}
	
	public void prendiMalattia(int giorni) {
		this.malattia = giorni;
	}
	
	@Override
	public double paga(int giorniStraordinario) {
		double stipendio;
		stipendio = super.paga(giorniStraordinario);
		if (malattia > 0)
			stipendio -= (malattia*15.0);
			
		return stipendio > 0 ? stipendio : 0.00;
	}
	
	
	public int getMalattia() {
		return malattia;
	}

	int malattia;
}
