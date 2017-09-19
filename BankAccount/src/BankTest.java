import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
import java.util.ArrayList;

//JUnitTest for testing the Bank class
public class BankTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//test deposit method
	@Test
	public void deposit() throws AccountNotFoundException, DuplicateAccountException,
	NegativeAmountWithdrawnException {
		Bank myBank = new Bank();
		myBank.createAccount("Lizzie");
		myBank.deposit("Lizzie", 1000000.00);
		assertEquals(1000000.00, myBank.getAccountBalance("Lizzie"), 0.0001);
	}

	//test withdraw method
	@Test
	public void withdraw() throws AccountNotFoundException, BalanceTooLowException, 
	DuplicateAccountException, NegativeAmountWithdrawnException {
		Bank myBank = new Bank();
		myBank.createAccount("Lizzie");
		myBank.deposit("Lizzie", 5.00);
		myBank.withdraw("Lizzie", 5.00);
		if(myBank.getAccountBalance("Lizzie") >= 5.00) {
			assertEquals(0.00, myBank.getAccountBalance("Lizzie"), 0.000001);
		}
	}

	//test getTotalAssets method
	@Test
	public void getTotalAssets() throws AccountNotFoundException, DuplicateAccountException, 
	NegativeAmountWithdrawnException {
		Bank myBank = new Bank();
		myBank.createAccount("Lizzie");
		myBank.createAccount("Micah");
		myBank.deposit("Lizzie", 5.00);
		myBank.deposit("Micah", 5.00);
		assertEquals(10.00, myBank.getTotalAssets(), 0.00001);
	}

	//test getAccountBalance method
	@Test
	public void getAccountBalance() throws AccountNotFoundException, DuplicateAccountException,
	NegativeAmountWithdrawnException {
		Bank myBank = new Bank();
		myBank.createAccount("Lizzie");
		assertEquals(0.00, myBank.getAccountBalance("Lizzie"), 0.00001);
	}
	
	//test postInterest method
	@Test
	public void postInterest() throws AccountNotFoundException, DuplicateAccountException,
	NegativeAmountWithdrawnException {
		Bank myBank = new Bank();
		myBank.createAccount("Lizzie");
		assertEquals(0.00, myBank.getAccountBalance("Lizzie"), 0.00001);
		myBank.deposit("Lizzie", 900);
		assertEquals(900.00, myBank.getAccountBalance("Lizzie"), 0.00001);
		myBank.postInterest(0.1);
		assertEquals(900.00, myBank.getAccountBalance("Lizzie"), 0.00001);
		myBank.deposit("Lizzie", 100.00);
		assertEquals(1000.00, myBank.getAccountBalance("Lizzie"), 0.00001);
		myBank.postInterest(0.01);
		assertEquals(1010.00, myBank.getAccountBalance("Lizzie"), 0.00001);
	}


}//end JUnitTest
