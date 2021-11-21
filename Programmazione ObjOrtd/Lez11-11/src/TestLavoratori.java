import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestLavoratori {

	public static void main(String[] args) {
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			Scanner in = new Scanner(System.in);
			System.out.println("Nome");
			String nome = in.nextLine();
			System.out.println("Paga");
			double paga = in.nextDouble();
			System.out.println("Ore");
			int ore = in.nextInt();
			if (r.nextInt() % 2 == 0) {
				Lavoratori p = new Lavoratori(nome, paga, ore);
				System.out.println(p.toString());
			}else {
				Lavoratori p = new LavoratoriOre(nome, paga, ore);
				System.out.println(p.toString());
			}
			
		}

	}

}
