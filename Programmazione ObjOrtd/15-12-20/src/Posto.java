import java.io.Serializable;

public class Posto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2681997587431560069L;
	public Posto(int fila, String posizione, boolean stato) {
		this.fila = fila;
		this.posizione = posizione;
		this.stato = stato;
	}
	
	
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public String getPosizione() {
		return posizione;
	}
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	public boolean isStato() {
		return stato;
	}
	public void setStato(boolean stato) {
		this.stato = stato;
	}
	
	


	@Override
	public String toString() {
		return "Posto [fila=" + fila + ", posizione=" + posizione + ", stato=" + stato + "]";
	}




	private int fila;
	private String posizione;
	private boolean stato;
}
