
public class Docente extends Utente{

	public Docente(String nome, String cognome, String login, String password,String numeroStudio,String dip) {
		super(nome, cognome, login, password);
		this.numeroStudio = numeroStudio;
		this.dip = dip;
	}
	
	String numeroStudio;
	String dip;

}
