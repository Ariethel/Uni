import java.io.Serializable;

public class TesserinoPersonale extends Tesserino implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9118349480015036479L;
	public TesserinoPersonale(int codice, String nome, String cognome, String categoria, String facolta,
			double sommaSpesa) {
		super(codice, nome, cognome);
		this.categoria = categoria;
		this.facolta = facolta;
		this.sommaSpesa = sommaSpesa;
	}

	public double paga() {
		if (this.categoria.equals("docente")) { sommaSpesa += 1.60; return 1.60;}
		if (this.categoria.equals("amministrativa")) {sommaSpesa += 4.00; return 4.00;}
		return 0;
	}
	
	public void cambiaCategoria() {
		if (this.categoria.equals("docente")) {
			this.categoria = "amministrativa";
		}
		if (this.categoria.equals("amministrativa")) {
			this.categoria = "docente";
		}
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getFacolta() {
		return facolta;
	}
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
	public double getSommaSpesa() {
		return sommaSpesa;
	}
	public void setSommaSpesa(double sommaSpesa) {
		this.sommaSpesa = sommaSpesa;
	}


	private String categoria, facolta;
	private double sommaSpesa;
	
}
