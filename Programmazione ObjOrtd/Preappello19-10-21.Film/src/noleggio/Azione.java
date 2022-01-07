package noleggio;

import java.util.Objects;

public class Azione extends Film{
	
	
	public Azione(String id, String titolo) {
		super(id, titolo);
	}

	public double calcolaPenaleRitardo(int giorniRitardo) {
		return 3.00 * giorniRitardo;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Azione) obj;
		return Objects.equals(id, other.id) && Objects.equals(titolo, other.titolo);
	}
	
	public String toString() {
		return super.toString();
	}
}
