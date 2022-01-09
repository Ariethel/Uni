import java.util.GregorianCalendar;

public class RegistrazioneStudenti extends Registrazione{
	
	public RegistrazioneStudenti(String nome, String cognome, GregorianCalendar dataRegistrazione,
			String nomeUniversita, String tipologia) throws BadDateException {
		super(nome, cognome, dataRegistrazione);
		this.nomeUniversita = nomeUniversita;
		this.tipologia = tipologia;
	}
	
	

	public String getNomeUniversita() {
		return nomeUniversita;
	}



	public void setNomeUniversita(String nomeUniversita) {
		this.nomeUniversita = nomeUniversita;
	}



	public String getTipologia() {
		return tipologia;
	}



	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	
	public boolean isInRitardo() {
		return this.dataRegistrazione.after(new GregorianCalendar(2020,1,31));
	}
	
	
	public int calcolaCosto() {
		if (this.isInRitardo())
			return 300;
		
		return 250;
	}


	String nomeUniversita, tipologia;
}
