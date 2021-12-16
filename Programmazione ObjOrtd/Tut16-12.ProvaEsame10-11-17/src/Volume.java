
public class Volume extends Libro{

	public Volume(String titolo, String curatore) {
		super();
		this.titolo = titolo;
		this.curatore = curatore;
	}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCuratore() {
		return curatore;
	}

	public void setCuratore(String curatore) {
		this.curatore = curatore;
	}

	public boolean equals(Volume l2) {
		if (this.getTitolo().equals(l2.getTitolo()) && this.getCuratore().equals(l2.getCuratore()))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Volume [titolo=" + titolo + ", curatore=" + curatore + "]";
	}



	String titolo,curatore;
}
