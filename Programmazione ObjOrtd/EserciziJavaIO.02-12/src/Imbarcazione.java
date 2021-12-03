import java.util.Date;

public class Imbarcazione {
	public Imbarcazione(String targa, String marca, double lunghezza, int annoCostruzione, Date DateOrmeggio,
			Date DatePartenza, Boolean cabinato) {
		this.targa = targa;
		this.marca = marca;
		this.lunghezza = lunghezza;
		this.annoCostruzione = annoCostruzione;
		this.dataOrmeggio = DateOrmeggio;
		this.dataPartenza = DatePartenza;
		this.cabinato = cabinato;
	}
	
	
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(double lunghezza) {
		this.lunghezza = lunghezza;
	}
	public int getAnnoCostruzione() {
		return annoCostruzione;
	}
	public void setAnnoCostruzione(int annoCostruzione) {
		this.annoCostruzione = annoCostruzione;
	}
	public Date getDateOrmeggio() {
		return dataOrmeggio;
	}
	public void setDateOrmeggio(Date DateOrmeggio) {
		this.dataOrmeggio = DateOrmeggio;
	}
	public Date getDatePartenza() {
		return dataPartenza;
	}
	public void setDatePartenza(Date DatePartenza) {
		this.dataPartenza = DatePartenza;
	}
	public Boolean getCabinato() {
		return cabinato;
	}
	public void setCabinato(Boolean cabinato) {
		this.cabinato = cabinato;
	}
	
	


	@Override
	public String toString() {
		return "Imbarcazione [targa=" + targa + ", marca=" + marca + ", lunghezza=" + lunghezza + ", annoCostruzione="
				+ annoCostruzione + ", DateOrmeggio=" + dataOrmeggio + ", DatePartenza=" + dataPartenza + ", cabinato="
				+ cabinato + "]";
	}

	
	public void checkIn() {
		if (dataOrmeggio == null)
			throw new RuntimeException();
		Date actual = new Date();
		dataOrmeggio = actual;
	}
	
	public void checkOut() {
		if (dataPartenza == null)
			throw new RuntimeException();
		Date actual = new Date();
		dataPartenza= actual;
	}
	
	public double dammiCostoOrmeggio() {
		return 0;
	}


	String targa, marca;
	double lunghezza;
	int annoCostruzione;
	Date dataOrmeggio, dataPartenza;
	Boolean cabinato;
}
