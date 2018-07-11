package edu.washington.ext;

import edu.washington.ext.common.AbstractEmployee;
import edu.washington.ext.common.Employee;

/**
 * A store employee, compensated on a purely hourly pay basis.
 *
 * @author Chris Turner
 */
public class LibraryEmployee extends AbstractEmployee implements Employee {
	/** The employee's current hours. */
	private double currentHours;

	/** The employee's hourly rate. */
	private double hourlyRate;

	/** The employee's name. */
	private String name;

	/** The employee's current personal sales. */
	private double currentSales;

	/**
	 * Constructor.
	 *
	 * @param name
	 *            the employee's name
	 */
	public LibraryEmployee(String name) {
		super(name);
		this.name = name;
	}

	/**
	 * Gets the name of the employee.
	 *
	 * @return the name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the employee's current sales.
	 *
	 * @param sales
	 *            the employee's current sales
	 */
	public void setCurrentSales(double sales) {
		currentSales = sales;
	}

	/**
	 * Gets the empoyee's current sales.
	 *
	 * @return the employee's current sales
	 */
	public double getCurrentSales() {
		return currentSales;
	}

	/**
	 * Sets the employee's hourly rate.
	 *
	 * @param rate
	 *            the employee's hourly rate
	 */
	public void setHourlyRate(double rate) {
		this.hourlyRate = rate;
	}

	/**
	 * Sets the employee's current hours.
	 *
	 * @param hours
	 *            - the employee's current hours
	 */
	public void setCurrentHours(double hours) {
		this.currentHours = hours;
	}

	/**
	 * Calculates the employees pay.
	 *
	 * @return the calculated pay for the employee
	 */
	public double calculatePay() {
		return hourlyRate * currentHours;
	}
}
