
public class Clienti {
	
	public Clienti(String cognome, String nome, int telefono, int numCarta) {
		this.cognome = cognome;
		this.nome = nome;
		this.telefono = telefono;
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getNumCarta() {
		return numCarta;
	}
	public void setNumCarta(int numCarta) {
		this.numCarta = numCarta;
	}


	private String cognome, nome;
	private int telefono, numCarta;
}
