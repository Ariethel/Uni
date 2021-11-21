import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Libreria{
	public Libreria(File listaLibri) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(listaLibri);
		while(fileScanner.hasNextLine()) {
			Libro e = new Libro(null, null, null, 0);
			e.setTitolo(fileScanner.next());
			e.setAutore(fileScanner.next());
			e.setEditore(fileScanner.next());
			e.setNumeroCopie(fileScanner.nextInt());
			raccolta.add(e);
		}
		
		fileScanner.close();
	}
	
	public ArrayList<Libro> cercaAutore(String autore) {
		ArrayList<Libro> trovatiArrayList = new ArrayList<Libro>();
		for (Libro libro : raccolta) {
			if (libro.getAutore().equalsIgnoreCase(autore)) {
				trovatiArrayList.add(libro);
			}
		}
		return trovatiArrayList;
	}
	
	public ArrayList<Libro> cercaSubstring(String substring) {
		ArrayList<Libro> trovatiArrayList = new ArrayList<Libro>();
		for (Libro libro : raccolta) {
			if (libro.getTitolo().contains(substring)) {
				trovatiArrayList.add(libro);
			}
		}
		return trovatiArrayList;
	}
	
	
	public ArrayList<Libro> cercaNumCopieMassimo() {
		ArrayList<Libro> trovatiArrayList = new ArrayList<Libro>();
		int max = 0;
		for (Libro libro : raccolta) {
			if (libro.getNumeroCopie() > max) {
				max = libro.getNumeroCopie();
			}
		}
		
		for (Libro libro : raccolta) {
			if (libro.getNumeroCopie() == max) {
				trovatiArrayList.add(libro);
			}
		}
		
		return trovatiArrayList;
	}
	
	public ArrayList<Libro> cercaSottoSoglia(int sogliaMin) {
		ArrayList<Libro> trovatiArrayList = new ArrayList<Libro>();
		for (Libro libro : raccolta) {
			if (libro.getNumeroCopie() < sogliaMin) {
				trovatiArrayList.add(libro);
			}
		}
		return trovatiArrayList;
	}
	
	public void aggiornaNumCopieFile(String titolo,int nuoveCopie, File ListaLibri) throws FileNotFoundException {
		for (Libro libro : raccolta) {
			if (libro.getTitolo().equals(titolo)) {
				libro.setNumeroCopie(nuoveCopie);
			}
		}
		PrintStream ps = new PrintStream(new File("ListaLibri.txt"));
		for (Libro libro : raccolta) {
			ps.print(libro.getTitolo());
			ps.print(libro.getAutore());
			ps.print(libro.getEditore());
			ps.print(libro.getNumeroCopie());
			ps.print("\n");
		}
		
		ps.close();
		
		
	}
	
	ArrayList<Libro> raccolta = new ArrayList<Libro>();

	public ArrayList<Libro> getRaccolta() {
		return raccolta;
	}

	public void setRaccolta(ArrayList<Libro> raccolta) {
		this.raccolta = raccolta;
	}

}