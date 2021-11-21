
public class Studente extends Persona{
	public Studente(String nome, String cognome, int anno, String specializzazione) {
		super(nome, cognome, anno);
		this.specializzazione = specializzazione;
	}
	
	public String toString() {
		String str =  (this.getNome() + " " + this.getCognome() + "," + this.getAnno() + "," + this.specializzazione);
		return str;
	}
	
	private String specializzazione;
}
