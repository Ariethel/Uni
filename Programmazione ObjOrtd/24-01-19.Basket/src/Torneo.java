import java.util.ArrayList;

public class Torneo {
	public Torneo(String nome, ArrayList<Squadra> squadre) {
		this.nome = nome;
		this.squadre = squadre;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Squadra> getSquadre() {
		return squadre;
	}
	public void setSquadre(ArrayList<Squadra> squadre) {
		this.squadre = squadre;
	}
	
	public void iscrivi(Squadra s) {
		squadre.add(s);
	}
	
	public void gioca() {
		
	}


	private String nome;
	private ArrayList<Squadra> squadre; 
}
