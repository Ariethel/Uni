//Trasofrmare il primo carattere di una stringa da minuscolo a maiuscolo e stampare il risultato

public class PrimoCharMaiusc{
	public static void main(String[] args){
		String s1 = args[0];
		String s2 = (s1.substring(0,1).toUpperCase()) + s1.substring(1,s1.length());
		System.out.println(s2);
	
	}
}