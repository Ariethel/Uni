import java.awt.Color;
public class Rettangolo implements Colorable {
	public Rettangolo(int base,int altezza, Color colore) {
		this.base = base;
		this.altezza = altezza;
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

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	private int base, altezza;
	private Color colore;
}
