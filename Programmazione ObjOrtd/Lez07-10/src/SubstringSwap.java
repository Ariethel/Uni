//Creare un programma che swappi le due meta' di una stringa

public class SubstringSwap{
	public static void main(String[] args){
		String s1 = args[0];//Posso passare una stringa da riga di comando come parametro oppure dalle configurazioni (run as) di eclipse
		String prima_parte = s1.substring(0,(s1.length()/2));
		String seconda_parte = s1.substring(s1.length()/2,s1.length());
		System.out.println(seconda_parte+prima_parte);
	}
}