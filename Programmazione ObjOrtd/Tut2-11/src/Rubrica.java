import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Scanner;

public class Rubrica {
	
	public Rubrica(ArrayList<Contatto> contatti) {
		this.contatti = contatti;
	}
	
	public void ScriviSuFile(File rubrica) throws FileNotFoundException {
		PrintStream psRubrica =  new PrintStream(rubrica);
		for (Contatto c : contatti) {
			psRubrica.println(c.getNome()+","+c.getCognome()+","+c.getNumeroTelefono());
		}
		
		psRubrica.close();
	}
	
	public void aggiungiContatto(Contatto cont) {
		contatti.add(cont);
	}
	
	public String cercaContatto(String nome, String cognome) {
		for (Contatto cont : contatti) {
			if (cont.getNome().equals(nome) && cont.getCognome().equals(cognome))
				return cont.getNumeroTelefono();
		}
		return null;
	}
	
	public void rimuoviContatto(String nome, String cognome){
		ArrayList<Contatto> newContatti = new ArrayList<Contatto>();
		for (Contatto cont : contatti) {
			if (!(cont.getNome().equals(nome)) || !(cont.getCognome().equals(cognome)))
				newContatti.add(cont);
			
		}
		this.contatti = newContatti;
	}
	
	public void aggiornaContatto(Contatto vecchieInfo, Contatto nuoveInfo) {
		for (Contatto cont : contatti) {
			if (cont.getNome().equals(vecchieInfo.getNome()) && cont.getCognome().equals(vecchieInfo.getCognome()) && cont.getNumeroTelefono().equals(vecchieInfo.getNumeroTelefono())) {
				cont.setNome(nuoveInfo.getNome());
				cont.setCognome(nuoveInfo.getCognome());
				cont.setNumeroTelefono(nuoveInfo.getNumeroTelefono());
			}
			
		}
	}
	
	public String[] cercaFinali(String iniziali) {
		String trovati[] = null;
		int i = 0;
		for (Contatto cont : contatti) {
			if (cont.getNome().endsWith(iniziali) || cont.getCognome().endsWith(iniziali)) {
				trovati[i] = cont.contToString();
				i++;
			}
		}
		return trovati;
	}
	
	
	public void stampaRubrica() {
		for (Contatto cont : contatti) {
			System.out.println(cont.contToString());
		}
	}
	
	public void esportaContatti(File rubrica) throws FileNotFoundException {
		File exportFile = new File("RubricaExport.txt");
		PrintStream exportPrintStream = new PrintStream(exportFile);
		for (Contatto cont : contatti) {
			exportPrintStream.println(cont.contToExport());
		}
		exportPrintStream.close();
	}
	
	public void LeggiDaFile(File rubrica) throws FileNotFoundException {
		Scanner s1 = new Scanner(rubrica);
		String[] contattoArray = null;
		String contattoString;
		Contatto contatto;
		while (s1.hasNext()) {
			contattoString = s1.nextLine();
			contattoArray = contattoString.split(",");
			contatto = new Contatto(contattoArray[0], contattoArray[1], contattoArray[2]);
			this.contatti.add(contatto);	
		}
		s1.close();
	}
	
	
	
	private ArrayList<Contatto> contatti = new ArrayList<Contatto>();
}
