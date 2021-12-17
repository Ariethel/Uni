package scuolasci;

public interface Corso {
	String daiNomeCorso();
	int daiNumeroMinimoPartecipanti();
	int daiNumeroMassimoPartecipanti();
	int daiNumeroPartecipanti();
	boolean aggiungiPartecipante();
	boolean corsoAttivato();
	
	
}
