import java.util.Random;

import Gioco.*;

public class TestGioco {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("ABC", 100);
		Ambata ambata = new Ambata(5);
		CartaAlta cartaAlta = new CartaAlta(3);
		
		Random x = new Random();
		for (int i = 0; i < 10; i++) {
			if(x.nextBoolean())
				cliente.acquistaBiglietti(ambata);
			else
				cliente.acquistaBiglietti(cartaAlta);
		}
		
		System.out.println(cliente.toString());
		
		while (cliente.getBigliettoAmbata() > 0) {
			cliente.giocaBiglietto(ambata);
		}
		while (cliente.getBigliettoCartaAlta() > 0) {
			cliente.giocaBiglietto(cartaAlta);
		}
		
		System.out.println(cliente.toString());
	}

}
