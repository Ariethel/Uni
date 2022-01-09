import java.util.GregorianCalendar;

public class RegistrazioneProfessionisti extends Registrazione{
	
	public RegistrazioneProfessionisti(String nome, String cognome, GregorianCalendar dataRegistrazione,
			String nomeAzienda, int partIva) throws BadDateException {
		super(nome, cognome, dataRegistrazione);
		this.nomeAzienda = nomeAzienda;
		this.partIva = partIva;
	}
	
	public boolean isInRitardo() {
		return this.dataRegistrazione.after(new GregorianCalendar(2020, 2, 3));
	}
	
	public int calcolaCosto() {
		if (this.isInRitardo())
			return 550;
		
		return 500;
	}
	
	
	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public int getPartIva() {
		return partIva;
	}

	public void setPartIva(int partIva) {
		this.partIva = partIva;
	}



	private String nomeAzienda;
	private int partIva;
}
