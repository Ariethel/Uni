import java.util.ArrayList;

public class Idraulico {
	
	
	public Idraulico(int matricola, int numInterventi, String cognome, String nome, ArrayList<Interventi> interventi) {
		this.matricola = matricola;
		this.numInterventi = numInterventi;
		this.cognome = cognome;
		this.nome = nome;
		this.interventi = interventi;
	}
	
	
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public int getNumInterventi() {
		return numInterventi;
	}
	public void setNumInterventi(int numInterventi) {
		this.numInterventi = numInterventi;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Interventi> getInterventi() {
		return interventi;
	}
	public void setInterventi(ArrayList<Interventi> interventi) {
		this.interventi = interventi;
	}
	
	public void effettuaIntervento(Interventi i) {
		numInterventi++;
		interventi.add(i);
	}


	private int matricola, numInterventi;
	private String cognome, nome;
	private ArrayList<Interventi> interventi;
}
