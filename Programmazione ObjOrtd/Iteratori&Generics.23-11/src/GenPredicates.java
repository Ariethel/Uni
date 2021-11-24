import java.util.ArrayList;
import java.util.Iterator;

public interface GenPredicates<T extends Predicates>{

	public boolean test(T obj);
	
	public default void remove (ArrayList<T> coll,Predicates pred) {
		for (T obj : coll) {
			if (pred.test(obj))
				coll.remove(obj);
		}
	}

	public default  void retain (ArrayList<T> coll,Predicates pred) {
		for (T obj : coll) {
			if (!pred.test(obj))
				coll.remove(obj);
		}
	}
	
	public default ArrayList<T> collect(ArrayList<T> coll, Predicates pred){
		ArrayList<T> res = new ArrayList<T>();
		for (T obj : coll) {
			if (pred.test(obj))
				res.add(obj);
		}
		
		return res;
	}
	
	public default int find(ArrayList<T> coll, Predicates pred) {
		Iterator<T> it = coll.iterator();
		int position = 0;
		while(it.hasNext()) {
			if (pred.test(it.next()))
				return position;
			position++;
		}
		return -1;
	}	


}
