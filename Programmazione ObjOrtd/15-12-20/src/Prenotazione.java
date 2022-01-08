import java.io.Serializable;

public class Prenotazione implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7250884370424112370L;
	public Prenotazione(String nome, String cognome, Volo volo) {
		this.nome = nome;
		this.cognome = cognome;
		this.volo = volo;
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public Volo getVolo() {
		return volo;
	}


	public void setVolo(Volo volo) {
		this.volo = volo;
	}


	@Override
	public String toString() {
		return "Prenotazione [nome=" + nome + ", cognome=" + cognome + ", volo=" + volo + "]";
	}


	private String nome, cognome;
	private Volo volo;
}
