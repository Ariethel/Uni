import java.util.ArrayList;
import java.util.Iterator;

public interface Predicates {
	public boolean test(Object obj);
	
	public static void remove (ArrayList<Object> coll,Predicates pred) {
			for (Object obj : coll) {
				if (pred.test(obj))
					coll.remove(obj);
			}
	}
	
	public static void retain (ArrayList<Object> coll,Predicates pred) {
		for (Object obj : coll) {
			if (!pred.test(obj))
				coll.remove(obj);
		}
	}
	
	public static ArrayList<Object> collect(ArrayList<Object> coll, Predicates pred){
		ArrayList<Object> res = new ArrayList<Object>();
		for (Object obj : coll) {
			if (pred.test(obj))
				res.add(obj);
		}
		
		return res;
	}
	
	public static int find(ArrayList<Object> coll, Predicates pred) {
		Iterator<Object> it = coll.iterator();
		int position = 0;
		while(it.hasNext()) {
			if (pred.test(it.next()))
				return position;
			position++;
		}
		return -1;
	}
	
	
	
	
	
	
	
	
}


