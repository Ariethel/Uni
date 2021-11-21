public class Insegnante extends Persona{
	public Insegnante(String nome, String cognome, int anno, double stipendio) {
		super(nome, cognome, anno);
		this.stipendio = stipendio;
	}
	
	public String toString() {
		String str =  (this.getNome()+ " " + this.getCognome() + "," + this.getAnno() + "," + this.stipendio);
		return str;
	}
	
	private double stipendio;
}
