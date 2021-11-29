import java.util.Scanner;

public class TestBankAccount {

	public static void main(String[] args) throws Exception {
		System.out.println("1 - Prelievo\n"
				+ "2 - Deposito\n"
				+ "3 - Crea BankAccount\n");
		Scanner in = new Scanner(System.in);
		int scelta = in.nextInt();
		BankAccount b1 = new BankAccount(100);
		int i;
		switch (scelta) {
		case 1: {
			try {
				System.out.println("Quanto si desidera prelevare?");
				i = in.nextInt();
				b1.preleva(i);
			} catch (Exception e) {
				System.out.println("Prelevare una somma valida");
				i = in.nextInt();
				b1.preleva(i);
			}
		}
		break;
		case 2:{
				System.out.println("Quanto si desidera depositare?");
				i = in.nextInt();
				b1.deposita(i);
		}
		break;
		case 3:{
				System.out.println("Inserire un saldo di base");
				i = in.nextInt();
				b1 = new BankAccount(i);
		}
		break;
		default:
			//throw new IllegalArgumentException();
		}
		
	}

}
