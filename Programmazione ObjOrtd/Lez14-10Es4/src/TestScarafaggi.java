//Gestire una popolazione di scarafaggi che puo' raddoppiare oppure essere ridotta del 10%

public class TestScarafaggi {

	public static void main(String[] args) {
		PopolazioneScarafaggi p1 = new PopolazioneScarafaggi(100);
		
		p1.raddoppiaPopolazione();
		System.out.println(p1.getScarafaggi());
		
		p1.riduciPopolazione();
		System.out.println(p1.getScarafaggi());
	}

}
