//Classe auto caratterizzata dalla resa del carburante (lt/km) e quantita' di carburante nel serbatoi.
//La resa e' specificata nel costruttore e inizialmente il servatoio e' vuoto.
//Metodo drive per simulare il percorrere di tot km riducendo di conseguenza il livello di carburante
//Metodo getGas per ispezionare il livello del carburante e un metodo addGas per fare rifornimento
public class TestAuto {

	public static void main(String[] args) {
		Auto fofi = new Auto(2,20);
		System.out.println(fofi.getGas());
		fofi.addGas();
		System.out.println(fofi.getGas());
		fofi.drive(1);
		System.out.println(fofi.getGas());
		

	}

}
