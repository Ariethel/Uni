
public class GestioneOrmeggi {
	
	public GestioneOrmeggi(Imbarcazione[] i) {
		this.imbarcazioni = i;
		num = i.length;
	}
	
	public void aggiungiImbarcazione(Imbarcazione i) {
		imbarcazioni[num] = i;
		num++;
	}
	
	public double costoOrmeggioImbarcazione(int i) {
		return imbarcazioni[i].dammiCostoOrmeggio();
	}
	
	public double costoOrmeggi() {
		double sum = 0;
		for (int i = 0;i < num; i++) {
			sum += imbarcazioni[i].dammiCostoOrmeggio();
		}
		
		return sum;
	}
	
	void effettuaCheckin(int i) {
		imbarcazioni[i].checkIn();
	}
	
	void effettuaCheckout(int i) {
		imbarcazioni[i].checkOut();
	}
	
	void stampaTutto() {
		for (int i = 0; i < num; i++) {
			System.out.println(imbarcazioni[i]);
		}
	}
	
	
	int num;
	Imbarcazione[] imbarcazioni;
}
