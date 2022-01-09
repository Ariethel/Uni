import java.util.GregorianCalendar;

public abstract class Registrazione implements Comparable<Registrazione>{
	
	public Registrazione(String nome, String cognome, GregorianCalendar dataRegistrazione) throws BadDateException {
		if (dataRegistrazione.after(new GregorianCalendar(2020,4,30))) throw new BadDateException();
		this.nome = nome;
		this.cognome = cognome;
		this.dataRegistrazione = dataRegistrazione;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public GregorianCalendar getDataRegistrazione() {
		return dataRegistrazione;
	}
	public void setDataRegistrazione(GregorianCalendar dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}
	
	@Override
	public int compareTo(Registrazione r) {
		return this.cognome.compareTo(r.getCognome());
	}
	
	abstract int calcolaCosto();
	


	private String nome, cognome;
	GregorianCalendar dataRegistrazione;
	
}
