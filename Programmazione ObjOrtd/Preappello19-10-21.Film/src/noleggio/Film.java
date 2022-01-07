package noleggio;

import java.io.Serializable;
import java.util.Objects;

public class Film implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5265580137426902845L;
	public Film(int id2, String titolo) {
		this.id = id2;
		this.titolo = titolo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	public double calcolaPenaleRitardo(int giorniRitardo) {
		return 2.50 * giorniRitardo;
	}
	
	
	

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(id, other.id) && Objects.equals(titolo, other.titolo);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titolo=" + titolo + "]";
	}



	int id;
	protected String titolo;
}
