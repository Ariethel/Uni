//Scambiare tutti i caratteri 'e' con 'o' ed 'o' con 'e' ogni volta che il programma viene lanciato

public class ReplaceWords{
	public static void main(String[] args) {
		String s1 = args[0];
		s1 = s1.replace('e', '$'); //Uso un carattere fantoccio (placeholder)
		s1 = s1.replace('o', 'e');
		s1 = s1.replace('$','o');
		
		System.out.println(s1);
	}
}