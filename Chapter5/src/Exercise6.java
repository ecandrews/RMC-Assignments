//what the heck, I can't figure out how to left-align it...
public class Exercise6 {

	public static void displayPattern(int n) {
		String display = "";
		for(int i = 1; i <= n; i++) {
			display = display + i + " ";
			System.out.printf("%-15s", display);
			System.out.println();
		}
	}
	
	public static void main(String [] args) {
		displayPattern(10);
	}
	
}
