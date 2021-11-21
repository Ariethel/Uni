import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestLibreria {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("prova");
		ArrayList<Libro> trovatiArrayList = new ArrayList<Libro>();
		File listaLibriFile = new File("ListaLibri.txt");
		System.out.println(listaLibriFile.getAbsolutePath());
		Libreria l1 = new Libreria(listaLibriFile);
		
		for (Libro libro : l1.getRaccolta()) {
			System.out.println(libro.getAutore() + "" + libro.getEditore() + "" + libro.getTitolo() + "" + libro.getNumeroCopie() + "\n");
		}
/*		
		trovatiArrayList = l1.cercaAutore("Camilleri");
		for (Libro libro : trovatiArrayList) {
			System.out.println(libro.getAutore() + "" + libro.getEditore() + "" + libro.getTitolo() + "" + libro.getNumeroCopie() + "\n");
		}
		
		trovatiArrayList = l1.cercaSubstring("sogni");
		for (Libro libro : trovatiArrayList) {
			System.out.println(libro.getAutore() + "" + libro.getEditore() + "" + libro.getTitolo() + "" + libro.getNumeroCopie() + "\n");
		}
		
		trovatiArrayList = l1.cercaNumCopieMassimo();
		for (Libro libro : trovatiArrayList) {
			System.out.println(libro.getAutore() + "" + libro.getEditore() + "" + libro.getTitolo() + "" + libro.getNumeroCopie() + "\n");
		}
		
		trovatiArrayList = l1.cercaSottoSoglia(15);
		for (Libro libro : trovatiArrayList) {
			System.out.println(libro.getAutore() + "" + libro.getEditore() + "" + libro.getTitolo() + "" + libro.getNumeroCopie() + "\n");
		}
		
		l1.aggiornaNumCopieFile("sognirossi", 30, listaLibriFile); */
	}

}
