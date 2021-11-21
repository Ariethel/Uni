package Gioco;

import java.util.ArrayList;
import java.util.Random;

public class Ambata extends GiocoAzzardo {
	
	public Ambata(double costoBiglietto) {
		super(costoBiglietto);
		Random x = new Random();
		this.numeroGiocatore = x.nextInt(45) + 1;
		this.vittoria = false;
	}

	@Override
	public void gioca() {
		ArrayList<Integer> estratti = new ArrayList<Integer>();
		Random x = new Random();
		while(estratti.size() < 10) {
			int numero = x.nextInt(45) + 1;
			if (!(estratti.contains(numero)))
				estratti.add(numero);
		}
		
		if (estratti.contains(numeroGiocatore))
			this.vittoria = true;
	}

	@Override
	public double dammiVincita() {
		if (vittoria)
			return this.getCostoBiglietto() * 10;
		else
			return 0;
	}
	
	private int numeroGiocatore;
	private boolean vittoria;
	
}
