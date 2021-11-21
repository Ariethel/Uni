package Gioco;

public abstract class GiocoAzzardo {
	public GiocoAzzardo(double costoBiglietto) {
		this.costoBiglietto = costoBiglietto;
	}
	
	public abstract void gioca();
	
	public abstract double dammiVincita();

	public double getCostoBiglietto() {
		return costoBiglietto;
	}

	public void setCostoBiglietto(double costoBiglietto) {
		this.costoBiglietto = costoBiglietto;
	}
	
	private double costoBiglietto;
}
