
public class Exercise2 {

	public static long sumDigits(long n) {
		long sum = 0;
		while(n > 0) {
			long digit = n % 10;
			sum = sum + digit;
			n = n / 10;
		}
		return sum;
	}
	
	public static void main (String [] args) {
		System.out.println(sumDigits(34789));
	}
	
}
