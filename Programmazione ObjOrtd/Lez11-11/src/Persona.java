
public class Persona {
	public Persona(String nome, String cognome, int anno) {
		this.nome = nome;
		this.cognome = cognome;
		this.anno = anno;
	}
	
	public String toString() {
		String str =  (this.nome + " " + this.cognome + "," + this.anno);
		return str;
	}
	
	private String nome,cognome;
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

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	int anno;
}
