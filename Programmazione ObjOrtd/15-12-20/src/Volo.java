import java.io.Serializable;
import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Objects;

public class Volo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7691888259734725513L;
	public Volo(String partenza, String destinazione, String compagnia, String tipoBiglietto, int codiceVolo,
			boolean stato, ArrayList<Posto> posti) {
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.compagnia = compagnia;
		this.tipoBiglietto = tipoBiglietto;
		this.codiceVolo = codiceVolo;
		this.stato = stato;
		this.posti = posti;
	}
	
	public String getPartenza() {
		return partenza;
	}
	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}
	public String getDestinazione() {
		return destinazione;
	}
	public void setDestinazione(String destinazione) {
		this.destinazione = destinazione;
	}
	public String getCompagnia() {
		return compagnia;
	}
	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
	}
	public String getTipoBiglietto() {
		return tipoBiglietto;
	}
	public void setTipoBiglietto(String tipoBiglietto) {
		this.tipoBiglietto = tipoBiglietto;
	}
	public int getCodiceVolo() {
		return codiceVolo;
	}
	public void setCodiceVolo(int codiceVolo) {
		this.codiceVolo = codiceVolo;
	}
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	public ArrayList<Posto> getPosti() {
		return posti;
	}
	public void setPosti(ArrayList<Posto> posti) {
		this.posti = posti;
	}
	public boolean f(Posto posto) {
		return posto.isStato();
	}
	public ArrayList<Posto> filtraPosti(Filter f){
		ArrayList<Posto> trovati = new ArrayList<Posto>();
		for (Posto posto : posti) {
			if (f(posto))
				trovati.add(posto);
		}
		
		return trovati;
	}
	
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Volo other = (Volo) obj;
		return codiceVolo == other.codiceVolo && Objects.equals(compagnia, other.compagnia)
				&& Objects.equals(destinazione, other.destinazione) && Objects.equals(partenza, other.partenza)
				&& Objects.equals(posti, other.posti) && stato == other.stato
				&& Objects.equals(tipoBiglietto, other.tipoBiglietto);
	}

	@Override
	public String toString() {
		return "Volo [partenza=" + partenza + ", destinazione=" + destinazione + ", compagnia=" + compagnia
				+ ", tipoBiglietto=" + tipoBiglietto + ", codiceVolo=" + codiceVolo + ", stato=" + stato + ", posti="
				+ posti + "]";
	}




	private String partenza, destinazione, compagnia, tipoBiglietto;
	private int codiceVolo;
	private boolean stato;
	private ArrayList<Posto> posti = new ArrayList<Posto>();
}
