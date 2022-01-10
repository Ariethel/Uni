import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Random;

public class PartitaCalcio extends Partita{
	public PartitaCalcio(Squadra s1, Squadra s2, int punteggios1, int punteggios2, GregorianCalendar svolgimento,
			double costo) throws IOException {
		super(s1, s2, punteggios1, punteggios2, svolgimento);
		this.costo = costo;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public void gioca() {
		this.getS1().setNumPartite(this.getS1().getNumPartite() + 1);
		this.getS2().setNumPartite(this.getS2().getNumPartite() + 1);
		Random ra = new Random();
		this.setPunteggio(ra.nextInt(11));
		this.setPunteggios2(ra.nextInt(11));
		
		if (this.getPunteggio() > this.getPunteggios2()) {
			this.getS1().setBudget(this.getS1().getBudget() - ((getCosto()/3)));
			this.getS2().setBudget(this.getS2().getBudget() - ((getCosto()/3) * 2));
		}
		if (this.getPunteggio() < this.getPunteggios2()) {
			this.getS1().setBudget(this.getS1().getBudget() - ((getCosto()/3) * 2));
			this.getS2().setBudget(this.getS2().getBudget() - ((getCosto()/3)));
		}
		if (this.getPunteggio() == this.getPunteggios2()) {
			this.getS1().setBudget(this.getS1().getBudget() - ((getCosto()/2)));
			this.getS2().setBudget(this.getS2().getBudget() - ((getCosto()/2)));
		}
	
	}

	private double costo;
}
