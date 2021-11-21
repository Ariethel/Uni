public class Libro {
	public Libro(String titolo, String autore, String editore, int numeroCopie) {
		this.titolo = titolo;
		this.autore = autore;
		this.editore = editore;
		this.numeroCopie = numeroCopie;
	}
	
	
	public int getNumeroCopie() {
		return numeroCopie;
	}
	
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getEditore() {
		return editore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public void setNumeroCopie(int numeroCopie) {
		this.numeroCopie = numeroCopie;
	}
	
	
	private String titolo,autore,editore;
	private int numeroCopie;
	
}
