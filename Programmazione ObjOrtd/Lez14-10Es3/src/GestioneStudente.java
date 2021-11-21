//Registrare voti deli esami di uno studente e recuperare il voto medio
//L'esercizio non richiede array.
public class GestioneStudente {

	public static void main(String[] args) {
		Studente peppino = new Studente();
		
		peppino.aggiungiVoto(20);
		peppino.aggiungiVoto(30);
		peppino.aggiungiVoto(24);
		System.out.println(peppino.calcolaMedia());

	}

}
