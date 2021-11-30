import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sms implements Serializable{	
	public Sms(String mittente, String iD, String testo, Date date) {
		this.mittente = mittente;
		ID = iD;
		this.testo = testo;
		this.data = date;
	}
	
	public Sms() {
		GregorianCalendar d = new GregorianCalendar();
		this.data = d.getTime();
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
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Sms [mittente=" + mittente + ", ID=" + ID + ", testo=" + testo + ", data=" + data + "]";
	}

	private String mittente,ID,testo;
	Date data;
	
}
