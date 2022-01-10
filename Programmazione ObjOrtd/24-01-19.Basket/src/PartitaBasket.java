import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Random;

public class PartitaBasket extends Partita{
	
	
	public PartitaBasket(Squadra s1, Squadra s2, int punteggios1, int punteggios2, GregorianCalendar svolgimento,
			double overtime) throws IOException {
		super(s1, s2, punteggios1, punteggios2, svolgimento);
		this.overtime = overtime;
	}



	public double getOvertime() {
		return overtime;
	}



	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}

	public void gioca() {
		this.getS1().setNumPartite(this.getS1().getNumPartite() + 1);
		this.getS2().setNumPartite(this.getS2().getNumPartite() + 1);
		Random ra = new Random();
		this.setPunteggio(ra.nextInt(21) + 60);
		this.setPunteggios2(ra.nextInt(21) + 60);
		
		while(this.getPunteggio() == this.getPunteggios2()) {
			this.setPunteggio(getPunteggio() + ra.nextInt(19) + 1);
			this.setPunteggios2(getPunteggios2() + ra.nextInt(19) + 1);
		}
	}

	private double overtime;
}
