import java.util.GregorianCalendar;

public class RegaliAdulti extends Regali{
	
	
	public RegaliAdulti(String regioneDestinatario, double pesoPacco, GregorianCalendar dataConsegna, String mittente) {
		super(regioneDestinatario, pesoPacco, dataConsegna);
		this.mittente = mittente;
	}
	
	public int calcolaCosto() {
		return super.calcolaCosto();
	}
	
	@Override
	public String toString() {
		return mittente;
	}

	private String mittente;
}
