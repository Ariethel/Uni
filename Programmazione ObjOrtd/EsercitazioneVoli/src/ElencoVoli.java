import java.util.ArrayList;

public class ElencoVoli {
	
	public void aggiungiVolo(Volo v) throws BadCodeException {
		for (Volo volo : this.elencoVoli) {
			if (volo.getCodVolo() == v.getCodVolo())
				throw new BadCodeException();
		}
		elencoVoli.add(v);
	}
	
	public ElencoVoli cerca(String p, String d) {
		ElencoVoli ev = new ElencoVoli();
		for (Volo volo : elencoVoli) {
			if (volo.getPartenza().equals(p) && volo.getDestinazione().equals(d))
				ev.aggiungiVolo(volo);
		}
		
		return ev;
	}
	
	private ArrayList<Volo> elencoVoli = new ArrayList<Volo>();
}
