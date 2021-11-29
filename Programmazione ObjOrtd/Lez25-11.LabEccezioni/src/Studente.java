
public class Studente extends Utente{

	public Studente(String nome, String cognome, String login, String password,String matricola) {
		super(nome, cognome, login, password);
		this.matricola = matricola;
		this.numeroEsamiSuperati = 0;
	}
	
	public int getNumeroEsamiSuperati() {
		return numeroEsamiSuperati;
	}
	public void setNumeroEsamiSuperati(int numeroEsamiSuperati) {
		this.numeroEsamiSuperati = numeroEsamiSuperati;
	}
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	
	//Aggiungi esame
	public void aggiungiEsame(String nomeEsame,String voto){
		int v = 0;
		
		try {
			v= Integer.parseInt(voto);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Voto non valido");
		}
		
		this.numeroEsamiSuperati++;
		libretto[numeroEsamiSuperati][0] = nomeEsame;
		libretto[numeroEsamiSuperati][1] = voto;
		this.sommaVoti += v;
		
	}
	
	public double getMediaEsami() throws Exception {
		if (numeroEsamiSuperati == 0)
			throw new Exception("Nessun esame superato");
		else {
			return ((double)this.sommaVoti / this.numeroEsamiSuperati);
		}
	}
	
	
	int sommaVoti;
	int numeroEsamiSuperati;
	String[][] libretto = new String[20][1];
	String matricola;
}
