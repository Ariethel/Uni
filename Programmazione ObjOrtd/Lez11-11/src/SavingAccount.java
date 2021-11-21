public class SavingAccount extends BankAccount {
	
	public SavingAccount(double rate) {
		interestRate = rate;
	}
	
	
	public void addInterest(double interest) {
		if (min == 0 || interest < min)
			min = interest;
		
		double interestCount = estrattoCont() * min/100;
		deposita(interestCount);
	}
	
	private double min = 0;
	static double interestRate;
}
