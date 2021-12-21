package noleggio;

import java.util.Objects;

public class Film {
	public Film(String titolo, int id) {
		this.titolo = titolo;
		this.id = id;
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "Film [titolo=" + titolo + ", id=" + id + "]";
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
		return id == other.id && Objects.equals(titolo, other.titolo);
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String dammiTitolo() {
		return this.titolo;
	}
	
	public int dammiCodice() {
		return this.id;
	}
	
	public double calcolaPenale(int x) {
		return (2*x);
	}


	protected String titolo;
	protected int id;
}
