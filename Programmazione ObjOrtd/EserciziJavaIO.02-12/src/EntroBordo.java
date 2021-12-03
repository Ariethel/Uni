import java.util.Date;

public class EntroBordo extends Imbarcazione{
	
	
	public EntroBordo(String targa, String marca, double lunghezza, int annoCostruzione, Date DateOrmeggio,
			Date DatePartenza, Boolean cabinato, int numeroCabine, double altezza) {
		super(targa, marca, lunghezza, annoCostruzione, DateOrmeggio, DatePartenza, cabinato);
		this.numeroCabine = numeroCabine;
		this.altezza = altezza;
	}
	
	
	public int dammiCapienza() {
		return ((numeroCabine*2)+3);
	}

	@Override
	public double dammiCostoOrmeggio() {
		int numeroGiorni = (int) this.getDatePartenza().getDay() - (int) this.getDateOrmeggio().getDay();
		return (((altezza * numeroCabine) * 100) * numeroGiorni);
	}
	
	
	int numeroCabine;
	double altezza;
}
