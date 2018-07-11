package homework7;


public abstract class Account implements Withdrawable, Depositable {

	private int balance;

	public Account(int amount) {
		this.balance = amount;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return this.balance;
	}

	@Override
	public void deposit(int amount) {
		balance = getBalance() + amount;

	}

	@Override
	public boolean withdraw(int amount) {
		boolean withdraw = false;
			if (balance >= amount){
				balance = (balance - amount);
				withdraw = true;
			}
				else{
					withdraw = false;
				}
			return withdraw;
		}

	}

