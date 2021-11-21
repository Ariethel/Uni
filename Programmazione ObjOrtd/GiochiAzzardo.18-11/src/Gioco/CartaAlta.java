package Gioco;

import java.util.Random;

public class CartaAlta extends GiocoAzzardo {

	public CartaAlta(double costoBiglietto) {
		super(costoBiglietto);
		this.vittoria = false;
	}
	
	@Override
	public void gioca() {
		Random x = new Random();
		int A = x.nextInt(10) + 1;
		int B = x.nextInt(10) + 1;
		int C = x.nextInt(10) + 1;
		int D = x.nextInt(10) + 1;
		
		if (C > A && D > B)
			this.vittoria = true;
		
	}


	@Override
	public double dammiVincita() {
		if (vittoria)
			return this.getCostoBiglietto() * 5;
		else
			return 0;
	}
	

	private boolean vittoria;


}
