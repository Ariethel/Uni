
public class TestCountry {

	public static void main(String[] args) {
		Country c1 = new Country(200, "California");
		Country c2 = new Country(10, "Napoli");
		Country c3 = new Country(15000, "Russia");
		
		DataSetComparable dsa = new DataSetComparable();
		dsa.add(c1);
		dsa.add(c2);
		Country c = (Country)dsa.getMaximum();
		System.out.println("La massima superficie: " + c.getSuperficie() + " Del Country: " + c.getNome());
		
		c = (Country)dsa.getMinimum();
		System.out.println("La minima superficie: " + c.getSuperficie() + " Del Country: " + c.getNome());
		
		dsa.add(c3);
		c = (Country)dsa.getMaximum();
		System.out.println("La massima superficie (aggiornata): " + c.getSuperficie() + " Del Country: " + c.getNome());

	}

}
