
public class Prenotazione {

	public Prenotazione(String nome, String cognome, Volo volo, Posto posto) {
		this.nome = nome;
		this.cognome = cognome;
		this.volo.setCodVolo(volo.getCodVolo());
		this.volo.setTipoBiglietto(volo.getTipoBiglietto());
		this.posto = posto;	
	}
	
	
	private String nome,cognome;
	private Volo volo;
	private Posto posto;
}
