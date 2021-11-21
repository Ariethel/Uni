public class DistributoreBibite{
	public DistributoreBibite() {
		this.gettoni = 0;
		this.lattine = 10;
	}
	
	public DistributoreBibite(int lattine) {
		this.lattine = lattine;
		this.gettoni = 0;
	}
	
	public void addLattina(int lattine) {
		this.lattine += lattine;
	}
	
	public void compraLattine(int gettoni) {
		this.gettoni += gettoni;
		this.lattine -= gettoni;
	}
	
	public int getLattine() {
		return this.lattine;
	}
	
	public int getGettoni() {
		return this.gettoni;
	}
	private int gettoni;
	private int lattine;
}
