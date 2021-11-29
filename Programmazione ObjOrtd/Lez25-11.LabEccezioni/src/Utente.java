
public class Utente {
	public Utente(String nome, String cognome, String login, String password) {
		if ((login.length() < 5 || login.contains(" ")) || (password.length() < 5 || password.contains(" ")))
			throw new IllegalArgumentException("Formato non valido");
		
		if (nome.isEmpty() || cognome.isEmpty())
			throw new IllegalArgumentException("Nome e cognome non possono essere vuoti");
		
		this.nome = nome;
		this.cognome = cognome;
		this.login = login;
		this.password = password;
	}
	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	private String nome,cognome,login,password;
}
