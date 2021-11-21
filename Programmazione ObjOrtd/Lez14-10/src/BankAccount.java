
public class BankAccount{
	
	public BankAccount(float saldo, float interesse){
		this.saldo = saldo;
		this.interesse = interesse;
	}
	
	public BankAccount(float saldo) {
		this.saldo = saldo;
		this.interesse = 2; 
	}
	
	public BankAccount() {
		this.saldo = 0;
		this.interesse = 2;
	}
	
	public void deposita(float contanti) {
		this.saldo += contanti;
	}
	
	public void preleva (float contanti) {
		this.saldo -= contanti;
	}
	
	public float estrattoCont() {
		return this.saldo;
	}
	
	public void setInterest(float interesse) {
		this.interesse = interesse;
	}
	
	public void addInterest() {
	    float	interesse_Annuale = (this.saldo * this.interesse) / 100;
		this.saldo += interesse_Annuale / 4;
	}
	
	private float saldo;
	private float interesse;
	
}