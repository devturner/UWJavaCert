package edu.washington.ext.libraryproject.controler;

import edu.washington.ext.libraryproject.common.LibraryItem;

/**
 * This is the class for the Library Exception errors.
 *
 * @author christurner
 *
 */

public class LibraryException extends Exception {

	/**
	 * This is the constructor for the error: various errors, null and duplicate
	 * items.
	 *
	 * @param string
	 *            the error message explaining why the error was thrown.
	 */
	public LibraryException(String string) {
		super(string);
		System.err.println(string);
	}

	/**
	 * This is the constructor for the error: if the item has not been checkout
	 * out of the library.
	 *
	 * @param item
	 *            what item was being verified
	 */
	public LibraryException(LibraryItem item) {
		super();
		System.err.println("Error: The item '" + item.getTitle()
				+ "' has not been checked out of the library.");
	}

}
