import java.io.Serializable;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.management.relation.RelationTypeNotFoundException;

public class TesserinoStudente extends Tesserino implements Serializable{
	public TesserinoStudente(String codice, String nome, String cognome, boolean attivo, String matricola,
			GregorianCalendar scadenza, String fascia, boolean bonus, double saldo) {
		super(codice, nome, cognome, attivo);
		this.matricola = matricola;
		this.scadenza = scadenza;
		this.fascia = fascia;
		this.bonus = bonus;
		this.saldo = saldo;
	}
	
	public double calcolaPrezzo() {
		double prezzofinale = 0;
		if (fascia.equalsIgnoreCase("A")) {
			prezzofinale = 2.50;
		}
		if (fascia.equalsIgnoreCase("B")) {
			prezzofinale = 1.50;
		}
		
		return this.bonus == true ? (prezzofinale-1) : prezzofinale; 
		
	}
	
	
	public boolean isBonus(){
		if(this.bonus)
			return true;
		return false;
	}
	
	public double paga() throws TesserinoScadutoException, SaldoInsufficienteException {
		GregorianCalendar now = new GregorianCalendar();
		double prezzo = calcolaPrezzo();
		if (now.getTimeInMillis() > (this.scadenza.getTimeInMillis()))
			throw new TesserinoScadutoException();
		if (saldo < prezzo)
			throw new SaldoInsufficienteException();
		
		this.saldo -= prezzo;
		return prezzo;
	}
	
	public void versa(double x) {
		if ( x < 0)
			throw new RuntimeException();
		this.saldo += x;
	}
	
	private String matricola;
	private GregorianCalendar scadenza;
	private String fascia;
	private double saldo;
	private boolean bonus;
	
}
