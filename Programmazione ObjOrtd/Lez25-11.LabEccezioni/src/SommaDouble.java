import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class SommaDouble {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String d;
		double somma = 0;
		Boolean count = false;
		while(true && !count) {
			d = in.next();
			try {
				somma += Double.parseDouble(d);
				count = false;
			}catch (NumberFormatException e) {
				if(!count) {
					count = true;
					System.out.println("Inserire un double");
				}else {
					return;
				}
				
			}
		}
		
		System.out.println("Somma: " + somma);

	}

}
