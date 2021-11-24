
public class PositivoNegativo implements Predicates{

	@Override
	public boolean test(Object obj) {
		int numero = (int) obj;
		if (numero > 0)
			return true;
		return false;
	}

}
