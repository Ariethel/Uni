/*
 * Definire una classe Country che implementa comparable
 * un Country ha un nome e una superficie
 * il metodo compareTo confronta due nazioni in base alla superficie, restituisce -1 se il primo e' piu piccolo del secondo, 1 altrimenti  e 0 se sono uguali
 * Collaudare la classe stampando poi nome e superficie della nazione con superficie maggiore e minore*/
public class Country implements Comparable{
	
	public Country(double superficie,String nome) {
		this.superficie = superficie;
		this.nome = nome;
	}
	
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public int compareTo(Object x) {
		Country y = (Country) x;
		if (this.superficie < y.getSuperficie())
			return -1;
		if (this.superficie > y.getSuperficie())
			return 1;
		else 
			return 0;
	}
	
	
	private double superficie;
	private String nome;
	
}
