public class BankAccount {
	public BankAccount(double saldo, double interesse){
		progressioneConto++;
		this.saldo = saldo;
		this.interesse = interesse;
	}
	
	public BankAccount(double saldo) {
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
	public void deposita(double contanti) {
		assert contanti >= 0;
		this.saldo += contanti;
	}
	
	/*
	 * @param contanti contanti da prelevare
	 * @throws illegalArumentException if contanti >= this.saldo
	 * */
	public void preleva (double contanti) {
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
