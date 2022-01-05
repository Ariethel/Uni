package scuolasci;

import java.util.GregorianCalendar;

public interface Corso {
	String daiNomeCorso();
	int daiNumeroMinimoPartecipanti();
	int daiNumeroMassimoPartecipanti();
	int daiNumeroPartecipanti();
	boolean aggiungiPartecipante();
	boolean corsoAttivato();
	public int getDurataCorso();
	public GregorianCalendar getInizioCorso();
	public String getTipo();
}
