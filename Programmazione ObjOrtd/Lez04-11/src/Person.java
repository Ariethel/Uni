/*
 * Progettare una classe Person che implementa Comparable e compara considerando il nome
 * Testare chiedendo all'utente di inserire 10 nomi. Stampare prima e ultima persona in ordine lessicografico e poi stampare*/
public class Person implements Comparable{
	public Person(String nome) {
		this.nome = nome;
	}
	
	public void addPerson(String nome) {
		if (min == null || min.compareTo(nome) > 0)
			min = nome;
		if (max == null || max.compareTo(nome) < 0)
			max = nome;
	}
	
	public int compareTo(Object o) {
		Person x = (Person) o;
		return (this.getNome().compareTo(x.getNome()));
	}
	
	
	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private String min = null, max = null;
	private String nome;
}
