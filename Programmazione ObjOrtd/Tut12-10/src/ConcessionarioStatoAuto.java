//Concessionario vuole tenere traccia dello stato auto: Veduto o Non venduto, lo stato alla creazione puo' essere 
//passato o non passato, ma di default e' Non venduta.
//metodo vendi che trasforma non venduta -> venduta se e solo se lo stato e' non venduta
public class ConcessionarioStatoAuto {

	public static void main(String[] args) {
		Auto a1 = new Auto("Honda","Civic","a123"); //auto senza stato di vendita
		Auto a2 = new Auto("Ford", "Fiesta", "b124", true); //auto venduta
		
		System.out.println(a1.getMarca()+a1.getModello());
		if (a1.getStato() == true)
			System.out.println("Venduta");
		else if(a1.getStato() == false)
			System.out.println("Non venduta \n");
		
		System.out.println(a2.getMarca()+a2.getModello());
		if (a2.getStato() == true)
			System.out.println("Venduta");
		else if(a2.getStato() == false)
			System.out.println("Non venduta \n");
		
		a1.setStato(true); //Honda Civic venduta
		
		System.out.println("\n"+a1.getMarca()+a1.getModello());
		if (a1.getStato() == true)
			System.out.println("Venduta");
		else if(a1.getStato() == false)
			System.out.println("Non venduta \n");

	}

}
