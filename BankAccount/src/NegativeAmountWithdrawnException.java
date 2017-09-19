//Exception that occurs if a user tries to deposit or withdraw a negative amount of money
public class NegativeAmountWithdrawnException extends Exception {
	
	public NegativeAmountWithdrawnException() {
		super("You cannot withdraw a negative amount from an account.");
	}

}
