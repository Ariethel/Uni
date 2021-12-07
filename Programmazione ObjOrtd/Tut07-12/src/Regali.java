import java.util.GregorianCalendar;

public class Regali {
	
	public Regali(String regioneDestinatario, double pesoPacco, GregorianCalendar dataConsegna) {
		this.regioneDestinatario = regioneDestinatario;
		this.pesoPacco = pesoPacco;
		this.dataConsegna = dataConsegna;
	}
	
	@Override
	public String toString() {
		return "Regali [regioneDestinatario=" + regioneDestinatario + ", pesoPacco=" + pesoPacco + ", dataConsegna="
				+ dataConsegna + "]";
	}
	public String getRegioneDestinatario() {
		return regioneDestinatario;
	}
	public void setRegioneDestinatario(String regioneDestinatario) {
		this.regioneDestinatario = regioneDestinatario;
	}
	public double getPesoPacco() {
		return pesoPacco;
	}
	public void setPesoPacco(double pesoPacco) {
		this.pesoPacco = pesoPacco;
	}
	public GregorianCalendar getDataConsegna() {
		return dataConsegna;
	}
	public void setDataConsegna(GregorianCalendar dataConsegna) {
		this.dataConsegna = dataConsegna;
	}
	
	public int calcolaCosto() {
		if (this.regioneDestinatario.equalsIgnoreCase("Nord"))
			return 10;
		if (this.regioneDestinatario.equalsIgnoreCase("Centro"))
			return 15;
		if (this.regioneDestinatario.equalsIgnoreCase("Sud"))
			return 20;
		
		return 0;
	}
	
	private String regioneDestinatario;
	private double pesoPacco;
	private GregorianCalendar dataConsegna;
}
