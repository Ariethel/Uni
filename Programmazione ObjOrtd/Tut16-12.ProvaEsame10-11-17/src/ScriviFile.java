import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ScriviFile {
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> listacap = new ArrayList<>();
		listacap.add("cap1");
		listacap.add("cap2");
		listacap.add("cap3");
		listacap.add("cap4");
		
		Libro l1 = new Libro("Vaffanculo","Tua Mamma",120,listacap);
		Libro l2 = new Libro("SignoreDegliAnelli","ZioPeppe",999,listacap);
		
		ArrayList<Libro> libri = new ArrayList<Libro>();
		libri.add(l1);
		libri.add(l2);
		
		
		FileOutputStream fos = new FileOutputStream("giggino.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(libri);
		oos.close();
		fos.close();
		
	}
}
