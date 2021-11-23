import java.util.ArrayList;

public class MyStack<T>{
	
	public  MyStack() {
		
	}
	
	public void push(T t) {
		arrayList.add(0, t);
	}
	
	public T pop() {
		return arrayList.remove(0);
	}
	
	
	public int getCount() {
		return arrayList.size();
	}
	
	
	private ArrayList<T> arrayList = new ArrayList<T>();
	
}
