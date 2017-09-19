//Exception that occurs if an account's balance is too low to withdraw amount specified by user
public class BalanceTooLowException extends Exception{

	public BalanceTooLowException() {
		super("Illegal withdraw. Not enough balance in account to withdraw that amount.");
	}
}
