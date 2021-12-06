import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class TestImbarcazioni {
	
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		File f = new File("imbarcazioni.dat"); 
		Imbarcazione[] i = new Imbarcazione[5];
		int j = 0;
		Imbarcazione imb;
		if(f.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			while((imb = (Imbarcazione) ois.readObject()) != null) {
				i[j] = imb;
				j++;
			}
			GestioneOrmeggi go = new GestioneOrmeggi(i);
			ois.close();
		}else {
			i[j] = new Imbarcazione("abc", "Corsair", 10, 1998, null, null, null);
			j++;
			i[j] = new Imbarcazione("def", "Costa", 18, 1992, null, null, null);
			FileOutputStream fos = new FileOutputStream("imbarcazioni.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(i);
			oos.close();
		}
				
	}
}
