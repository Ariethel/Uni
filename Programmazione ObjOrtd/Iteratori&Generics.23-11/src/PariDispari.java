
public class PariDispari implements Predicates{

	@Override
	public boolean test(Object obj) {
		int numero = (int)obj;
		if (numero % 2 == 0)
			return true;
		return false;
	}

}
