package Gioco;

public class Cliente {
	public Cliente(String cf, double saldo) {
		this.cf = cf;
		this.saldo = saldo;
	}
	
	public void acquistaBiglietti(GiocoAzzardo gioco) {
		if (saldo > gioco.getCostoBiglietto()) {
			if (gioco instanceof Ambata)
				this.bigliettoAmbata++;
			else if (gioco instanceof CartaAlta)
				this.bigliettoCartaAlta++;
			
			this.saldo -= gioco.getCostoBiglietto();
		}
	}
	
	public void giocaBiglietto(GiocoAzzardo gioco) {
		if(gioco instanceof Ambata && bigliettoAmbata > 0) {
			this.bigliettoAmbata--;
			Ambata g1 = new Ambata(gioco.getCostoBiglietto());
			g1.gioca();
			this.saldo += g1.dammiVincita();
		}
		if(gioco instanceof CartaAlta && bigliettoCartaAlta > 0) {
			this.bigliettoCartaAlta--;
			CartaAlta g2 = new CartaAlta(gioco.getCostoBiglietto());
			g2.gioca();
			this.saldo += g2.dammiVincita();
		}
	}
	
	
	
	
	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getBigliettoAmbata() {
		return bigliettoAmbata;
	}

	public void setBigliettoAmbata(int bigliettoAmbata) {
		this.bigliettoAmbata = bigliettoAmbata;
	}

	public int getBigliettoCartaAlta() {
		return bigliettoCartaAlta;
	}

	public void setBigliettoCartaAlta(int bigliettoCartaAlta) {
		this.bigliettoCartaAlta = bigliettoCartaAlta;
	}

	@Override
	public String toString() {
		return "Cliente [cf=" + cf + ", saldo=" + saldo + ", bigliettoAmbata=" + bigliettoAmbata
				+ ", bigliettoCartaAlta=" + bigliettoCartaAlta + "]";
	}




	private String cf;
	private double saldo;
	private int bigliettoAmbata,bigliettoCartaAlta;
}
