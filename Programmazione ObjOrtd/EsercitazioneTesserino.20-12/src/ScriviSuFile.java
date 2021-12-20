import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;

public class ScriviSuFile {

	public static void main(String[] args) throws IOException {
		PagamentoPasti pp = new PagamentoPasti();
		TesserinoPersonale tp1 = new TesserinoPersonale("ABC", "Antonio", "Renzullo", true, "informatica", "Docente", 16);
		TesserinoPersonale tp2 = new TesserinoPersonale("DEF", "Simon", "Carbone", true, "Non Pervenuta", "Amministrativo", 1);
		
		GregorianCalendar scadenza = new GregorianCalendar(2021,12,31); 
		TesserinoStudente ts1 = new TesserinoStudente("123", "lorenzomioso", "no", true, "M123", scadenza, "A", false, 100);
		GregorianCalendar scadenza2 = new GregorianCalendar(2021,7,10);
		TesserinoStudente ts2 = new TesserinoStudente("456", "Giovanni", "Fontana", true, "M123", scadenza2, "B", true, 500);
		
		pp.aggiungiTesserino(tp1);
		pp.aggiungiTesserino(tp2);
		pp.aggiungiTesserino(ts1);
		pp.aggiungiTesserino(ts2);
		
		FileOutputStream fos = new FileOutputStream("giggino.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(pp);
		oos.close();
		



	}

}
