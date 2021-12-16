import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable{
	
	public Libro() {
		this.titolo = "Sconosciuto";
		this.autore = "Sconosciuto";
		this.numPagine = 0;
		p_id = 0;
		this.listaCapitoli = null;
	}
	
	public Libro(String titolo, int numPagine, ArrayList<String> listaCapitoli) {
		this.titolo = titolo;
		this.autore = "Sconosciuto";
		this.numPagine = numPagine;
		this.listaCapitoli = listaCapitoli;
		p_id = id;
		id++;

	}
	
	public Libro(String titolo, String autore, int numPagine, ArrayList<String> listaCapitoli) {
		this.titolo = titolo;
		this.autore = autore;
		this.numPagine = numPagine;
		this.listaCapitoli = listaCapitoli;
		p_id = 0;
		id++;
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

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(int numPagine) {
		this.numPagine = numPagine;
	}

	public ArrayList<String> getListaCapitoli() {
		return listaCapitoli;
	}

	public void setListaCapitoli(ArrayList<String> listaCapitoli) {
		this.listaCapitoli = listaCapitoli;
	}
	

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}


	public boolean equals(Libro l2) {
		if (this.getAutore().equals(l2.getAutore()) && this.getTitolo().equals(l2.getTitolo()) && this.getNumPagine() == l2.getNumPagine() && listaCapitoli.equals(l2.getListaCapitoli()))
			return true;
		return false;
		
	}
	
	
	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", autore=" + autore + ", numPagine=" + numPagine + ", listaCapitoli="
				+ listaCapitoli + "]";
	}

	public String getInitials() {
		if (this.autore != null && this.autore.equalsIgnoreCase("Sconosciuto")) {
			if (this.autore.split(" ").length == 2) { //Caso solo nome e cognome
				String nome = this.autore.split(" ")[0];
				String cognome = this.autore.split(" ")[1];
				return nome.charAt(0)+" " + cognome.charAt(0);
			}else if (this.autore.split(" ").length == 3) { //Caso due nomi ed un cognome
				String nome = this.autore.split(" ")[0];
				String nome2 = this.autore.split(" ")[1];
				String cognome = this.autore.split(" ")[2];
				return nome.charAt(0)+" " + nome2.charAt(0) +" " +cognome.charAt(0);
			}
		}
		return null;
	}

	private String titolo, autore;
	private int numPagine;
	ArrayList<String> listaCapitoli;
	private int p_id;
	private static int id = 0;
}
