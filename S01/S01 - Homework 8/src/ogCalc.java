
public class ogCalc {

	public static void main(String[] args) {
		String string1 = args[0];
		String string2 = args[1];
		
		int num1 = Integer.parseInt(string1);
		int num2 = Integer.parseInt(string2);
		
		int sum = (num1 + num2);
		int mult = (num1 * num2);
		int div = (num1 / num2);
		int sub = (num1 - num2);
		int rem = (num1 % num2);
		
		System.out.println(num1 + num2);
		System.out.println("The sum of " + num1 + " and " + num2 + " equals " + sum);
		System.out.println(num1 + " times " + num2 + " equals " + mult);
		System.out.println(num1 + " divided by " + num2 + " equals " + div);
		System.out.println(num1 + " minus " + num2 + " equals " + sub);
		System.out.println("The remander of " + num1 + " divided by " + num2 + " equals " + rem);
		
		
	}

}

/* Minimum Requirements:

Main Class with a single main method that calls each calculation and ouputs with the same output as required in Assignment 2.
Arithmetic class with five calculation methods, each returning the result as an Integer.
Test class, testing each calculation from the Arithmetic class.
All number types should us the JDK Numerical classes. (ie. Integer instead of int, Boolean instead of boolean).

*/
