
public class Clienti {
	public Clienti(String cognome, String nome, int numTelefono, int numCarta) {
		this.cognome = cognome;
		this.nome = nome;
		this.numTelefono = numTelefono;
		this.numCarta = numCarta;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumTelefono() {
		return numTelefono;
	}
	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}
	public int getNumCarta() {
		return numCarta;
	}
	public void setNumCarta(int numCarta) {
		this.numCarta = numCarta;
	}

	private String cognome,nome;
	private int numTelefono,numCarta;
}
