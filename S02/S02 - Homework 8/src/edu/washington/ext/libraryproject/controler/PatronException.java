/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.controler;

import edu.washington.ext.libraryproject.model.Patron;

/**
 * PatronException contains the patron object that is defined in library as well
 * as the name that is being tried to add.
 *
 * @author christurner
 *
 */
public class PatronException extends Exception {
	/** This is a patron */
	private Patron patron;

	/**
	 * This is a constructor for the error: user is already a member
	 *
	 * @param patron
	 *            the patron
	 */
	public PatronException(Patron patron) {
		this.patron = patron;
		if (patron.getName() == null || patron.getName() == "") {
			System.err.println("Patron must not be null.");
		} else {
			System.err.println("Error: " + getPName(patron)
					+ " is already a library member.");
		}

	}

	/**
	 * This is a constructor for the error: user is not valid.
	 *
	 * @param libraryCardNumber
	 *            the the library card number
	 */
	public PatronException(int libraryCardNumber) {
		System.err.println("Error: There is no user with ID '"
				+ libraryCardNumber + "'.");
	}

	/**
	 * This is a getter for the patrons name:
	 *
	 * @return patron
	 *            the patron
	 */
	public String getPName(Patron patron) {
		return patron.getName();
	}

}
