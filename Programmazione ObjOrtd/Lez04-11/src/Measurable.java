import java.util.Iterator;

//Aggiungere i metodi statici largest e smallest che prendono come parametro un array di Measurable e restiuiscono rispettivamente
//gli oggetti aventi misura massima e minima
public interface Measurable {

	double getMeasure();
	
	static Measurable smallest(Measurable[] arr){
		Measurable min = null;
		
		if (arr == null || arr.length == 0)
			return null;
		
		for (int i = 0; i < arr.length ; i++) {
			if (min == null || arr[i].getMeasure() < min.getMeasure())
				min = arr[i];
		}
		return min;
	}
	
	static Measurable largest(Measurable[] arr){
		Measurable max = null;
		
		if (arr == null || arr.length == 0)
			return null;
		
		for (int i = 0; i < arr.length ; i++) {
			if (max == null || arr[i].getMeasure() > max.getMeasure())
				max = arr[i];
		}
		return max;
	}
	
	

}
