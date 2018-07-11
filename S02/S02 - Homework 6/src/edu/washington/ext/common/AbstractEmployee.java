package edu.washington.ext.common;

/**
 * This class implements the Employee interface and should be used in the
 * implementation of the other employee classes to the extent possible. - this
 * means all the things that each employee has in common. constructor; get name;
 * calculatePay; set & get current sales
 *
 * @author christurner
 *
 */

public abstract class AbstractEmployee implements Employee {
	/** The employees name */
	private String name;
	/** The libraries current used book sales */
	private double currentSales;

	/**
	 * This is the most basic employee constructor, it ensures that every
	 * employee has a name.
	 *
	 * @param name
	 *            - the employees name.
	 */
	public AbstractEmployee(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the employee.
	 *
	 * @param name
	 *            - this is the employees name
	 * @return the name of the employee
	 */
	public String getName(String name) {
		return name;
	}

	/**
	 * Calculates the employees pay.
	 *
	 * @param hourlyRate
	 *            - this is the hourly rate for the employee
	 * @param currentHours
	 *            - this is the number of hours the employee has worked
	 *
	 *
	 * @return the calculated pay for the employee
	 */
	public double calculatePay(double hourlyRate, double currentHours) {
		return hourlyRate * currentHours;
	}

	/**
	 * Sets the employee's current sales.
	 *
	 * @param sales
	 *            the employee's current sales
	 */
	public void setCurrentSales(double sales) {
		this.currentSales = sales;
	}

	/**
	 * Gets the empoyee's current sales.
	 *
	 * @return the employee's current sales
	 */
	public double getCurrentSales() {
		return currentSales;
	}

}
