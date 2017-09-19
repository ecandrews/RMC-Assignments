
public class Exercise5 {

	public static void displaySortedNumbers(double num1, double num2, double num3) {
		String display = "";
		if(num1 >= num2 && num1 >= num3) {
			display = display + num1;
			if(num2 >= num3) {
				display = display + " " + num2 + " " + num3;
			} else if(num3 >= num2) {
				display = display + " " + num3 + " " + num2;
			}
		} else if(num2 >= num1 && num2 >= num3) {
			display = display + num2;
			if(num1 >= num3) {
				display = display + " " + num1 + " " + num3;
			} else if(num3 >= num2) {
				display = display + " " + num3 + " " + num1;
			}
		} else if(num3 >= num1 && num3 >= num2) {
			display = display + num3;
			if(num1 >= num2) {
				display = display + " " + num1 + " " + num2;
			} else if(num2 >= num1) {
				display = display + " " + num2 + " " + num1;
			}
		}
		System.out.println(display);
	}
	
	public static void main(String [] args) {
		displaySortedNumbers(3, 5, 888.9);
	}
}
