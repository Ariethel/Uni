//Creare la gerarchia BankAccount, SavingsAccount e CheckingAccount
//Migliorare il metodo addInterest di SavingAccount in maniera da funzionare sul minimo saldo dall'ultima invocazione di addInterest.
//NB Occorre modificare anche preleva e usare variabile per ricordare il min
public class TestAccount {

	public static void main(String[] args) {
		SavingAccount sa = new SavingAccount(10);
		sa.deposita(100);
		sa.addInterest(10);
		System.out.println("Saldo: " + sa.estrattoCont());
		sa.preleva(10);
		sa.addInterest(50);
		System.out.println("Saldo: " + sa.estrattoCont());
		sa.preleva(10);
		sa.addInterest(1);
		System.out.println("Saldo: " + sa.estrattoCont());

	}

}
