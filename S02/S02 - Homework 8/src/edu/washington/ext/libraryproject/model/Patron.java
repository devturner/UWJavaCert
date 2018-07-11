/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.model;

/**
 * This is the class for the patron object.
 *
 * @author Chris Turner
 */
public class Patron {
	/** This is the patrons name */
	private String name = null;
	/** This is the patrons card number */
	private int cardNumber = 0;

	/**
	 * This is the constructor for making a new patron in the library.
	 *
	 * @param name
	 *            the name of the patron
	 * @param cardNumber
	 *            the patrons cardnumber
	 */
	public Patron(String name, int cardNumber) {
		this.name = name;
		this.cardNumber = cardNumber;
	}

	/**
	 * The getter for the patrons name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * The getter got for the patrons card number.
	 *
	 * @return the cardNumber
	 */
	public int getCardNumber() {
		return cardNumber;
	}

}
