package Rotaia.java;

public class Stazioni {
	public Stazioni(String nomeStazione,double oraArrivo,double oraPartenza,int kmDaPrec) {
		this.nomeStazione = nomeStazione;
		this.oraArrivo = oraArrivo;
		this.oraPartenza = oraPartenza;
		this.kmDaPrec = kmDaPrec;
	}
	
	int kmDaPrec;
	String nomeStazione;
	public int getKmDaPrec() {
		return kmDaPrec;
	}
	public void setKmDaPrec(int kmDaPrec) {
		this.kmDaPrec = kmDaPrec;
	}
	public String getNomeStazione() {
		return nomeStazione;
	}
	public void setNomeStazione(String nomeStazione) {
		this.nomeStazione = nomeStazione;
	}
	public double getOraArrivo() {
		return oraArrivo;
	}
	public void setOraArrivo(double oraArrivo) {
		this.oraArrivo = oraArrivo;
	}
	public double getOraPartenza() {
		return oraPartenza;
	}
	public void setOraPartenza(double oraPartenza) {
		this.oraPartenza = oraPartenza;
	}

	double oraArrivo,oraPartenza;
}
