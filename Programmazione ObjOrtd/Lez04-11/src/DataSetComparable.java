import java.util.ArrayList;

/*
 * Modificare la classe DataSet in modo da accettare oggetti di tipo Comparable invece di Measurable, togliere la media e memorizzare minimo e massimo.
 * Collaudare aggiungendo un certo numero di oggetti di tipo String
 * Stampare prima e ultima Stringa in ordine lessicografico*/

public class DataSetComparable {
	public DataSetComparable() {
		this.minimum = null;
		this.maximum = null;
	}
	
	public void add(Comparable x) {
		if(minimum == null || minimum.compareTo(x) > 0)
			minimum = x;
		
		if(maximum == null || maximum.compareTo(x) < 0)
			maximum = x;
	}

	public Comparable getMaximum()
	{
		return maximum;
	}
	
	public Comparable getMinimum() { 
		
		return minimum; 
	}
	
	private Comparable minimum, maximum;
	private int count;
	
}
