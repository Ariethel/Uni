
public class TestPersone {

	public static void main(String[] args) {
		Persona p1 = new Persona("Antonio", "Renzullo",1998);
		System.out.println(p1.toString());
		
		Persona p2 = new Insegnante("Peppe", "Fetish", 1972, 4);
		System.out.println(p2.toString());
		
		
		Persona p3 = new Studente("Madonna", "Puttana", 1000, "Bocchini");
		System.out.println(p3.toString());
	}

}
