import java.io.Serializable;
import java.util.ArrayList;

public class PagamentoPasti implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4947993750585295139L;
	public void aggiungiTesserino(Tesserino t) {
		tesserini.add(t);
	}
	
	public boolean usaTesserino(int code) throws TesserinoScadutoException {
		for (Tesserino tesserino : tesserini) {
			if (tesserino.getCodice() == code) {
				pagamenti += tesserino.paga();
				return true;
			}
				
		}
		return false;
	}
	
	public double calcolaTotale() {
		return pagamenti;
	}
	
	ArrayList<Tesserino> tesserini = new ArrayList<Tesserino>();
	private double pagamenti;
}
