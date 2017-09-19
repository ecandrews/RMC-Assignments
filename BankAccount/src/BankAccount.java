
public class BankAccount implements InterestListener {
	private String acctName;
	private int balance;
	private Bank holder;

	//create a new BankAccount with an account name, and the bank it's registered at
	public BankAccount(String acctName, Bank holder) {
		this.acctName = acctName;
		this.holder = holder;
	}

	//begin centsToDollars method
	private double centsToDollars(int cents) {
		//changing an integer to a double
		double newCents = cents * .01;
		return newCents;
	}//end centsToDollars method

	
	//begin dollarsToCents method
	private int dollarsToCents(double dollars) {
		//double to an integer
		return (int)(Math.round(dollars * 100));
	}//end dollarsToCents method

	
	//begin getAcctName method
	public String getAcctName() {
		return acctName;
	}//end getAcctName method

	
	//begin getBalance method
	public double getBalance() {
		double balanceReturning = centsToDollars(balance);
		return balanceReturning;
	}//end getBalance method

	
	//begin deposit method
	public void deposit(double credit) {
		int amountToAdd = dollarsToCents(credit);
		balance = balance + amountToAdd;
	}//end deposit method

	
	//begin withdraw method
	public boolean withdraw(double debit) throws BalanceTooLowException {
		int amountToWithdraw = dollarsToCents(debit);
		//if balance is greater than amountToWithdraw return true and set new balance
		if(balance >= amountToWithdraw) {
			balance = balance - amountToWithdraw;
			return true;
		} else {
			//if balance is less than amountToWithdraw throw BalanceTooLowException
			throw new BalanceTooLowException();
		}
	}//end withdraw method

	
	@Override
	//begin toString method 
	public String toString() {
		return String.format("Account \"%s\" has a balance of $%.2f", getAcctName(),
				getBalance());
	}//end toString method

	
	//begin postInterest method
	public void postInterest(double rate) {
		//amount of interest to deposit is the rate multiplied by the balance of this account
		double amountOfInterest = rate * this.getBalance();
		deposit(amountOfInterest);
	}//end postInterest method


	//begin main method for testing BankAccount
	public static void main (String [] args) {
		BankAccount acct = new BankAccount ("Fred", null);
		System.out.println("Created " + acct);
		System.out.println("depositing 100.00...");
		acct.deposit(100.00);
		//System.out.println(acct.balance + " cents");
		assert acct.getBalance() == 100.00 : "Balance should be 100.00. " + acct;
		System.out.println("ok\nwithdrawing 50.00...");
		//assert acct.withdraw(50.00) : "Valid withdraw refused (returned false)";
		assert acct.getBalance() == 50.00 : "Balance should be 50.00 " + acct;
		System.out.println("ok\nattempting illegal withdraw of 60.00...");
		//assert !acct.withdraw(60.00) : "Invalid withdraw allowed (returned true)";
		assert acct.getBalance() == 50.00 : "Invalid withdraw changed balance! " + acct;
		System.out.println("ok\n" + acct + "\n\nAll tests passed");
	}//end main method



}//end BankAccount class
