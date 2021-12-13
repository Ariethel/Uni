import java.io.Serializable;
import java.util.ArrayList;

public class ListaClienti implements Serializable{
	public ListaClienti(ArrayList<Clienti> clienti) {
		this.clienti = clienti;
	}
	
	public void addClienti(Clienti cl) {
		clienti.add(cl);
	}
	
	public void removeClienti(Clienti cl) {
		clienti.remove(cl);
	}
	
	
	
	private ArrayList<Clienti> clienti;
}
