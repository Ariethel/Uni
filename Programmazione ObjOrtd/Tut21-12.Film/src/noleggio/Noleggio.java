package noleggio;

public class Noleggio {
	public Noleggio(Film film, int giorniRitardo, int idCliente) throws BadIDException {
		if (idCliente < 0) throw new BadIDException();
		this.film = film;
		this.giorniRitardo = giorniRitardo;
		this.idCliente = idCliente;
	}
	
	public double calcolaPenale() {
		return film.calcolaPenale(giorniRitardo);
	}
	
	
	
	
	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public int getGiorniRitardo() {
		return giorniRitardo;
	}

	public void setGiorniRitardo(int giorniRitardo) {
		this.giorniRitardo = giorniRitardo;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	




	@Override
	public String toString() {
		return "Noleggio [film=" + film + ", giorniRitardo=" + giorniRitardo + ", idCliente=" + idCliente + "]";
	}






	Film film;
	int giorniRitardo,idCliente;
	
}
