import java.util.GregorianCalendar;

public class RegaliBambini extends Regali{
	
	
	public RegaliBambini(String regioneDestinatario, double pesoPacco, GregorianCalendar dataConsegna,int eta, String nome, String messaggio) {
		super(regioneDestinatario, pesoPacco, dataConsegna);
		this.eta = eta;
		this.nome = nome;
		this.messaggio = messaggio;
	}
	
	public String toString() {
		return ("HoHoHO" + messaggio);
	}
	
	public int calcolaCosto() {
		return super.calcolaCosto();
	}	
	
	int eta;
	private String nome,messaggio;
}
