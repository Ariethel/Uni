
public class Posto {
	public Posto(int numFila, String letFila, boolean stato) {
		this.numFila = numFila;
		this.letFila = letFila;
		this.stato = stato;
	}
	
	
	public int getNumFila() {
		return numFila;
	}
	public void setNumFila(int numFila) {
		this.numFila = numFila;
	}
	public String getLetFila() {
		return letFila;
	}
	public void setLetFila(String letFila) {
		this.letFila = letFila;
	}
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}


	private int numFila;
	private String letFila;
	private boolean stato;
}
