package noleggio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AdminConsole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5335779397827796985L;

	public static void main(String[] args) throws IOException {
	
	Film f1 = new Film(111, "LOTR");
	Film f2 = new Film(222, "Star Trek");
	Film f3 = new Film(333, "Star Wars");
	
	Noleggio n1 = new Noleggio(f1, 1, 0);
	Noleggio n2 = new Noleggio(f2, 2, 5);
	Noleggio n3 = new Noleggio(f3, 3, 10);
	
	ElencoNoleggi en = new ElencoNoleggi();
	en.aggiungiNoleggio(n1);
	en.aggiungiNoleggio(n2);
	en.aggiungiNoleggio(n3);
	
	FileOutputStream fos = new FileOutputStream("giggino.bin");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(en);
	oos.close();
	fos.close();

	}	
}
