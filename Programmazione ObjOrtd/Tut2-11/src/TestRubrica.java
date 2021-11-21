import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestRubrica {

	public static void main(String[] args) throws FileNotFoundException {
		File rubrica = new File("Rubrica.txt");
		String str;
		Contatto a = new Contatto("Mario", "Rossi", "123098120");
		Contatto b = new Contatto("Giovanni","Bianchi", "12301098");
		ArrayList<Contatto> r1 = new ArrayList<Contatto>();
		r1.add(a);
		r1.add(b);
		Rubrica rub1 = new Rubrica(r1);
		
		System.out.println("Stampo tutti i numeri: ");
		rub1.ScriviSuFile(rubrica);
		rub1.stampaRubrica();
		/*
		System.out.println("Stampo tutti i numeri che finiscono per i: ");
		trovati = rub1.cercaFinali("i");
		for (String str : trovati) {
			System.out.println(str);
		}
		*/
		
		System.out.println("Aggiungo un contatto e stampo la lista aggiornata: ");
		Contatto c = new Contatto("Peppe", "Molesto", "123124123");
		rub1.aggiungiContatto(c);
		rub1.ScriviSuFile(rubrica);
		rub1.stampaRubrica();
		
		System.out.println("Cerco il contatto di Peppe Molesto: ");
		str = rub1.cercaContatto("Peppe", "Molesto");
		System.out.println(str);
		
		System.out.println("Rimuovo peppe molesto e stampo la lista aggiornata: ");
		rub1.rimuoviContatto("Peppe", "Molesto");
		rub1.ScriviSuFile(rubrica);
		rub1.stampaRubrica();
		
		System.out.println("Aggiorno il contatto di Giovanni: ");
		rub1.aggiornaContatto(a, b);
		rub1.ScriviSuFile(rubrica);
		rub1.stampaRubrica();
		
		rub1.esportaContatti(rubrica);
	}

}
