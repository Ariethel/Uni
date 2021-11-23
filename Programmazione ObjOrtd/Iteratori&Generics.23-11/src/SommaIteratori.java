import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SommaIteratori {

	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		int e;
		while ((e = in.nextInt()) != 0) {
			myList.add(e);
		}

		Iterator<Integer> it = myList.iterator();
		int somma = 0; while(it.hasNext()) { int n = it.next(); somma += n; }
		 
		System.out.println("Somma: " + somma);
		
	}

}
