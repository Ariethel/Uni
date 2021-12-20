import java.io.Serializable;
import java.util.ArrayList;

public class PagamentoPasti implements Serializable{


	private static final long serialVersionUID = 7473917263114252485L;
	
	
	public void aggiungiTesserino(Tesserino t) {
		tesserini.add(t);
	}
	
	public boolean usaTesserino(String code) throws TesserinoScadutoException, SaldoInsufficienteException {
		for (Tesserino tesserino : tesserini) {
			if (tesserino.getCodice().equalsIgnoreCase(code)) {
				sommaIncassata += tesserino.paga();
				return true;
			}
				
		}
		
		return false;
	}
	
	public double calcolaTotale() {
		return sommaIncassata;
	}
	
	public PagamentoPasti dammiTesserinoPerTipo(int x) throws ParametroInvalidoException {
		PagamentoPasti pp = new PagamentoPasti();
		if (x != 0 && x != 1) throw new ParametroInvalidoException();
		if (x == 0) {
			for (Tesserino tesserino : tesserini) {
				if (tesserino instanceof TesserinoStudente)
					pp.aggiungiTesserino(tesserino);
			}
		}
		if (x == 1) {
			for (Tesserino tesserino : tesserini) {
				if (tesserino instanceof TesserinoPersonale)
					pp.aggiungiTesserino(tesserino);
			}
		}
		
		return pp;
	}
	
	public double dammiSommaSpesa() {
		double spesa = 0;
		for (Tesserino tesserino : tesserini) {
			if (tesserino instanceof TesserinoPersonale)
				spesa += ((TesserinoPersonale) tesserino).getSommaSpesa();
		}
		
		return spesa;
	}
	
	
	
	public double getSommaIncassata() {
		return sommaIncassata;
	}

	public void setSommaIncassata(double sommaIncassata) {
		this.sommaIncassata = sommaIncassata;
	}

	public ArrayList<Tesserino> getTesserini() {
		return tesserini;
	}

	public void setTesserini(ArrayList<Tesserino> tesserini) {
		this.tesserini = tesserini;
	}



	private double sommaIncassata;
	private ArrayList<Tesserino> tesserini = new ArrayList<Tesserino>();
}
