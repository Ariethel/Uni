import java.util.ArrayList;

import Rotaia.java.Stazioni;
import Rotaia.java.Treno;

public class TestRotaia {

	public static void main(String[] args) {
		Stazioni s1 = new Stazioni("Piazza Garibaldi", 8.20, 8.25, 0);
		Stazioni s2 = new Stazioni("Centro Direzionale", 8.50, 9.00, 2);
		Stazioni s3 = new Stazioni("Nola", 8.50, 14, 48);
		ArrayList<Stazioni> fermate1 = new ArrayList<Stazioni>();
		fermate1.add(s1);
		fermate1.add(s2);
		fermate1.add(s3);
		
		Treno t1 = new Treno(fermate1, s2, s3, 200, 50, 0.2);
		System.out.println("Numero di fermate: " + t1.getFermate());
		System.out.println("Costo finale: " + t1.getRicavo(s1, s3));
		
		Treno t2 = new Treno(fermate1, s1, s3, 50, 50, 0.4,0.1);
		System.out.println("Numero fermate treno express: " + t2.getFermate());
		System.out.println("Costo finale (compreso ristorante) " + t2.getRicavo(s1, s3));
	}

}
