
public class DataSet {
	public DataSet() {
		
		this.sum = 0;
		this.count = 0;
		this.minimum = null;
		this.maximum = null;
	}
	
	public void add(MeasurableVecchia x) {
		
		sum += x.getMeasure();
		
		if (count == 0 || minimum.getMeasure() > x.getMeasure())
			minimum = x;
		
		if (count == 0 || maximum.getMeasure() < x.getMeasure())
			maximum = x;
		count++;
	}
	
	public double getAverage(){
		
		return count == 0 ? 0 : sum / count;
	}

	public MeasurableVecchia getMaximum()
	{
		return maximum;
	}
	
	public MeasurableVecchia getMinimum() { 
		
		return minimum; 
	}
	

	private double sum;
	private MeasurableVecchia minimum, maximum;
	private int count;
	
}