import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdminConsole {

	public static void main(String[] args) throws IOException {
		
		
		Posto p1 = new Posto(1, "a", true);
		Posto p2 = new Posto(2, "a", true);
		Posto p3 = new Posto(3, "a", false);
		Posto p4 = new Posto(4, "a", true);
		Posto p5 = new Posto(5, "a", true);
		
		ArrayList<Posto> posti = new ArrayList<Posto>();
		posti.add(p1);
		posti.add(p2);
		posti.add(p3);
		posti.add(p4);
		posti.add(p5);
		
		Volo v1 = new Volo("Milano", "Palermo", null, null, 000, true, posti);
		Volo v2 = new Volo("Vienna", "Savona", null, null, 111, true, posti);
		Volo v3 = new Volo("Napoli", "Valhalla", null, null, 222, true, posti);
		
		ElencoVoli ev = new ElencoVoli();
		ev.aggiungiVolo(v1);
		ev.aggiungiVolo(v2);
		ev.aggiungiVolo(v3);
		
		FileOutputStream fos = new FileOutputStream("giggino.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(ev);
		
		fos.close();
		oos.close();
		
		
		

	}

}
