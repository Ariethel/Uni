public class Auto {
	public Auto(String marca, String modello, String targa) {
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		venduta = false;
	}
	
	public Auto(String marca, String modello, String targa,Boolean stato_vendita) {
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		venduta = stato_vendita;
	}

	public Boolean getStato() {
		return this.venduta;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public String getModello() {
		return this.modello;
	}
	
	public String getTarga() {
		return this.targa;
	}
	
	public void setStato(Boolean venduta) {
		this.venduta = venduta;
	}
	
	private String marca,modello,targa;
	private Boolean venduta;
}
