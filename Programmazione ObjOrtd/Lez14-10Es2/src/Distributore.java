//Un distributore contiene lattine di bibite. Per comprare una bibita il cliente deve inserire un gettone.
//Quando il gettone viene inserito una lattina cade dove puo' essere presa.
//Il distributore puo' essere riempito con ulteriori lattine.
//Vogliamo essere in grado di determinare quante lattine e gettoni sono presenti nella macchina ad un dato istante

public class Distributore {

	public static void main(String[] args) {
		DistributoreBibite d1 = new DistributoreBibite(50);
		d1.addLattina(10); //Carico 10 lattine
		System.out.println("Lattine:"+d1.getLattine()); //Numero corrente di lattine in d1
		System.out.println("Gettoni:"+d1.getGettoni()); //Numero corrente di gettoni in d1
		
		
		d1.compraLattine(4); //Ho comprato 4 lattine
		System.out.println("Lattine:"+d1.getLattine()); //Numero corrente di lattine in d1
		System.out.println("Gettoni:"+d1.getGettoni()); //Numero corrente di gettoni in d1
		
	}

}
