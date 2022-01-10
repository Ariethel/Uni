import java.util.GregorianCalendar;

public class ArticoloRestituito extends Articolo{
	
	public ArticoloRestituito(String nome, String provenienza, int codice, double prezzo, GregorianCalendar data,
			String motivo) {
		super(nome, provenienza, codice, prezzo);
		this.data = data;
		this.motivo = motivo;
	}
	
	
	public GregorianCalendar getData() {
		return data;
	}
	public void setData(GregorianCalendar data) {
		this.data = data;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public double getPrezzo(double prezzo) {
		if (motivo.equals("danneggiato")) return 0;
		return this.getPrezzo();
	}
	
	


	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "ArticoloRestituito [data=" + data + ", motivo=" + motivo + "]";
	}






	private GregorianCalendar data;
	private String motivo;
}
