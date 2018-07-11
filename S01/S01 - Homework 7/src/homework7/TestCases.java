package homework7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TestCases {

	Account checkingAccount;
	Account savingsAccount;

	@Before
	//need to be able to set up new accounts & they should take an initial balance
	public void setUp() {
		checkingAccount = new CheckingAccount(600);
		savingsAccount = new SavingsAccount(350);
		
	}

	@Test
	//need to be able to pull money from the account - Checking
	public void withdrawCheckingTest() {
		checkingAccount.withdraw(100);
		assertEquals(500, checkingAccount.getBalance());
		System.out.println("Checking account balance after withdraw (should 500) is: " +checkingAccount.getBalance());
		System.out.println();
	}

	@Test
	//need to be able to pull money from the account - Savings
	public void withdrawSavingsTest() {
		savingsAccount.withdraw(50);
		assertEquals(300, savingsAccount.getBalance());
		System.out.println("Saving balance after withdraw (should be 300) & is: " + savingsAccount.getBalance());
		System.out.println();
	}

	@Test
	//need to be able to put money into the account
	public void depositCheckingTest() {
		checkingAccount.deposit(100);
		assertEquals(700, checkingAccount.getBalance());
		System.out.println("Checking account after deposit (should be 700) & is: " + checkingAccount.getBalance());
		System.out.println();
	}

	@Test
	//need to be able to put money into the account
	public void depositSavingsTest() {
		savingsAccount.deposit(50);
		assertEquals(400, savingsAccount.getBalance());
		System.out.println("Saving account after deposit (should be 400) is: "  + savingsAccount.getBalance());
		System.out.println();
	}

	@Test
	//withdraw from checking and have it fall
	public void writeCheckFailTest() {
		assertFalse(((CheckingAccount)checkingAccount).writeCheck(700));
		System.out.println("This should return 600 -- trying to write a check against a 600 balance account: " + checkingAccount.getBalance());
		System.out.println();
	}

	@Test
	//withdraw from checking and have it succeed
	public void writeCheckSuccessTest() {
		assertTrue(((CheckingAccount)checkingAccount).writeCheck(300));
		System.out.println("Checking account balance after writting a 300 check (should return 300) is: " + checkingAccount.getBalance());
		System.out.println();
	}

	@Test
	//savings account needs to accumulate interest of 10%
	public void applyInterestTest2() {
		((SavingsAccount)savingsAccount).applyInterest(.1);
		assertEquals(385,savingsAccount.getBalance());
		System.out.println("Saving account after interest is applied and added (should be 385) is: "  + savingsAccount.getBalance());
		System.out.println();
	}

}