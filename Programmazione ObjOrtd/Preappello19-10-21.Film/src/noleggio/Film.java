package noleggio;

import java.util.Objects;

public class Film {
	public Film(String id, String titolo) {
		this.id = id;
		this.titolo = titolo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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



	protected String id, titolo;
}
