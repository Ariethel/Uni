import java.util.GregorianCalendar;

abstract class Prodotto {
	public Prodotto(int codice, double prezzo, int quantita, Boolean inOfferta, String descrizione, String marca) {
		this.codice = codice;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.inOfferta = inOfferta;
		this.descrizione = descrizione;
		this.marca = marca;
	}
	
	public void mettiInOfferta(double p,GregorianCalendar g) {
		this.durataOfferta = g;
		this.inOfferta = true;
		this.prezzoOfferta = this.getPrezzo() - p;
		double tmp = this.getPrezzo();
		this.prezzo = prezzoOfferta;
		this.prezzoOfferta = tmp;
	}
	
	
	public void controllaOfferta() {
		GregorianCalendar dataAttuale = new GregorianCalendar();
		if (this.durataOfferta.before(dataAttuale)) {
			inOfferta = false;
			double tmp = getPrezzo();
			this.prezzo = prezzoOfferta;
			this.prezzoOfferta = tmp;
		}
			
	}
	
	abstract Boolean acquista(int p);
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public Boolean getInOfferta() {
		return inOfferta;
	}
	public void setInOfferta(Boolean inOfferta) {
		this.inOfferta = inOfferta;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	private GregorianCalendar durataOfferta = new GregorianCalendar();
	private int codice, quantita;
	private double prezzo,prezzoOfferta;
	private Boolean inOfferta;
	private String descrizione,marca;
}
