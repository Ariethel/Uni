//Un motorino e' caratterizzato da colore, velocita' di marcia in km/h, modello, cilindrata e antifurto (on/off)
//il costruttore ha comre parametri una stringa colore, stringa modello,numero cilindrata, float per velocita'
//Scrivere i metodi getVelocita() che restituisce la velocita'
//Accelera(float valore) che incrementa la velocita' ma deve verificare prima che antifurto sia false, in tal caso aggiungere
//all'attributo velocita', altrimenti niente.
//inserisciAntifurto() che assegna valore true all'antifurto
public class Motorino {
	public Motorino(String colore,String modello,int cilindrata,float velocita,boolean antifurto) {
		this.colore = colore;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.velocita = velocita;
		this.antifurto = antifurto;
	}
	
	public float getVelocita() {
		return velocita;
	}
	
	public void accelera(float aumento) {
		if(this.antifurto == true)
			System.out.println("Fra nun t fottr o motorin, comm a facc a pustegg po?");
		else {
			this.velocita += aumento;
		}
	}
	
	public void inserisciAntifurto() {
		this.antifurto = true;
		this.velocita = 0;
	}
	
	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}

	public boolean isAntifurto() {
		return antifurto;
	}

	public void setAntifurto(boolean antifurto) {
		this.antifurto = antifurto;
	}

	public void setVelocita(float velocita) {
		this.velocita = velocita;
	}

	public void staccaAntifurto() {
		this.antifurto = false;
	}
	
	private String colore,modello;
	private int cilindrata;
	private float velocita;
	private boolean antifurto;
}
