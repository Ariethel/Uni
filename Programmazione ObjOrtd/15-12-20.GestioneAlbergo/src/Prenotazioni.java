import java.util.GregorianCalendar;

public class Prenotazioni {
	public Prenotazioni(GregorianCalendar checkin, GregorianCalendar checkout, Clienti cliente, Stanze stanza) {
		this.checkin = checkin;
		this.checkout = checkout;
		this.cliente = cliente;
		this.stanza = stanza;
	}
	
	public GregorianCalendar getCheckin() {
		return checkin;
	}
	public void setCheckin(GregorianCalendar checkin) {
		this.checkin = checkin;
	}
	public GregorianCalendar getCheckout() {
		return checkout;
	}
	public void setCheckout(GregorianCalendar checkout) {
		this.checkout = checkout;
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


	GregorianCalendar checkin, checkout;
	Clienti cliente;
	Stanze stanza;
}
