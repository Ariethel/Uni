import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Libreria implements Serializable{
	
	public Libreria(ArrayList<Libro> libreria) {
		this.libreria = libreria;
	}
	
	public void aggLibro(Libro l1) {
		libreria.add(l1);
	}
	
	public Libro cercaTitolo(String titolo) throws IOException {
		for (Libro libro : libreria) {
			if (libro.getTitolo().equals(titolo))
				return libro;
		}
		throw new IOException("Libro non trovato");
	}
	
	public String elencoLibri() {
		String result = null;
		
		for (Libro libro : libreria) {
			result.concat(libro.toString());
		}
		
		return result;
	}
	
	ArrayList<Libro> libreria;
}
