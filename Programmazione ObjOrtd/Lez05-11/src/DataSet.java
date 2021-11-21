//Modificare DataSet in modo da avere, su String, le relazioni d'ordine per lunghezza e per ordine di prima lettera 
public class DataSet {
	public DataSet(Measurer m) {
		this.measurer = m;
		this.sum = 0;
		this.count = 0;
		this.minimum = null;
		this.maximum = null;
	}
	
	public void add(Object x) {
		
		sum += measurer.measure(x);
		
		if (count == 0 || measurer.measure(minimum) > measurer.measure(x))
			minimum = x;
		
		if (count == 0 || measurer.measure(maximum) < measurer.measure(x))
			maximum = x;
		count++;
	}
	
	public double getAverage(){
		
		return count == 0 ? 0 : sum / count;
	}

	public Object getMaximum()
	{
		return maximum;
	}
	
	public Object getMinimum() { 
		
		return minimum; 
	}
	

	private double sum;
	private Object minimum, maximum;
	private int count;
	private Measurer measurer;
	
}