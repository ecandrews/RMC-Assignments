//I'm too lazy to fix the formatting
public class Exercise8 {
	public static void main(String [] args) {
		System.out.println("Celsius       Fahrenheit     |     Fahrenheit     Celsius");
		System.out.println("---------------------------------------------------------");
		double iCelsius = 40.0;
		double iFahrenheit = 120.0;
		for(iCelsius = 40.0; iCelsius >= 31.0; iCelsius--) {
			System.out.println(iCelsius + "            " + celsiusToFahrenheit(iCelsius) + "        " + "|" + "     " +
					iFahrenheit + "     " + fahrenheitToCelsius(iFahrenheit));
			iFahrenheit --;
		}
	}
	
	public static double celsiusToFahrenheit(double celsius) {
		return (9.0 / 5) * celsius + 32;
	}
	
	public static double fahrenheitToCelsius(double fahrenheit) {
		return (5.0 / 9) * (fahrenheit - 32);
	}
	
}
