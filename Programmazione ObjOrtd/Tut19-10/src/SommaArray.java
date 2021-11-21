import java.util.ArrayList;
import java.util.Scanner;


//leggere una sequenza di interi memorizzandola in un array e calcolare la somma a elementi alterni (uno somma e uno sottrae)
//Terminare l'inserimento inserendo un numero < 0
public class SommaArray {

	public static void main(String[] args) {
		int e;
		int tot = 0;
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		System.out.println("Inserire un intero: ");
		while((e=in.nextInt()) >= 0) { //Sarebbe meglio usare in.nextLine perche' nextInt potrebbe prendere il new line erroneamente
			numbers.add(e);
			System.out.println("Inserire un intero: ");
		}
		
		for (int i = 0; i < numbers.size(); i++) {
			if (i % 2 == 0) {
				tot += numbers.get(i);
			}else {
				tot -= numbers.get(i);
			}
		}
		
		System.out.println("il totale e': " +tot);
	}

}
