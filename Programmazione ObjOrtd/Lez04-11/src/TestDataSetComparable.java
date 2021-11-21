
public class TestDataSetComparable {

	public static void main(String[] args) {
		String s1 = "antonio";
		String s2 = "peppino";
		String s3 = "aaa";
		String s4 = "pluto";
		
		DataSetComparable dsa = new DataSetComparable();
		dsa.add(s1);
		dsa.add(s2);
		System.out.println("Il minimo tra s1 ed s2: " + (String)dsa.getMinimum());
		dsa.add(s3);
		System.out.println("Il minimo tra s1, s2 ed s3: " + (String)dsa.getMinimum());
		dsa.add(s4);
		System.out.println("Il massimo tra s1,s2,s3 ed s4: " + (String)dsa.getMaximum());

	}

}
