import java.io.Serializable;

public class TesserinoPersonale extends Tesserino implements Serializable{
	public TesserinoPersonale(String codice, String nome, String cognome, boolean attivo, String facolta,
			String categoria, double sommaSpesa) {
		super(codice, nome, cognome, attivo);
		if (!categoria.equalsIgnoreCase("Amministrativo") && !categoria.equalsIgnoreCase("Docente")) {
			throw new RuntimeException("Categoria non valida");
		}
		this.facolta = facolta;
		this.categoria = categoria;
		this.sommaSpesa = sommaSpesa;
	}
	
	
	public double paga() {
		if (this.categoria.equalsIgnoreCase("Docente"))
			sommaSpesa += 1.60;
		if (this.categoria.equalsIgnoreCase("Amministrativo"))
			sommaSpesa += 4.00;
		
		return this.categoria.equalsIgnoreCase("Docente") ? 1.60 : 4;
	}
	
	public void cambiaCategoria() {
		if (this.categoria.equalsIgnoreCase("Docente"))
			this.categoria = "Amministrativo";
		else
			this.categoria = "Docente";
	}
	
	
	public double getSommaSpesa() {
		return sommaSpesa;
	}


	public void setSommaSpesa(double sommaSpesa) {
		this.sommaSpesa = sommaSpesa;
	}


	private String facolta, categoria;
	private double sommaSpesa;
}
