
public class Lavoratori {
	public Lavoratori(String nome, double pagaOraria, int numeroOre) {
		this.nome = nome;
		this.pagaOraria = pagaOraria;
		this.numeroOre = numeroOre;
	}
	
	public double calcolaPaga() {
		double paga = pagaOraria * 40;
		if (numeroOre > 40) {
			int straordinari = numeroOre - 40;
			return paga+((pagaOraria*1.50)*straordinari);
		}else 
			return paga;
	}
	
	public String toString() {
		String str = (getNome()+ "," + ":" + calcolaPaga());
		return str;
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPagaOraria() {
		return pagaOraria;
	}

	public void setPagaOraria(double pagaOraria) {
		this.pagaOraria = pagaOraria;
	}

	public int getNumeroOre() {
		return numeroOre;
	}

	public void setNumeroOre(int numeroOre) {
		this.numeroOre = numeroOre;
	}
	
	
	private String nome;
	private double pagaOraria;
	private int numeroOre;
}

