public class BankAccount {
	public BankAccount(double saldo, double interesse){ //Eccezione non controllata
		if (saldo < 0) 
			throw new IllegalArgumentException("Il saldo non puo' essere negativo");
		progressioneConto++;
		this.saldo = saldo;
		this.interesse = interesse;
	}
	
	public BankAccount(double saldo) throws Exception { //Eccezione controllata
		if (saldo < 0) 
			throw new Exception("Il saldo non puo' essere negativo");
		progressioneConto++;
		this.saldo = saldo;
		this.interesse = 2; 
	}
	
	public BankAccount() {
		progressioneConto++;
		this.saldo = 0;
		this.interesse = 2;
	}
	
	/*
	 * @param contanti contanti da depositare
	 * @throws illegalArumentException if contanti <= 0
	 * */
	public void deposita(double contanti){ //Eccezione non controllata
		if (contanti <= 0) throw new IllegalArgumentException("Non si sta depositando niente");
		this.saldo += contanti;
	}
	
	/*
	 * @param contanti contanti da prelevare
	 * @throws illegalArumentException if contanti >= this.saldo
	 * */
	public void preleva (double contanti) throws Exception {
		if (contanti < 0 || contanti > this.saldo) 
			throw new Exception("Prelievo non valido");
		assert contanti <= this.saldo;
		this.saldo -= contanti;
	}
	
	public double estrattoCont() {
		return this.saldo;
	}
	
	public void setInterest(double interesse) {
		this.interesse = interesse;
	}
	
	/*
	 * public void addInterest() { double interesse_Annuale = (this.saldo *
	 * this.interesse) / 100; this.saldo += interesse_Annuale / 4; }
	 */
	
	public int getNumeroConto() {
		return numeroConto;
	}
	
	private double saldo;
	private double interesse;
	private int numeroConto;
	private static int progressioneConto = 0;
}
