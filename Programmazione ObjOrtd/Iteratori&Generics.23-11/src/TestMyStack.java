
public class TestMyStack {

	public static void main(String[] args) {
		MyStack<String> strStack = new MyStack<String>();
		strStack.push("Mike");
		strStack.push("Bongiorno");
		System.out.println(strStack.pop());
		System.out.println(strStack.pop());
	}

}
