import java.util.Scanner;

/*
 * futureInvestmentValue = investmentAmount *
 * (1 + monthlyInterestRate) ^ (numberOfYears * 12)
 */
public class Exercise7 {
	
	public static double futureInvestmentValue(double investmentAmount, 
			double monthlyInterestRate, int years) {
		return investmentAmount * Math.pow((1 + monthlyInterestRate), (years * 12));
	}
	
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Amount invested: ");
		double investmentAmount = input.nextDouble();
		System.out.println("Annual interest rate: ");
		double monthlyInterestRate = input.nextDouble() / 12;
		System.out.println("Years          Future Value");
		for(int i = 1; i < 31; i++) {
			System.out.printf(i + "          " + "%10.2f",futureInvestmentValue(investmentAmount, monthlyInterestRate, i));
			System.out.println();
		}
	}

}
