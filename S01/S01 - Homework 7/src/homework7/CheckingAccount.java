package homework7;

public class CheckingAccount extends Account {

	public CheckingAccount(int amount) {
		super(amount);

	}

	public boolean writeCheck(int amount) {
		if (getBalance() > amount){
			setBalance(getBalance() - amount);
			return true;
		}
		else{
		
		return false;
		}
	}
}

