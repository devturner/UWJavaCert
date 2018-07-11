/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.controler;

import edu.washington.ext.libraryproject.common.LibraryItem;

/**
 * This is the class for the check in, check out exceptions.
 *
 * @author Chris Turner
 */
public class CheckInOutException extends Exception {

	/**
	 * This is the constructor for the error: if the item was not in the library
	 * list of media.
	 *
	 * @param item
	 *            the item that caused the error.
	 */
	public CheckInOutException(LibraryItem item) {
		super();
		System.err.println("Error: The item '" + item.getTitle()
				+ "' is not found.");
	}

	/**
	 * This is the constructor for the error: if the item is null.
	 *
	 * @param string
	 *            message about null items
	 */
	public CheckInOutException(String string) {
		super(string);
		System.err.println(string);
	}

	/**
	 * This is the constructor for the error: for the error that the person
	 * trying to check out the book is not a member.
	 *
	 * @param libraryCardNumber
	 *            the library card number that caused the error
	 */
	public CheckInOutException(int libraryCardNumber) {
		super();
		System.err.println("Error: There is no member with ID# '"
				+ libraryCardNumber + "'.");
	}

	/**
	 * This is the constructor for the error: that neither the member nor the
	 * media are in the library system.
	 *
	 * @param item
	 *            the item that caused the error.
	 * @param libraryCardNumber
	 *            the library card number that caused the error
	 */
	public CheckInOutException(LibraryItem item, int libraryCardNumber) {
		super();
		System.err.println("Error: Neither the item '" + item.getTitle()
				+ "', nor the member with ID# '" + libraryCardNumber
				+ "' has been found.");
	}

}
