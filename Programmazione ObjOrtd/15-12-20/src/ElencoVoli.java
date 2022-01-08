import java.io.Serializable;
import java.util.ArrayList;

public class ElencoVoli implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2886361419912166292L;

	public void aggiungiVolo(Volo v) throws BadCodeException {
		for (Volo volo : voli) {
			if (volo.getCodiceVolo() == v.getCodiceVolo()) throw new BadCodeException();
		}
		
		voli.add(v);
	}
	
	
	public ElencoVoli cerca(String p, String d) throws BadCodeException {
		ElencoVoli ev = new ElencoVoli();
		for (Volo volo : voli) {
			if (volo.getPartenza().equals(p) && volo.getDestinazione().equals(d))
				ev.aggiungiVolo(volo);
		}
		
		return ev;
	}
	
	
	
	public ArrayList<Volo> getVoli() {
		return voli;
	}


	public void setVoli(ArrayList<Volo> voli) {
		this.voli = voli;
	}



	private ArrayList<Volo> voli = new ArrayList<Volo>();
}
