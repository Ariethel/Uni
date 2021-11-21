import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestLibreria{

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Libro> trovatiArrayList = new ArrayList<Libro>();
		File listaLibriFile = new File("ListaLibri.txt");
		Libreria l1 = new Libreria(listaLibriFile);
		
		
		System.out.println("Tutti i libri che ho in libreria:");
		for (Libro libro : l1.getRaccolta()) {
			System.out.println(libro.getAutore() + " " + libro.getEditore() + " " + libro.getTitolo() + " " + libro.getNumeroCopie() + "\n");
		}
		
		
		System.out.println("Stampo tutti i libri di Camilleri:");
		trovatiArrayList = l1.cercaAutore("Camilleri");
		for (Libro libro : trovatiArrayList) {
			System.out.println(libro.getAutore() + " " + libro.getEditore() + " " + libro.getTitolo() + " " + libro.getNumeroCopie() + "\n");
		}
		
		System.out.println("Stampo tutti quelli con la sottostringa sogni nel nome:");
		trovatiArrayList = l1.cercaSubstring("sogni");
		for (Libro libro : trovatiArrayList) {
			System.out.println(libro.getAutore() + " " + libro.getEditore() + " " + libro.getTitolo() + " " + libro.getNumeroCopie() + "\n");
		}
		
		
		System.out.println("Stampo i libri con il numero massimo di copie:");
		trovatiArrayList = l1.cercaNumCopieMassimo();
		for (Libro libro : trovatiArrayList) {
			System.out.println(libro.getAutore() + " " + libro.getEditore() + " " + libro.getTitolo() + " " + libro.getNumeroCopie() + "\n");
		}
		
		
		System.out.println("Stampo i libri che hanno meno di 15 copie:");
		trovatiArrayList = l1.cercaSottoSoglia(15);
		for (Libro libro : trovatiArrayList) {
			System.out.println(libro.getAutore() + " " + libro.getEditore() + " " + libro.getTitolo() + " " + libro.getNumeroCopie() + "\n");
		}
		
		
		System.out.println("Adesso aggiungo 30 copie a Sogni Rossi");
		l1.aggiornaNumCopieFile("sognirossi", 30, listaLibriFile);
		
	}

}
