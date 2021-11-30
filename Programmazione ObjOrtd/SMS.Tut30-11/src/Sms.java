import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Sms{	
	public Sms(String mittente, String iD, String testo, GregorianCalendar data) {
		this.mittente = mittente;
		ID = iD;
		this.testo = testo;
		this.data = data;
	}
	
	public Sms() {
		GregorianCalendar d = new GregorianCalendar();
		d.getTime();
		this.data = d;
	}
	
	public String getMittente() {
		return mittente;
	}
	public void setMittente(String mittente) {
		this.mittente = mittente;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	
	
	@Override
	public String toString() {
		return "Sms [mittente=" + mittente + ", ID=" + ID + ", testo=" + testo + ", data=" + data + "]";
	}

	private String mittente,ID,testo;
	GregorianCalendar data;
	
}
