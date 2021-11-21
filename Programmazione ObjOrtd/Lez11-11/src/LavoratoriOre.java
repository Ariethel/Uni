public class LavoratoriOre extends Lavoratori {
	public LavoratoriOre(String nome, double pagaOraria, int numeroOre) {
		super(nome, pagaOraria, numeroOre);
	}
	
	public double calcolaPaga() {
		double paga = getPagaOraria() * getNumeroOre();
		if (getNumeroOre() > 40) {
			int straordinari = getNumeroOre() - 40;
			return paga+((getPagaOraria()*1.50)*straordinari);
		}else 
			return paga;
	}
}
