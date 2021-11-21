//Ogni contatto ha un nome, cognome e un numero telefonico, tutti di tipo String. 
//Un costruttore che riceve come parametro il nome, il cognome ed il numero di telefono.

//Scrivere una classe Rubrica che contiene una collezione di contatti gestiti da file.
//Implementare i metodi per leggere la lista di contatti da file e per salvare la lista di contatti nel file
public class Contatto {
	public Contatto(String nome, String cognome, String numeroTelefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.numeroTelefono = numeroTelefono;
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



	public String getNumeroTelefono() {
		return numeroTelefono;
	}



	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	
	public String contToString() {
		return this.getNome()+","+this.getCognome()+","+this.getNumeroTelefono();
	}

	public String contToExport() {
		return ("{\"nome\": " + this.getNome() + "\"cognome\": " + this.getCognome() + ",\"Telefono\": " + "," + this.getNumeroTelefono() + "}");
	}
	private String nome,cognome,numeroTelefono;
}
