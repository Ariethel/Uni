import java.awt.Color;

public class OggettiColorati <S extends Colorable, T extends Colorable>{
	public OggettiColorati(S primo, T secondo) {
		this.primo = primo;
		this.secondo = secondo;
	}
	
	public S getPrimo() {
		return primo;
	}
	public void setPrimo(S primo) {
		this.primo = primo;
	}
	public T getSecondo() {
		return secondo;
	}
	public void setSecondo(T secondo) {
		this.secondo = secondo;
	}
	
	public void coloraTutti(Color c) {
		primo.setColor(c);
		secondo.setColor(c);
	}
	
	private S primo;
	private T secondo;
}
