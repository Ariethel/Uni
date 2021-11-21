//Ogni volta che operatore preme un pulsante il alore de lconteggio viene incrementato

public class ContaPersone{
	public static void main(String[] args) {
		Contatore counter = new Contatore(20);
		
		for (int i = 0; i < 100; i++) {
			counter.aggiungi();
		} 
		System.out.println(counter.mostraconteggio());
		
		counter.reset();
		
		System.out.println(counter.mostraconteggio());

	}
}