package scuolasci;

import java.util.GregorianCalendar;

public class CorsoSnowboard implements Corso{
	
	

	public CorsoSnowboard(String id, int numeroPartecipanti, int durataCorso, GregorianCalendar inizioCorso) {
		if (durataCorso < 0) throw new BadArgumentException();
		this.id = id;
		this.numeroPartecipanti = numeroPartecipanti;
		this.durataCorso = durataCorso;
		this.inizioCorso = inizioCorso;
	}
	
	@Override
	public String daiNomeCorso() {
		return id;
	}

	@Override
	public int daiNumeroMinimoPartecipanti() {
		return 6;
	}

	@Override
	public int daiNumeroMassimoPartecipanti() {
		return 10;
	}

	@Override
	public int daiNumeroPartecipanti() {
		return numeroPartecipanti;
	}
	@Override
	public boolean aggiungiPartecipante() {
		if (numeroPartecipanti < 10) {
			numeroPartecipanti++;
			return true;
		}
		return false;
	}

	@Override
	public boolean corsoAttivato() {
		if (numeroPartecipanti >= 6) return true;
		return false;
	}
	
	
	public int getDurataCorso() {
		return durataCorso;
	}

	public void setDurataCorso(int durataCorso) {
		this.durataCorso = durataCorso;
	}

	public GregorianCalendar getInizioCorso() {
		return inizioCorso;
	}

	public void setInizioCorso(GregorianCalendar inizioCorso) {
		this.inizioCorso = inizioCorso;
	}
	
	public String getTipo() {
		return "Corso Snowboad";
	}
	
	private String id;
	private int numeroPartecipanti, durataCorso;
	private GregorianCalendar inizioCorso;

}
