import java.awt.Color;
public class Cerchio implements Colorable{
	public Cerchio(double raggio,Color colore) {
		this.raggio = raggio;
		this.colore = colore;
	}
	
	@Override
	public void setColor(Color c) {
		this.colore = c;
		
	}
	@Override
	public Color getColor(Color c) {
		return this.colore;
	}
	
	private double raggio;
	private Color colore;
}

