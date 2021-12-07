import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SlittaBabboNatale {
	public void aggiungiRegalo(Regali rel) throws PesoMaxSuperatoExcepetion {
		if ((this.peso += rel.getPesoPacco()) > pesoMassimo)
			throw new PesoMaxSuperatoExcepetion();
		else {
			regali.add(rel);
		}
	}
	
	public int calcolaCosto() {
		int sum = 0;
		for (Regali rel : regali) {
			sum += rel.calcolaCosto();
		}
		
		return sum;
	}
	
	
	//Fixare questo metodo che e' tutto rotto
	public String spedisci(Regali rel) {
		GregorianCalendar consegna = new GregorianCalendar();
		if (rel.getRegioneDestinatario().equalsIgnoreCase("Nord"))
			return (rel.toString() + "Consegna: " + consegna.WEEK_OF_MONTH);
		if (rel.getRegioneDestinatario().equalsIgnoreCase("Centro"))
			return (rel.toString() + "Consegna: " + consegna.WEEK_OF_MONTH+1);
		if (rel.getRegioneDestinatario().equalsIgnoreCase("Sud"))
			return (rel.toString() + "Consegna: " + consegna.WEEK_OF_MONTH+2);
		return null;
	}
	
	private double peso;
	private ArrayList<Regali> regali;
	private double pesoMassimo;
}
