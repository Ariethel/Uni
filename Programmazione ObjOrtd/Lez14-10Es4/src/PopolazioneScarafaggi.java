public class PopolazioneScarafaggi{
	
	public PopolazioneScarafaggi() {
		this.scarafaggi = 1;
	}
	
	public PopolazioneScarafaggi(int scarafaggi) {
		this.scarafaggi = scarafaggi;
	}
	
	public void raddoppiaPopolazione() {
		this.scarafaggi *= 2;
	}
	
	public void riduciPopolazione() {
		this.scarafaggi -= (this.scarafaggi*10)/100;
	}
	
	public int getScarafaggi() {
		return this.scarafaggi;
	}
	
	private int scarafaggi;
}
