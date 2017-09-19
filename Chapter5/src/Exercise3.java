
public class Exercise3 {
	
	public static int reverse(int number) {
		StringBuffer word = new StringBuffer("" + number);
		word.reverse();
		return 0;
	}
	
	public static boolean isPalindrome(int number) {
		if(number == reverse(number)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

	}

}
