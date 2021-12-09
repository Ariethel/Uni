import java.io.*;
import java.util.ArrayList;

public class ScritturaObjectInFile {
	public static void main(String args[]) throws IOException {
		ArrayList<Automezzo> aut = new ArrayList<Automezzo>();
		FileOutputStream fos = new FileOutputStream("automezzi.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Automezzo a1 = new Automezzo("Portofino", "Ferrari","ABC", 2010);
		Autoveicolo b1 = new Autoveicolo("Fiesta", "Ford", "AA333AA", 2012, "Benzina", 5, 5);
		Motociclo c1 = new Motociclo("Ninja", "Kawasaki", "BB33333", 1998,2,2);
		
		aut.add(a1);
		aut.add(b1);
		aut.add(c1);
		oos.writeObject(aut);
		oos.close();

	}
	
}
