import java.io.InvalidClassException;
import java.security.PublicKey;

public class TestMeasurer{

	public static void main(String[] args) {
		
		class ByLenght implements Measurer{ //Classe ausiliaria per implementare l'ordinamento per lunghezza
			public double measure(Object obj) {
				String str = (String)obj;
				return str.length();
			}
		}
		
		
		class ByOrder implements Measurer{ //Ordinamento per ordine della prima lettera
			public double measure(Object obj) {
				String str = (String)obj;
				return str.charAt(0);
			}
		}
		
		
		DataSet ds = new DataSet(new ByOrder());
		ds.add("Casa");
		ds.add("Scuola");
		ds.add("Zeta");
		ds.add("Lezione");
		System.out.println("Il massimo: " + (String)ds.getMaximum());

	}

}
