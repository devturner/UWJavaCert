package homework7;

public class SavingsAccount extends Account {

	public SavingsAccount(int amount) {
		super(amount);
		
	}
	
	public void applyInterest(double rate) {
		double balance;
		balance = getBalance() * rate + getBalance(); 
		setBalance((int) balance);
		
	}

}
