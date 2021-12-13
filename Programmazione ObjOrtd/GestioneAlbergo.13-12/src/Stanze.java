import java.util.ArrayList;

public class Stanze {
	
	public Stanze(int numero, int piano, int telefono, String tipologia, ArrayList<String> servizi) {
		this.numero = numero;
		this.piano = piano;
		this.telefono = telefono;
		this.tipologia = tipologia;
		this.servizi = servizi;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getPiano() {
		return piano;
	}
	public void setPiano(int piano) {
		this.piano = piano;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public ArrayList<String> getServizi() {
		return servizi;
	}
	public void setServizi(ArrayList<String> servizi) {
		this.servizi = servizi;
	}

	private int numero,piano,telefono;
	private String tipologia;
	private ArrayList<String> servizi;
}
