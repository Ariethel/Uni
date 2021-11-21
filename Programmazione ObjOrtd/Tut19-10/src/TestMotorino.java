import java.util.ArrayList;

public class TestMotorino {

	public static void main(String[] args) {
		Motorino vespone = new Motorino("Rosso", "Vespa", 125, 0, true);
		
		vespone.accelera(10);
		System.out.println(vespone.getVelocita() + "km/h");
		System.out.println("Tolgo il catenaccio");
		vespone.staccaAntifurto();
		System.out.println("Vado a Merg");
		vespone.accelera(30);
		System.out.println(vespone.getVelocita() + "km/h");
		vespone.setAntifurto(true);
		
		//Adesso testo la classe motorizzazione
		ArrayList<Motorino> lista = new ArrayList<Motorino>();
		Motorino liberty = new Motorino("Bianco", "Piaggio", 180, 0, false);
		lista.add(vespone);
		lista.add(liberty);
		Motorizzazione napoliMotorizzazione = new Motorizzazione(123, "V. dei Mille", "Napoli", 23098, "NA");
		
		//Prelevo e stampo tutti le moto
		ArrayList<Motorino> moto = new ArrayList<Motorino>();
		moto = napoliMotorizzazione.getMoto(lista);
			for (Motorino e : moto) {
				System.out.println(e.getModello()+e.getColore()+e.getCilindrata());
		}
			
		//Prelevo e stampo tutti i ciclomotori
		ArrayList<Motorino> ciclomotori = new ArrayList<Motorino>();
		ciclomotori = napoliMotorizzazione.getCiclomotori(lista);
		for (Motorino e : ciclomotori) {
			System.out.println(e.getModello()+e.getColore()+e.getCilindrata());
		}
		
		//Prelevo e stampo tutti i mezzi con antifurto attivo
		ArrayList<Motorino> veicoliAntifurto = new ArrayList<Motorino>();
		veicoliAntifurto = napoliMotorizzazione.getVeicoliAntifurto(lista);
		for (Motorino e : veicoliAntifurto) {
			System.out.println(e.getModello()+e.getColore()+e.getCilindrata());
		}
	}

}
