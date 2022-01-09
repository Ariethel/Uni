import java.util.ArrayList;

public class TecnicoCaldaia extends Idraulico{
	
	
	
	public TecnicoCaldaia(int matricola, int numInterventi, String cognome, String nome,
			ArrayList<Interventi> interventi, ArrayList<Case> certificati, int numRiparazioni, double votoMedio) {
		super(matricola, numInterventi, cognome, nome, interventi);
		this.certificati = certificati;
		this.numInterventi = numRiparazioni;
		this.votoMedio = votoMedio;
	}
	
	public void effettuaIntervento(Case c, double giudizio) {
		boolean flag = false;
		for (Case ca : certificati) {
			if (ca.getTipo().equals(c.getTipo()))
				flag = true;
		}
		if (!flag) throw new RuntimeException();
		numInterventi++;
		votoMedio+=giudizio /numInterventi;
		
	}
	public ArrayList<Case> getCertificati() {
		return certificati;
	}
	public void setCertificati(ArrayList<Case> certificati) {
		this.certificati = certificati;
	}
	public int getNumRiparazioni() {
		return numInterventi;
	}
	public void setNumRiparazioni(int numRiparazioni) {
		this.numInterventi = numRiparazioni;
	}
	public double getVotoMedio() {
		return votoMedio;
	}
	public void setVotoMedio(double votoMedio) {
		this.votoMedio = votoMedio;
	}


	private ArrayList<Case> certificati;
	private int numInterventi;
	private double votoMedio;

}
