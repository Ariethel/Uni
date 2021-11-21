import java.util.Random;
import java.util.Scanner;

//Creare due conti correnti, uno giocatore con 1000 euro e uno casino 100000 euro
//prende in input da tastiera un intero n e un double somma, simula il lancio di un dado con 6 facce.
//se il risultato e' n allora il programma trasferisce 5 volte somma sul conto giocatore e lo sottrae a quello del casino
//Se perde trasferisce somma da giocatore a casino
//il valore di somma deve essere inferiore al saldo del vostro conto e 5 volte piu' piccolo di quello del conto del casino.


//Se il giocatore dispone ancora di soldi chiedere se vuole continuare. Se dicita "si" il programma continua, se digita
//qualcosa di diverso da si o il conto e' 0 il programma si interrompe stampando il saldo del conto
public class Casino {

	public static void main(String[] args) {
		int contoGiocatore = 1000;
		int contoCasino = 100000;
		double puntata;
		int numeroGiocato;
		Random dado = new Random();
		Scanner in = new Scanner(System.in);
		
		
		do{
			System.out.println("Su quale numero vuoi puntare? ");
			numeroGiocato = in.nextInt();
			while (numeroGiocato > 6 || numeroGiocato <= 0) {
				System.out.println("Su quale numero vuoi puntare? ");
				numeroGiocato = in.nextInt();
			}
			System.out.println("Quanto vuoi puntare? ");
			puntata = in.nextDouble();
			while(puntata > contoGiocatore || puntata > (contoCasino/5) || puntata < 0) {
				System.out.println("Quanto vuoi puntare? ");
				puntata = in.nextDouble();
			}
			
			if (numeroGiocato == (dado.nextInt(6)+1)) {
				System.out.println("Hai vinto");
				contoGiocatore += puntata*5;
				contoCasino -= puntata*5;
			}else {
				System.out.println("Hai perso");
				contoGiocatore -= puntata;
				contoCasino += puntata;
			}
			
			System.out.println("Conto Giocatore "+ contoGiocatore);
			System.out.println("Conto Casino " + contoCasino);
			puntata = 0;
			System.out.println("Vuoi continuare a giocare?");
			
		}while(in.next().equalsIgnoreCase("si") && contoGiocatore > 0);

	}

}
