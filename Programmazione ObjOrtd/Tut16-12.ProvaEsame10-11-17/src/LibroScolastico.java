
public class LibroScolastico extends Libro{
	
	public LibroScolastico(String gradoScolastico, String materia, String titoloCD) {
		super();
		this.gradoScolastico = gradoScolastico;
		Materia = materia;
		this.titoloCD = titoloCD;
	}
	
	
	 
	public String getGradoScolastico() {
		return gradoScolastico;
	}



	public void setGradoScolastico(String gradoScolastico) {
		this.gradoScolastico = gradoScolastico;
	}



	public String getMateria() {
		return Materia;
	}



	public void setMateria(String materia) {
		Materia = materia;
	}



	public String getTitoloCD() {
		return titoloCD;
	}



	public void setTitoloCD(String titoloCD) {
		this.titoloCD = titoloCD;
	}



	public boolean equals(LibroScolastico l2) {
		if (this.getGradoScolastico().equals(l2.getGradoScolastico()) && this.getMateria().equals(l2.getMateria()) && this.getTitolo().equals(l2.getTitoloCD()))
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "LibroScolastico [gradoScolastico=" + gradoScolastico + ", Materia=" + Materia + ", titoloCD=" + titoloCD
				+ "]";
	}



	String gradoScolastico,Materia,titoloCD;
}
