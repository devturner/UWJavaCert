package edu.washington.ext;

import edu.washington.ext.common.AbstractEmployee;
import edu.washington.ext.common.CommissionedEmployee;
import edu.washington.ext.common.Employee;

/**
 * A Librarian employee. Librarian receive their base pay plus a bonus equal to
 * a percentage of the Library's used book total sales. All librarians receive
 * the same percentage of their Library's used book total sales. librarian's
 * don't receive separate commission/bonus for their individual used book sales.
 *
 * @author Chris Turner
 *
 */
final class Librarian extends AbstractEmployee implements Employee,
		CommissionedEmployee {
	/**
	 * The percentage of library used book sales, librarians receive as a bonus.
	 */
	private static double commissionRate;

	/** This is the commission total for the librarian. */
	private double commissionTotal;

	/** Librarian's name. */
	private String name;

	/** Base pay. */
	private double basePay;

	/** The Library current used book sales. */
	private double currentLibraryTotals;

	/** The librarians current personal used book sales. */
	private double currentSales;

	/**
	 * Constructor.
	 *
	 * @param name
	 *            the Librarian's name
	 */
	public Librarian(String name) {
		super(name);
		this.name = name;
	}

	/**
	 * Sets the percentage of Library used book sales, Librarian's receive as a
	 * bonus.
	 *
	 * @param commissionRate
	 *            - the commission rate
	 *
	 */
	public static void setCommission(double commissionRate) {
		Librarian.commissionRate = commissionRate;
	}

	/**
	 * This is the getter for the commission rate for the librarian.
	 *
	 * @return commissionRate - the commission rate
	 */
	public static double getCommissionRate() {
		return commissionRate;
	}

	/**
	 * Gets the name of the Librarian.
	 *
	 * @return the name of the Librarian
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the Librarian's current Library used book sales.
	 *
	 * @param total
	 *            - this is the number of books
	 */
	public void setCurrentSales(double total) {
		currentSales = total;
	}

	/**
	 * Gets the Librarian's current used book sales.
	 *
	 * @return the Librarian's current used book sales
	 */
	public double getCurrentSales() {
		return currentSales;
	}

	/**
	 * Sets the Librarian's base pay.
	 *
	 * @param basePay
	 *            the Librarian's base Pay
	 */
	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}

	/**
	 * Set the current Library used book sales.
	 *
	 * @param currentLibraryTotals
	 *            - this is the current total sales
	 */
	public void setCurrentLibraryTotals(double currentLibraryTotals) {
		this.currentLibraryTotals = currentLibraryTotals;
	}

	/**
	 * This is the getter for the current library total sales.
	 *
	 * @return the number of books that have sold
	 */
	public double getCurrentLibraryTotals() {
		return currentLibraryTotals;
	}

	/**
	 * Calculates the Librarian's pay.
	 *
	 * @return returns the librarians pay
	 */
	@Override
	public double calculatePay() {
		double trouble = 0;
		trouble = basePay + getCurrentLibraryTotals() * commissionRate;
		return trouble;

	}

	/**
	 * This calculates the commission for the librarian.
	 *
	 * @return returns the commission as a double
	 */
	public double calculateCommission() {
		double commissionTotal = 0;
		commissionTotal = getCurrentLibraryTotals() * commissionRate;
		return commissionTotal;
	}

}
