import java.util.ArrayList;
import java.util.Iterator;

public class Supermercato {
	public Supermercato(ArrayList<Prodotto> p) {
		this.prodotti = p;
	}
	
	
	public void aggiugiProdotto(Prodotto p) {
		prodotti.add(p);
	}
	
	public String daiTipoProdotto(int i) {
		Prodotto[] prod = (Prodotto[]) prodotti.toArray();
		return (prod[i].getClass().toString());
		
	}
	
	public Object getMinimo() {
		double min = 0;
		Object obj = null;
		for (Prodotto prod : prodotti) {
			if (min == 0 || prod.getPrezzo() < min) {
				min = prod.getPrezzo();
				obj = prod;
			}
				
		}
		return obj;
	}
	
	public Object getMassimo() {
		double max = 0;
		Object obj) = null;
		for (Prodotto prod : prodotti) {
			if (max == 0 || prod.getPrezzo() > max) {
				max = prod.getPrezzo();
				obj = prod;
			}
				
		}
		return obj;
	}
	
	public ArrayList<Prodotto> cerca(String marca) {
		ArrayList<Prodotto> trovati = new ArrayList<Prodotto>();
		for (Prodotto prod : prodotti) {
			if (prod.getMarca().equals(marca))
				trovati.add(prod);
		}
		
		return trovati;
	}
	
	private ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
}
