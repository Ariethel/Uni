
public class Contatore{
	public Contatore() {
		conteggio = 0;
	}
	
	public Contatore(int conteggio) {
		this.conteggio = conteggio; //Assegna il parametro del metodo "conteggio" alla variabile d'istanza "conteggio"
	}
	
	public void aggiungi() {
		conteggio += 1;
	}
	
	public void reset() {
		conteggio = 0;
	}
	
	public int mostraconteggio() {
		return conteggio;
	}
	
	private int conteggio; //Variabile di Istanza
}
