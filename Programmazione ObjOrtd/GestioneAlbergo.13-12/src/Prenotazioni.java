import java.util.GregorianCalendar;

public class Prenotazioni {
	
	public Prenotazioni(GregorianCalendar checkIn, GregorianCalendar checkOut, Clienti cliente, Stanze stanza) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.cliente = cliente;
		this.stanza = stanza;
	}
	
	
	public GregorianCalendar getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(GregorianCalendar checkIn) {
		this.checkIn = checkIn;
	}
	public GregorianCalendar getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(GregorianCalendar checkOut) {
		this.checkOut = checkOut;
	}
	public Clienti getCliente() {
		return cliente;
	}
	public void setCliente(Clienti cliente) {
		this.cliente = cliente;
	}
	public Stanze getStanza() {
		return stanza;
	}
	public void setStanza(Stanze stanza) {
		this.stanza = stanza;
	}


	private GregorianCalendar checkIn,checkOut;
	Clienti cliente;
	Stanze stanza;
}
