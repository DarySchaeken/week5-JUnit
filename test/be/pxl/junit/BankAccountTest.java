package be.pxl.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
	private BankAccount bankAccount;
	
	@Test
	public void dummyTest() {
		//int nieuweWaarde = 21;
		int nieuweWaarde = 20;
		assertEquals(20, nieuweWaarde);
	}
	
	@Before
	public void init(){
		bankAccount = new BankAccount("Test", "McTesty", 1000);
	}
	
	@Test
	public void depositTest() {
		bankAccount.deposit(200.5);
		assertEquals(1200.5, bankAccount.getBalance(), 0);
	}
	
	@Test
	public void withdrawTestMoreThan500AtBranch() {
		bankAccount.withdraw(550, true);
		assertEquals(450, bankAccount.getBalance(), 0);
	}
	
	@Test
	public void withdrawTest500AtATM() {
		bankAccount.withdraw(500, false);
		assertEquals(500, bankAccount.getBalance(), 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void withdrawMoreThan500AtATMThrowsIllegalArgumentException() {
		bankAccount.withdraw(500.1, false);
	}
	
	@Test
	public void isNegativeTrueTest() {
		bankAccount.withdraw(2000, true);
		assertTrue(bankAccount.isNegative());
	}
	
	@Test
	public void isNegativeZeroTest() {
		bankAccount.withdraw(1000, true);
		assertFalse(bankAccount.isNegative());
	}
	
	@Test
	public void isNotNegativeTest() {
		bankAccount.withdraw(500, true);
		assertFalse(bankAccount.isNegative());
	}

}
