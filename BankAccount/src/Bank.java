import java.util.ArrayList;
import java.util.Collection;

public class Bank {
	private Collection <BankAccount> accounts;
	private Collection <InterestListener> interestGainingAccounts = new ArrayList <InterestListener>();

	//begin findAccount method
	private BankAccount findAccount(String acctName) throws AccountNotFoundException {
		//go through accounts list one at a time
		for(BankAccount acct: accounts) {
			//if there is an account name that matches, return that account
			if(acctName.equals(acct.getAcctName())) {
				return acct;
			}
		}
		throw new AccountNotFoundException();
	} //end findAccount method


	//begin deposit method
	public void deposit(String acctName, double credit) throws AccountNotFoundException,
	NegativeAmountWithdrawnException {
		BankAccount account = findAccount(acctName);
		if(credit < 0) {
			throw new NegativeAmountWithdrawnException();	
		} else {
			//deposit, register account as an interest listener if the balance crosses into 1000
			double originalBalance = account.getBalance();
			account.deposit(credit);
			if(originalBalance < 1000 && account.getBalance() >= 1000) {
				addInterestListener(account);
			}
		}
	}//end deposit method


	//begin withdraw method
	public void withdraw(String acctName, double credit) throws AccountNotFoundException, 
	BalanceTooLowException, NegativeAmountWithdrawnException {
		BankAccount account = findAccount(acctName);
		if (credit < 0) {
			throw new NegativeAmountWithdrawnException();
		} else {
			//withdraw, unregister as interest listener if amount goes under 1000
			double originalBalance = account.getBalance();
			account.withdraw(credit);
			if(originalBalance >= 1000 && account.getBalance() < 1000) {
				removeInterestListener(account);
			}
		}
	}//end withdraw method


	//begin inquiry method
	public double inquiry(String acctName) throws AccountNotFoundException{
		BankAccount account = findAccount(acctName);
		return account.getBalance();
	}//end inquiry method


	//begin createAccount method
	public boolean createAccount(String acctName) throws DuplicateAccountException, AccountNotFoundException {
		BankAccount newAccount = null;
		//if findAccount throws an AccountNotFoundException, catch, and create a new account with the name given
		try {
			newAccount = findAccount(acctName);
		} catch (AccountNotFoundException anfe) {
			newAccount = new BankAccount(acctName, this);
			accounts.add(newAccount);
			return true;
		}
		//if findAccount returns an account, throw DuplicateAccountException
		throw new DuplicateAccountException();
	}//end createAccount method


	//begin getTotalAssets method
	public double getTotalAssets() {
		double totalAssetsInBank = 0;
		//goes through account list one at a time
		for(BankAccount account: accounts) {
			totalAssetsInBank = totalAssetsInBank + account.getBalance();
		}
		return totalAssetsInBank;
	}//end getTotalAssets method


	//begin generateReport method
	public void generateReport() {
		System.out.println();
		System.out.println("Bank Report:");
		System.out.println("Number of accounts: " + accounts.size());
		System.out.println("Total assets: " + getTotalAssets());
		//System.out.println("Yearly Interest Rate: 5%");
		System.out.println();
	}//end generateReport method


	//begin addInterestListener method
	public void addInterestListener(InterestListener listener) {
		interestGainingAccounts.add(listener);
		//System.out.println("Num of iga: " + interestGainingAccounts.size());
	}//end addInterestListener method


	//begin removeInterestListener method
	public void removeInterestListener(InterestListener listener) {
		interestGainingAccounts.remove(listener);
		//System.out.println("Num of iga: " + interestGainingAccounts.size());
	}//end remove InterestListener method


	//begin postInterest method
	public void postInterest(double rate) {
		//for all accounts registered as an InterestListener, add the amount of interest
		for (InterestListener listener : interestGainingAccounts) {
			listener.postInterest(rate);
		}
	}//end postInterest method


	//create a new bank
	public Bank() {
		accounts = new ArrayList<BankAccount>();
	}


	/*I completely forgot about this method, and honestly I have no idea what it's supposed to do, so
	 * I'm just going to comment it out. Hopefully I won't need it for anything...
	@Override
	public String toString() {
		return "string";
	}
	 */

	//begin getAccountBalance method
	public double getAccountBalance(String acctName) throws AccountNotFoundException {
		BankAccount account = findAccount(acctName);
		return account.getBalance();
	}//end getAccountBalance method


}//end Bank class
