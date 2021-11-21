import java.util.ArrayList;

//Crea una classe motorizzazione caratterizzata da id nazionale e indirizzo(via,citta', cap, provincia)
//La motorizzazione contiene una collezione di motorini immatricolati composta di ciclomotori e moto
//Scrivere i metodi getMoto() che restituisce  una COLLEZIONE di cilindrata > 150
//getCiclomotori() COLLEZIONE cilindrata < 150
//getMotoriniConAntifurtoAttivo() che restituisce una COLLEZIONE di motorini dotati di antifurto 
public class Motorizzazione {
	 public Motorizzazione(int idNazionale,String via,String citta,int cap, String provincia) {
		this.idNazionale = idNazionale;
		this.via = via;
		this.citta = citta;
		this.cap = cap;
		this.provincia = provincia;
	 }
	 
	 public ArrayList<Motorino> getMoto(ArrayList<Motorino> lista) {
		 ArrayList<Motorino> moto = new ArrayList<Motorino>();
		 for (Motorino e : lista) {
			if (e.getCilindrata() > 150)
				moto.add(e);
		}
		 return moto;
	 }
	 
	 public ArrayList<Motorino> getCiclomotori(ArrayList<Motorino> lista) {
		 ArrayList<Motorino> ciclomotori = new ArrayList<Motorino>();
		 for (Motorino e : lista) {
			if (e.getCilindrata() < 150)
				ciclomotori.add(e);
		}
		 return ciclomotori;
	 }
	 
	 public ArrayList<Motorino> getVeicoliAntifurto(ArrayList<Motorino> lista) {
		 ArrayList<Motorino> veicoli = new ArrayList<Motorino>();
		 for (Motorino e : lista) {
			if (e.isAntifurto() == true)
				veicoli.add(e);
		}
		 return veicoli;
	 }
	 
	 
	 private int idNazionale, cap;
	 private String via,citta,provincia;
}
