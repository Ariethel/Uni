package noleggio;

import java.io.Serializable;

public class Noleggio implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5005668485520489687L;
	
	
	public Noleggio(Film film, int idCliente, int giorniRitardo) throws BadIDException {
		if (idCliente < 0 ) throw new BadIDException();
		this.film = film;
		this.idCliente = idCliente;
		this.giorniRitardo = giorniRitardo;
	}
	
	public double calcolaPenale() {
		return film.calcolaPenaleRitardo(giorniRitardo);
	}
	
	
	
	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getGiorniRitardo() {
		return giorniRitardo;
	}

	public void setGiorniRitardo(int giorniRitardo) {
		this.giorniRitardo = giorniRitardo;
	}
	
	


	@Override
	public String toString() {
		return "Noleggio [film=" + film + ", idCliente=" + idCliente + ", giorniRitardo=" + giorniRitardo + "]";
	}




	private Film film;
	private int idCliente, giorniRitardo;
}
