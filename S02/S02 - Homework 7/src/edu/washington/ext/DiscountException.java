package edu.washington.ext;

/**
 * This is the exception class for my package.
 *
 * @author christurner
 *
 */

public class DiscountException extends Throwable {

	/**
	 * This is the method that is thrown when an exception of this type happens.
	 *
	 * @param message
	 *            - what the exact error is.
	 */
	public DiscountException(String message) {
		super(message);
	}

}
