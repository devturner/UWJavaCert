package edu.washington.ext;

/**
 * This is the class that
 *
 * @author chris turner
 *
 */
public class LibraryEmployee implements Employee {

	/**
	 * These are the parameters that establish the unique elements for the
	 * Library Employee, and they are passed on the the library associate.
	 *
	 * It tracks the current hours worked, the hourly rate of pay, the number of
	 * used books sold, their name their pay
	 */
	protected double currentHours;
	protected double hourlyRate;
	private double currentSales;
	private String name;

	/**
	 * The library employee is constructed and assigned a name.
	 *
	 * @param name
	 *            - how the employee is.
	 */
	public LibraryEmployee(String name) {
		this.name = name;
	}

	/**
	 * This is the getter for the current used books the employee has sold.
	 *
	 * @return - number of used books sold.
	 */
	public double getCurrentSales() {
		return currentSales;
	}

	/**
	 * This is the setter for the current number of books that that employee has
	 * sold.
	 *
	 * @param currentSales
	 *            - number of used books sold
	 */
	public void setCurrentSales(double currentSales) {
		this.currentSales = currentSales;
	}

	/**
	 * This is the getter for the employees name.
	 *
	 * @return - the employees name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This is the setter for the current number of hours that the employee has
	 * worked.
	 *
	 * @param currentHours
	 *            - total number of hours
	 */
	public void setCurrentHours(double currentHours) {
		this.currentHours = currentHours;
	}

	/**
	 * This is the setter for the rate of pay that this employee is paid.
	 *
	 * @param hourlyRate
	 *            - the dollars per hour rate
	 */
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/**
	 * This is how pay is calculated for the library employee, they do not receive a bonus rate.
	 *
	 * @return - this is the current pay total.
	 */
	@Override
	public double calculatePay() {
		double pay = hourlyRate * currentHours;
		return pay;
	}

}
