
public class TestPortamonete {

	public static void main(String[] args) {
		Coin cinquantaCent = new Coin("Cinquanta centesimi", 50);
		Coin unEuro = new Coin("Un euro", 1);
		Coin cinqueEuro = new Coin("Cinque Euro", 5);

		Portamonete salvadanaio = new Portamonete(0);
		salvadanaio.addCoin(cinqueEuro);
		salvadanaio.addCoin(unEuro);
		System.out.println("Totale " + salvadanaio.getTotal());
		salvadanaio.removeCoin(cinqueEuro);
		System.out.println("Totale aggiornato: " + salvadanaio.getTotal());

		if (salvadanaio.hasCoin(cinqueEuro) == true)
			System.out.println("Nel salvadanaio c'e' un coin da " + cinqueEuro.getCoinName());
		else {
			System.out.println("Nel salvadanaio non e' presente un coin da "+ cinqueEuro.getCoinName());
		}

		salvadanaio.addCoin(cinqueEuro);
		System.out.println("Totale aggiornato 2: " + salvadanaio.getTotal());
		if (salvadanaio.hasCoin(cinqueEuro) == true)
			System.out.println("Nel salvadanaio c'e' un coin da " + cinqueEuro.getCoinName());
		else 
			System.out.println("Nel salvadanaio non e' presente un coin da "+ cinqueEuro.getCoinName());


		Portamonete salvadanaio2 = new Portamonete(0);
		salvadanaio2.addCoin(cinqueEuro);
		salvadanaio2.addCoin(unEuro);
		salvadanaio2.addCoin(cinquantaCent);
		if(salvadanaio.equals(salvadanaio2) == true)
			System.out.println("Salvadanari uguali");
		else 
			System.out.println("Salvadanari diversi");

	}

}
