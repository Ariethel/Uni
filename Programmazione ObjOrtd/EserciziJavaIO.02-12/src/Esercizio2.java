import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Esercizio2 {

	public static void main(String[] args) throws FileNotFoundException {
		//Input file
		Scanner in = new Scanner(System.in); 
		System.out.println("Inserire file input");
		FileInputStream fpi = new FileInputStream(in.next());
		
		//Capire come fare questa cosa
		Scanner fsc = new Scanner(fpi);
		String line;
		while(fsc.hasNext()) {
			line = fsc.next();
			
		}
		
		
		//Output file
		Scanner out = new Scanner(System.in); 
		System.out.println("Inserire file output");
		FileInputStream fpo = new FileInputStream(out.next());
		

	}

}
