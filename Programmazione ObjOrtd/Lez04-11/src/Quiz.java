//La classe Quiz realizza l'interfaccia Measurable.
//Un quiz ha un punteggio e un voto in lettere (come B+).

//Usare la classe DataSet per elaborare una raccolta di oggetti di tipo Quiz
//Visulizzare il punteggio medio e il punteggio massimo. Per quest'ultimo visualizzare anche il voto in lettere.
public class Quiz implements MeasurableVecchia{
	public Quiz(int punteggio, String voto) {
		this.punteggio = punteggio;
		this.voto = voto;
	}
	
	public double getMeasure() {
		return punteggio;
	}
	
	public double getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(double punteggio) {
		this.punteggio = punteggio;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}
	
	
	private double punteggio;
	private String voto;
	
}
