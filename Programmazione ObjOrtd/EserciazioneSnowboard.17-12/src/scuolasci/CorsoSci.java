package scuolasci;

import java.util.GregorianCalendar;

public class CorsoSci implements Corso{
	
	

	public CorsoSci(int id_p, int numeroPartecipanti, int durataCorsoGiorni, GregorianCalendar dataInizio) {
		if (durataCorsoGiorni < 0)
			throw new BadArgumentException("La durata non puo' essere negativa");
		this.id_p = id_p;
		this.numeroPartecipanti = numeroPartecipanti;
		this.durataCorsoGiorni = durataCorsoGiorni;
		this.dataInizio = dataInizio;
	}

	@Override
	public String daiNomeCorso() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int daiNumeroMinimoPartecipanti() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int daiNumeroMassimoPartecipanti() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int daiNumeroPartecipanti() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean aggiungiPartecipante() {
		if(numeroPartecipanti < 8) {
			this.numeroPartecipanti++;
			return true;
		}
			
		return false;
	}

	@Override
	public boolean corsoAttivato() {
		if(this.numeroPartecipanti >= 4)
			return true;
		return false;
	}
	
	
	
	public int getId_p() {
		return id_p;
	}

	public void setId_p(int id_p) {
		this.id_p = id_p;
	}

	public int getNumeroPartecipanti() {
		return numeroPartecipanti;
	}

	public void setNumeroPartecipanti(int numeroPartecipanti) {
		this.numeroPartecipanti = numeroPartecipanti;
	}

	public int getDurataCorsoGiorni() {
		return durataCorsoGiorni;
	}

	public void setDurataCorsoGiorni(int durataCorsoGiorni) {
		this.durataCorsoGiorni = durataCorsoGiorni;
	}

	public GregorianCalendar getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(GregorianCalendar dataInizio) {
		this.dataInizio = dataInizio;
	}
	
	
	@Override
	public String toString() {
		return "CorsoSci [id_p=" + id_p + ", numeroPartecipanti=" + numeroPartecipanti + ", durataCorsoGiorni="
				+ durataCorsoGiorni + "]";
	}





	private int id_p,numeroPartecipanti,durataCorsoGiorni;
	private GregorianCalendar dataInizio;
	
}
