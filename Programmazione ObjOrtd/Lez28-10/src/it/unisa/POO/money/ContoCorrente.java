package it.unisa.POO.money;

//Aggiungere le precondizioni deposita(double importo) -> importo >= 0
//preleva(double importo) -> importo <= saldo
//Aggiungi classe restituisciSaldo();
//Aggiungi classe restituisciNumeroConto(), ogni conto ha un numero progressivo che lo identifica
public class ContoCorrente{
	
	public ContoCorrente(float saldo, float interesse){
		progressioneConto++;
		this.saldo = saldo;
		this.interesse = interesse;
	}
	
	public ContoCorrente(float saldo) {
		progressioneConto++;
		this.saldo = saldo;
		this.interesse = 2; 
	}
	
	public ContoCorrente() {
		progressioneConto++;
		this.saldo = 0;
		this.interesse = 2;
	}
	
	/*
	 * @param contanti contanti da depositare
	 * @throws illegalArumentException if contanti <= 0
	 * */
	public void deposita(float contanti) {
		assert contanti >= 0;
		this.saldo += contanti;
	}
	
	/*
	 * @param contanti contanti da prelevare
	 * @throws illegalArumentException if contanti >= this.saldo
	 * */
	public void preleva (float contanti) {
		assert contanti <= this.saldo;
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
	
	public int getNumeroConto() {
		return numeroConto;
	}
	
	private float saldo;
	private float interesse;
	private int numeroConto;
	private static int progressioneConto = 0;
	
}
