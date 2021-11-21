import java.util.ArrayList;

public class TestAzienda {
	public static void main(String[] args) {
		ArrayList<Dipendente> dipendenti = new ArrayList<Dipendente>();
		DipendenteFullTime dip1 = new DipendenteFullTime("ABC", 10000, 0, 10, 5, 10);
		DipendentePartTime dip2 = new DipendentePartTime("DEF", 500 , 0);
		DipendentePartTime dip3 = new DipendentePartTime("GHI", 10000, 0);
		dip3.prendiMalattia(5);
		
		dipendenti.add(dip1);
		dipendenti.add(dip2);
		dipendenti.add(dip3);
		
		Azienda azienda = new Azienda(dipendenti);
		System.out.println(azienda.getTotaleStipendi());
		
		System.out.println(azienda.cercaStipendioPiuAlto());
		azienda.licenziaDipendenti(2);
		System.out.println(azienda.cercaStipendioPiuAlto());
		
	}
}
