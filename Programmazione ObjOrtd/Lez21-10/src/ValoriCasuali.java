import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

//Scrivere un programma che genera 20 valori casuali interi tra 0 e 99, li salva in un file e stampa la media
//Scrivere un secondo programma che chiede l'inserimento di un numero x compreso tra 0 e 99 e restituisce vero se x e' presente 
//nel file creato dal programma precedente (lo faccio in un solo programma per comodita')

public class ValoriCasuali {

	public static void main(String[] args) throws FileNotFoundException {
		Random numeriRandom = new Random();
		int totale = 0;
		PrintStream ps = new PrintStream(new File("Risultati.txt"));
		for (int i = 0; i < 20; i++) {
			int numero = numeriRandom.nextInt(100);
			totale += numero;
			ps.println(numero);
		}
		double media = totale / 20.0;
		System.out.println("La media e': " + media);
		
		//Secondo programma
		
		Scanner s1 = new Scanner(System.in);
		System.out.println("Inserire il numero da cercare ");
		int n = s1.nextInt();
		Scanner fileScanner = new Scanner(new File("Risultati.txt"));
		while (fileScanner.hasNextInt()) {		
			int m = fileScanner.nextInt();
			if (n == m){
				System.out.println("Trovato");
				fileScanner.close();
				s1.close();
				System.exit(0);
			}
		}
		System.out.println("Non trovato");
	}

}
