public class Modello{
	
	public Modello(String modelName,String marca,int targa,int serbatoio,int km_litro) {
		this.modelName = modelName;
		this.marca = marca;
		this.targa = targa;
		this.km_Litro = km_litro;
		this.serbatoio = serbatoio;
	}
	
	public String getmodelName(){
		return modelName;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public int calcolaAutonomia() {
		return serbatoio*km_Litro;
	}
	
	private int targa,serbatoio,km_Litro;
	private String modelName;
	private String marca;
}