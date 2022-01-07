package noleggio;

public class Noleggio {
	
	
	
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



	private Film film;
	private int idCliente, giorniRitardo;
}
