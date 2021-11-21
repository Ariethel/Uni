
public class DipendenteFullTime extends Dipendente {
	public DipendenteFullTime(String matricola, double stipendio, double straordinario, int ferieConcesse, int ferieUsate, int buoniPasto) {
		super(matricola, stipendio, straordinario);
		this.ferieConcesse = ferieConcesse;
		this.ferieUtilizzate = ferieUsate;
		this.buoniPasto = buoniPasto;
	}
	
	@Override
	public double paga(int oreStraordinario) {
		double stipendio = super.paga(oreStraordinario);
		if (buoniPasto == 0) {
			return (stipendio-=ferieUtilizzate*90);
		}else {
			return (stipendio+ (buoniPasto*5) + ((ferieConcesse-ferieUtilizzate) * 100));
		}
	}
	
	
	int ferieConcesse,ferieUtilizzate;
	int buoniPasto;
}
