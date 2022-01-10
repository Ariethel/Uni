import java.util.Objects;

public class Squadra {
	
	
	public Squadra(String nome, int punti, int numPartite, double budget) {
		this.nome = nome;
		this.punti = punti;
		this.numPartite = numPartite;
		this.budget = budget;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public int getNumPartite() {
		return numPartite;
	}
	public void setNumPartite(int numPartite) {
		this.numPartite = numPartite;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Squadra other = (Squadra) obj;
		return Double.doubleToLongBits(budget) == Double.doubleToLongBits(other.budget)
				&& Objects.equals(nome, other.nome) && numPartite == other.numPartite && punti == other.punti;
	}

	@Override
	public String toString() {
		return "Squadra [nome=" + nome + ", punti=" + punti + ", numPartite=" + numPartite + ", budget=" + budget + "]";
	}




	private String nome;
	private int punti, numPartite;
	private double budget;
}
