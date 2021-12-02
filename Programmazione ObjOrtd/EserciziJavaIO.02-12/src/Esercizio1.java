import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Esercizio1 {

	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("input.dat");
		Scanner sc = new Scanner(fin);
		String parolaChiave = "mioso";
		String line;
		while(sc.hasNext()) {
			line = sc.next();
			if (line.contains(parolaChiave))
				System.out.println(line);
		}
		
		//Adesso cerco tutte le righe con la parola "div" in una pagina web
		InputStream fin2 = new URL("https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html").openStream();
		Scanner sc2 = new Scanner(fin);
		parolaChiave = "java";
		while(sc2.hasNext()) {
			line = sc2.next();
			if (line.contains(parolaChiave))
				System.out.println(line);
		}

	}

}
