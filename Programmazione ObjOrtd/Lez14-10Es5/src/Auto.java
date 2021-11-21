public class Auto{
	public Auto(double litriPerKm,int dimSerbatoio ) {
		this.litriPerKm = litriPerKm;
		this.dimSerbatoio = dimSerbatoio;
		this.livelloCarburante = 0;
	}
	
	public void addGas() {
		livelloCarburante = dimSerbatoio;
	}
	
	public int getGas() {
		return livelloCarburante;
	}
	
	public void drive(int distanza) {
		livelloCarburante -= ((int)distanza)*litriPerKm;
	}
	
	private double litriPerKm;
	private int dimSerbatoio;
	private int livelloCarburante;
}