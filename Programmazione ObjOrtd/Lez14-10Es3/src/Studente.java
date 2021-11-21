public class Studente{
	public Studente() {
		counterEsami = 0;
		totaleVoti = 0;
		media = 0;
	}
	
	public void aggiungiVoto(int voto) {
		this.totaleVoti += voto;
		this.counterEsami++;
	}
	
	public double calcolaMedia() {
		return ((double) totaleVoti)/counterEsami;
	}
	
	private int counterEsami, totaleVoti;
	private double media;
}