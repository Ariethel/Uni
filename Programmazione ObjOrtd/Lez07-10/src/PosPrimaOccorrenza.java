import java.util.Iterator;

//Scrivere un programma che restituisca l'indice della prima ripetizione del primo carattere di una stringa
//Restituire -1 se non vi sono ripetizioni

public class PosPrimaOccorrenza{
	public static void main(String[] args) {
		String s1 = args[0];
		System.out.println(s1.indexOf(s1.charAt(0), 1));
	}
}