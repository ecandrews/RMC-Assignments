/*Elizabeth Andrews
 * Last update: Wed March 11, 7:31 PM
 * Not sure exactly how to do these author comment things at the top. Is this right???*/

import java.util.*;

public class Teller {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		Bank myBank = new Bank();
		int choice = 0;
		boolean continueProgram = true;

		//Teller class needs to:
		//1.) create an account
		//2.) deposit in an account
		//3.) withdraw from an account
		//4.) get an account balance
		//get interest I guess? 
		//5.) view a report for a specific account
		//6.) get a general bank report
		//7.) quit program?
		//Go into a loop so that they can return to the menu at the beginning?

		System.out.println("Welcome to to the bank!");
		//program will continue as long as continueProgram variable is set to true
		while(continueProgram) {
			try {
				//user menu
				System.out.println();
				System.out.println("Please select an action: ");
				System.out.println("1.) Create a new account");
				System.out.println("2.) Deposit funds into an account");
				System.out.println("3.) Withdraw funds from an account");
				System.out.println("4.) Get the balance of an account");
				System.out.println("5.) View overall bank report");
				System.out.println("6.) Get/Post interest");
				System.out.println("7.) Leave the bank.");
				choice = input.nextInt();


				//if choice = 1, create a new account in myBank
				if(choice == 1) {
					System.out.println("What name do you want the account to be under?");
					String accountName = input.next();
					myBank.createAccount(accountName);
					System.out.println("Thanks for creating an account with us, " + accountName + "!");


				//if choice = 2, deposit funds into a specified account
				} else if(choice == 2) {
					System.out.println("What is the name of the account you want to deposit into?");
					String accountName;
					double amountToDeposit = 0;
					accountName = input.next();
					System.out.println("How much do you wish to deposit?");
					amountToDeposit = input.nextDouble();
					myBank.deposit(accountName, amountToDeposit);
					System.out.println("Your deposit was successful!");

					
				//if choice = 3, withdraw funds from an account
				} else if(choice == 3) {
					System.out.println("What is the name of the account you want to withdraw from?");
					String accountName = input.next();
					double amountToWithdraw = 0;
					System.out.println("How much do you wish to withdraw?");
					amountToWithdraw = input.nextDouble();
					myBank.withdraw(accountName, amountToWithdraw);
					System.out.println("Your withdrawl was successful!");


				//if choice = 4, show the balance of a specific account
				} else if(choice == 4) {
					System.out.println("What is the name of the account you want to see the balance for?");
					String accountName = input.next();
					System.out.println("Account balance for " + accountName + ": " + myBank.inquiry(accountName));


				//if choice = 5, show report for the entire bank
				} else if(choice == 5) {
					myBank.generateReport();


				//if choice = 6, post interest
				} else if(choice == 6) {
					double interestRate = 0;
					System.out.println("How much interest would you like to post?");
					System.out.println("0.04 for 4%, 0.05 for 5%, etc.");
					interestRate = input.nextDouble();
					myBank.postInterest(interestRate);

					
				//if choice = 7, exit program and thank user
				}else if(choice == 7) {
					System.out.println("Thank you for banking with us! Have a great day!");
					System.exit(0);


				}else if(choice < 1 || choice > 7){
					System.out.println("Please enter a number from 1-6 to select an option.");
				}//end else-if for invalid numbers

				
			//catch blocks for all exceptions (I think)	
			} catch (InputMismatchException ie) {
				System.out.println("Please enter a valid number.");
			} catch (DuplicateAccountException dae) {
				System.out.println("Whoops! There is already an account with that name.");
			} catch (AccountNotFoundException anfe) {
				System.out.println("There is not an account with that name registered at this bank.");
			} catch (NegativeAmountWithdrawnException nawe) {
				System.out.println("Please enter a positive numerical amount to withdraw.");
			} catch (BalanceTooLowException btle) {
				System.out.println("Sorry, you don't have a high enough balance to withdraw that amount.");
			}//end exceptions
			
		}//end continueProgram while loop
	}//end main method
}//end Teller class
