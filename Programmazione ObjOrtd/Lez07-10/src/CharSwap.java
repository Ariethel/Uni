//Scambiare primo ed ultimo carattere di una stringa

public class CharSwap{
	public static void main(String[] args) {
		String s1 = "abcasdasdasd";
		char f_char = s1.charAt(0);
		char l_char = s1.charAt(s1.length()-1);
		String m_string = s1.substring(1,s1.length()-1);
		System.out.println(l_char + m_string + f_char);

	}
}