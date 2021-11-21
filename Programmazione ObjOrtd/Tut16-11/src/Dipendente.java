
public class Dipendente {
	public Dipendente(String matricola, double stipendio, double straordinario) {
		this.matricola = matricola;
		this.stipendio = stipendio;
		this.straordinario = straordinario;
	}
	
	public double paga(int ore) {
		return (this.stipendio+(this.straordinario * ore));
	}
	
	public String toString() {
		return ("Matricola: " + this.getMatricola() + ", Stipendio: " + this.getStipendio() + ", Straordinario: " + this.getStraordinario());
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	public double getStraordinario() {
		return straordinario;
	}
	public void setStraordinario(double straordinario) {
		this.straordinario = straordinario;
	}



	private String matricola;
	private double stipendio,straordinario;
}
