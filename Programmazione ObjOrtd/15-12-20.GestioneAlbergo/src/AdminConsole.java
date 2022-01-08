import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AdminConsole {

	public static void main(String[] args) throws IOException {
		Clienti c1 = new Clienti("Renzullo", "Antonio", 111, 1);
		Clienti c2 = new Clienti("Carbone", "Simon", 222, 2);
		Clienti c3 = new Clienti("Catanese", "Antongiulio", 333, 3);
		
		Stanze s1 = new Stanze(1, 1, 1, "Singola", null);
		Stanze s2 = new Stanze(2, 2, 2, "Doppia", null);
		Stanze s3 = new Stanze(3, 3, 3, "Matrimoniale", null);
		
		FileOutputStream fos = new FileOutputStream("giggino.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(oos);
	}

}
