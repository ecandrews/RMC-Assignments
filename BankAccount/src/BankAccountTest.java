import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//JUnitTest for testing the BankAccount class
public class BankAccountTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//test constructor
	@Test
	public void BankAccount() {
		BankAccount ba = new BankAccount("Lizzie", null);
		assertEquals("Lizzie", ba.getAcctName());
	}

	//test getBalance method
	@Test
	public void getBalance() {
		BankAccount ba = new BankAccount("Lizzie", null);
		assertEquals(0.00, ba.getBalance(), 0.00001);
	}

	//test deposit method
	@Test
	public void deposit() {
		BankAccount ba = new BankAccount("Lizzie", null);
		ba.deposit(1000.00);
		assertEquals(1000.00, ba.getBalance(), 0.00001);
		ba.deposit(10);
		assertEquals(1010.00, ba.getBalance(), 0.00001);
	}

	//test withdraw method
	@Test
	public void withdraw() throws BalanceTooLowException {
		BankAccount ba = new BankAccount("Lizzie", null);
		ba.deposit(5.00);
		ba.withdraw(5.00);
		assertEquals(0.00, ba.getBalance(), 0.00001);
	} 

	//test getAcctName method
	@Test
	public void getAcctName() {
		BankAccount ba = new BankAccount("Lizzie", null);
		assertEquals("Lizzie", ba.getAcctName());
	}

	//test toString method... kind of...?
	@Test
	public void toStringTest() {
		BankAccount ba = new BankAccount("Lizzie", null);
		assertEquals("Lizzie", ba.getAcctName());
		assertEquals(0.0, ba.getBalance(), 0.000001);
	}

	//test postInterest method
	@Test
	public void postInterest() {
		BankAccount ba = new BankAccount("Lizzie", null);
		assertEquals(0.0, ba.getBalance(), 0.00001);
		ba.deposit(1000.00);
		assertEquals(1000.00, ba.getBalance(), 0.00001);
		assertEquals(10, ba.getBalance() * 0.01, 0.00001);
		ba.postInterest(0.01);
		assertEquals(1000 * 0.01, 10, 0.00001);
		assertEquals(1010.00, ba.getBalance(), 0.00001);
	}


	

	/*For a while I had my centsToDollars and dollarsToCents methods in the BankAccount class
	 * set to public so that I could test them in my JUnitTest. I couldn't figure out what my
	 * problem was, and I thought it might have something to do with the math in these two 
	 * methods. And obviously I'm done with that, so these two methods are commented out now,
	 * just thought I would leave them in here for future reference.*/

	/*
	@Test
	public void centsToDollars() {
		BankAccount ba = new BankAccount("Lizzie", null);
		assertEquals(0.0, ba.getBalance(), 0.0001);
		assertEquals(1, ba.centsToDollars(100), 0.00001);
		assertEquals(.5, ba.centsToDollars(50), 0.00001);
		assertEquals(.01, ba.centsToDollars(1), 0.00001);
		double beginningValue = 0.0;
		for(int i = 0; i < 100; i++) {
			assertEquals(beginningValue, ba.centsToDollars(i), 0.00001);
			beginningValue = beginningValue + .01;
		}
	}

	@Test
	public void dollarsToCents() {
		BankAccount ba = new BankAccount("Lizzie", null);
		assertEquals(0.0, ba.getBalance(), 0.00001);
		assertEquals(100, ba.dollarsToCents(1), 0.00001);
		assertEquals(250, ba.dollarsToCents(2.5), 0.00001);
		assertEquals(3000000, ba.dollarsToCents(30000), 0.00001);
		assertEquals(1, ba.dollarsToCents(.01), 0.00001);
		assertEquals(50, ba.dollarsToCents(.5), 0.00001);
		assertEquals(1000000000, ba.dollarsToCents(10000000), 0.00001);
	}
	 */

}
