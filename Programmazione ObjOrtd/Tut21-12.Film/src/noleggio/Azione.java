package noleggio;

import java.util.Objects;

public class Azione extends Film{

	public Azione(String titolo, int id) {
		super(titolo, id);
	}
	
	public double calcolaPenale(int x) {
		return (3*x);
	}

	@Override
	public String toString() {
		return super.toString();
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
		return id == other.id && Objects.equals(titolo, other.titolo);
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	

}
