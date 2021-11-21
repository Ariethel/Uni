import java.util.Scanner;

public class TestPerson {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Person plist = new Person(null);
		for (int i = 0; i < 10; i++) {
			System.out.println("Inserire un nome");
			String nome = in.nextLine();
			plist.addPerson(nome);
		}
		
		System.out.println("Minimo: " + plist.getMin() + "\nMassimo: " + plist.getMax());

	}

}
