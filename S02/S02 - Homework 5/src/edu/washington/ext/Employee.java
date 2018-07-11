package edu.washington.ext;

/**
 * This is the interface that establishes the basics that all library employee
 * will have available to use.
 *
 * @author christurner
 *
 */
public interface Employee {

	/**
	 * This is the employees name
	 * @return - returns their name.
	 */
	public String getName();

	/**
	 * This is the method to calculate the employees pay.
	 * @return - their pay
	 */
	public double calculatePay();

}
