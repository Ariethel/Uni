import java.io.IOException;
import java.util.GregorianCalendar;

public class Partita {
	
	
	public Partita(Squadra s1, Squadra s2, int punteggios1, int punteggios2, GregorianCalendar svolgimento) throws IOException {
		if (s1.equals(s2)) throw new IOException();
		if (punteggios1 < 0 || punteggios2 < 0) throw new RuntimeException();
		this.s1 = s1;
		this.s2 = s2;
		this.punteggios1 = punteggios1;
		this.punteggios2 = punteggios2;
		this.svolgimento = svolgimento;
	}
	public int getPunteggios2() {
		return punteggios2;
	}
	public void setPunteggios2(int punteggios2) {
		this.punteggios2 = punteggios2;
	}
	public Squadra getS1() {
		return s1;
	}
	public void setS1(Squadra s1) {
		this.s1 = s1;
	}
	public Squadra getS2() {
		return s2;
	}
	public void setS2(Squadra s2) {
		this.s2 = s2;
	}
	public int getPunteggio() {
		return punteggios1;
	}
	public void setPunteggio(int punteggio) {
		this.punteggios1 = punteggio;
	}
	public GregorianCalendar getSvolgimento() {
		return svolgimento;
	}
	public void setSvolgimento(GregorianCalendar svolgimento) {
		this.svolgimento = svolgimento;
	}
	
	
	private Squadra s1, s2;
	private int punteggios1, punteggios2;
	private GregorianCalendar svolgimento;
}
