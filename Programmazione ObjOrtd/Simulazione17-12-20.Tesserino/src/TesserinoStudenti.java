import java.io.Serializable;
import java.util.GregorianCalendar;

public class TesserinoStudenti extends Tesserino implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1246462044310493508L;
	public TesserinoStudenti(int codice, String nome, String cognome, String matricola, String fascia, int scadenza,
			double saldo, boolean bonus) {
		super(codice, nome, cognome);
		this.matricola = matricola;
		this.fascia = fascia;
		this.scadenza = scadenza;
		this.saldo = saldo;
		this.bonus = bonus;
	}
	
	public double calcolaPrezzo() {
		if (fascia.equals("A")) return 2.50;
		if (fascia.equals("B")) return 1.50;
		if (bonus == true) return 1;
		return 3.00;
	}
	
	public boolean isBonus() {
		return bonus;
	}
	
	public double paga() throws TesserinoScadutoException {
		GregorianCalendar gc = new GregorianCalendar();
		if (this.scadenza < gc.YEAR)
			throw new TesserinoScadutoException();
		if (this.saldo - this.calcolaPrezzo() < 0)
			throw new SaldoInsufficienteException();
		
		this.saldo -= this.calcolaPrezzo();
		return this.calcolaPrezzo();
	}
	
	public void versa(double x) {
		if (x < 0) throw new RuntimeException();
		this.saldo += x;
	}
	
	
	
	
	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getFascia() {
		return fascia;
	}

	public void setFascia(String fascia) {
		this.fascia = fascia;
	}

	public int getScadenza() {
		return scadenza;
	}

	public void setScadenza(int scadenza) {
		this.scadenza = scadenza;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}




	private String matricola,fascia;
	private int scadenza;
	private double saldo;
	private boolean bonus;
}
