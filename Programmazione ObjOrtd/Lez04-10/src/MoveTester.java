//Scrivere un programma che inizializzi una variabile box con angolo superiore sinistro (10,20)
//ed i cui lati abbiano lunghezza 40. Sostituire poi il contenuto di box con un rettangolo
//di angolo sinistro superiore (20,20) e con i lati di lunghezza 40, calcolare area e perimetro prima
//e dopo lo spostamento e stamparne poi i risultati.
import java.awt.Rectangle;

public class MoveTester{
	public static void main(String[] args) {
		
		Rectangle box = new Rectangle(10,20,40,40);
		
		System.out.println("X:"+box.getX());
		System.out.println("Y:"+box.getY());
		System.out.println("Area: "+box.getHeight()*box.getWidth());
		System.out.println("Perimetro: "+((box.getHeight()+box.getWidth())*2));
		box.translate(10,0);
		System.out.println("Translation...");
		System.out.println("X:"+box.getX());
		System.out.println("Y:"+box.getY());
		System.out.println("Area: "+box.getHeight()*box.getWidth());
		System.out.println("Perimetro: "+((box.getHeight()+box.getWidth())*2));
		
		
		
		
	}
}