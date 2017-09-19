//Exception that occurs if user tries to create an account with an identical name to another account
public class DuplicateAccountException extends Exception {
	
	public DuplicateAccountException() {
		super("There is already an account with that name.");
	}

}
