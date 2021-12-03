import java.util.Date;

public class FuoriBordo extends Imbarcazione{
	
	
	public FuoriBordo(String targa, String marca, double lunghezza, int annoCostruzione, Date DateOrmeggio,
			Date DatePartenza, Boolean cabinato,int numeroCavalli,int numeroPersone,Boolean gommone) {
		super(targa, marca, lunghezza, annoCostruzione, DateOrmeggio, DatePartenza, cabinato);
		this.numeroCavalli = numeroCavalli;
		this.numeroPersone = numeroPersone;
		this.gommone = gommone;
	}
	
	public double dammiPotenza() {
		double potenza;
		
		
		potenza = numeroCavalli/numeroPersone;
		if (gommone)
			return (potenza-50);
		else
			return (potenza+50);
		
	}
	
	@Override
	public double dammiCostoOrmeggio() {
		int numeroGiorni = (int) this.getDatePartenza().getDay() - (int) this.getDateOrmeggio().getDay();
		return(((this.dammiPotenza() * lunghezza)*3)*numeroGiorni);
	}
	
	
	int numeroCavalli, numeroPersone;
	Boolean gommone;
	
}
