import java.io.Serializable;

public class Automezzo implements Serializable{
	public Automezzo(String modello, String marca, String targa, int anno) {
		this.modello = modello;
		this.marca = marca;
		this.targa = targa;
		this.anno = anno;
	}
	
	
	
	public String getModello() {
		return modello;
	}



	public void setModello(String modello) {
		this.modello = modello;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getTarga() {
		return targa;
	}



	public void setTarga(String targa) {
		this.targa = targa;
	}



	public int getAnno() {
		return anno;
	}



	public void setAnno(int anno) {
		this.anno = anno;
	}



	


	@Override
	public String toString() {
		return "Modello: " + getModello() + " Marca: " + getMarca() + " Targa: " + getTarga()+ " Anno: " + getAnno();
	}






	private String modello, marca, targa;
	private int anno;
}
