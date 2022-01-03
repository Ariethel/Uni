package noleggio;

import java.util.ArrayList;

public class Noleggio {
	public Noleggio(Film film, int documento, int giorniRitardo) throws BadIDException {
		if (documento < 0) throw new BadIDException();
		this.film = film;
		this.documento = documento;
		this.giorniRitardo = giorniRitardo;
	}
	
	public double calcolaPenaleRitardo() {
		return film.calcolaPenaleRitardo(giorniRitardo);
	}
	
	public String dammiCodice() {
		return film.dammiCodice();
	}
	
	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public int getGiorniRitardo() {
		return giorniRitardo;
	}

	public void setGiorniRitardo(int giorniRitardo) {
		this.giorniRitardo = giorniRitardo;
	}
	
	public String toString() {
		return film.toString();
	}
	
	private Film film;
	private int documento;
	private int giorniRitardo;
}
