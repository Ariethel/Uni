//Creare un programma che calcoli l'autonomia totale di diversi modelli di auto dati marca, modello
//targa, km con un litro e capacita' del serbatoio
public class Concessionario {

	public static void main(String[] args) {
		Modello c1 = new Modello("Fiesta","Ford",123,25,13);
		Modello c2 = new Modello("Civic", "Honda", 332, 60, 9);
		System.out.println(c1.getMarca() + c1.getmodelName() + c1.calcolaAutonomia());
		System.out.println(c2.getMarca() + c2.getmodelName() + c2.calcolaAutonomia());
	}

}
