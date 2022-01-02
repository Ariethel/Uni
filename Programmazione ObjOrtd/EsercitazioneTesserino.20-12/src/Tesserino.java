import java.io.Serializable;

public abstract class Tesserino implements Serializable{
	public Tesserino(String codice, String nome, String cognome, boolean attivo) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.attivo = attivo;
	}

	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
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
	public boolean isAttivo() {
		return attivo;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public void attiva() {
		if (this.attivo)
			throw new RuntimeException();
		else {
			this.attivo = true;
		}
	}

	public void disattiva() {
		if (!this.attivo)
			throw new RuntimeException();
		else {
			this.attivo = false;
		}
	}

	public abstract double paga() throws TesserinoScadutoException, SaldoInsufficienteException;

	private String codice, nome,cognome;
	private boolean attivo;

}
