//exception that occurs if there is no account with the name specified by user
public class AccountNotFoundException extends Exception{

	public AccountNotFoundException() {
		super("There is no account with that name.");
	}
	
}
