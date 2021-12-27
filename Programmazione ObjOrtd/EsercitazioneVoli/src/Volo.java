import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Objects;

public class Volo {
	public Volo(String tipoBiglietto, String compagnia, String partenza, String destinazione, int codVolo,
			boolean stato, ArrayList<Posto> posti) {
		this.tipoBiglietto = tipoBiglietto;
		this.compagnia = compagnia;
		this.partenza = partenza;
		this.destinazione = destinazione;
		this.codVolo = codVolo;
		this.stato = stato;
		this.posti = posti;
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
		return codVolo == other.codVolo && Objects.equals(compagnia, other.compagnia)
				&& Objects.equals(destinazione, other.destinazione) && Objects.equals(partenza, other.partenza)
				&& Objects.equals(posti, other.posti) && stato == other.stato
				&& Objects.equals(tipoBiglietto, other.tipoBiglietto);
	}
	
	


	@Override
	public String toString() {
		return "Volo [tipoBiglietto=" + tipoBiglietto + ", compagnia=" + compagnia + ", partenza=" + partenza
				+ ", destinazione=" + destinazione + ", codVolo=" + codVolo + ", stato=" + stato + ", posti=" + posti
				+ "]";
	}
	
	


	public String getTipoBiglietto() {
		return tipoBiglietto;
	}

	public void setTipoBiglietto(String tipoBiglietto) {
		this.tipoBiglietto = tipoBiglietto;
	}

	public String getCompagnia() {
		return compagnia;
	}

	public void setCompagnia(String compagnia) {
		this.compagnia = compagnia;
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

	public int getCodVolo() {
		return codVolo;
	}

	public void setCodVolo(int codVolo) {
		this.codVolo = codVolo;
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




	private String tipoBiglietto, compagnia, partenza, destinazione;
	private int codVolo;
	private boolean stato;
	private ArrayList<Posto> posti = new ArrayList<Posto>();
}
