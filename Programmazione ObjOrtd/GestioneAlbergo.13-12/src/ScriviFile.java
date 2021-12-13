import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ScriviFile {
	public static void main(String[] args) {
		Clienti c1 = new Clienti("Vecchione", "Luigi",123, 999);
		Clienti c2 = new Clienti("Carbone", "Simon",456, 000);
		ArrayList<String> servizi1 = new ArrayList<String>();
		servizi1.add("Bagno");
		servizi1.add("Supercar");
		Stanze s1 = new Stanze(1, 2, 444, "Matrimoniale", servizi1);
		ArrayList<String> servizi2 = new ArrayList<String>();
		servizi2.add("Asciugalacrime");
		servizi2.add("Marika");
		Stanze s2 = new Stanze(9, 9, 000, "Singola", servizi2);
		GregorianCalendar d1in = new GregorianCalendar();
		GregorianCalendar d1out = new GregorianCalendar();
		Prenotazioni p1 = new Prenotazioni(d1in,d1out,c1, s1);
		
		GregorianCalendar d2in = new GregorianCalendar();
		GregorianCalendar d2out = new GregorianCalendar();
		Prenotazioni p2 = new Prenotazioni(d2in,d2out,c2, s2);

	}
}
