import java.io.Serializable;

public abstract class Tesserino implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6948529280664866009L;
	public Tesserino(int codice, String nome, String cognome) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
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
	
	public void attiva() {
		attivo = true;
	}
	
	public void disattiva() {
		attivo = false;
	}
	
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	
	public abstract double paga() throws TesserinoScadutoException;
	
	private int codice;
	private String nome,cognome;
	private boolean attivo;
	public boolean isAttivo() {
		return attivo;
	}

	

}
