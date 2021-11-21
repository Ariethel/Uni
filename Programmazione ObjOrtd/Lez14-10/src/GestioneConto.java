//Implementare un programma che, tramite una classe BankAccount, possa gestire 
//un conto bancario con le operazioni:
//Deposito, Prelievlo, Visualizza Saldo e Crea nuovo conto.
//Aggiungere anche un costruttore che permetta di impostare saldo iniziale e tasso di interesse
//Terminare aggiungendo un metodo addInterest che aggiunge gli interessi TRIMETRALI al conto
//l'interesse di default e' 2 se non inizializzato


public class GestioneConto {

	public static void main(String[] args) {
		BankAccount pippo = new BankAccount(10000, 5);
		
		pippo.preleva(10);
		System.out.println(pippo.estrattoCont());
		pippo.deposita(10);
		System.out.println(pippo.estrattoCont());
		pippo.addInterest();
		System.out.println(pippo.estrattoCont());

	}

}
