package edu.washington.ext;

/**
 * This is the class that implements Employee and creates the Librarian.
 *
 * @author christurner
 *
 */
public class Librarian implements Employee {

	/**
	 * These are the parameters that establish the unique elements for the
	 * Librarian.
	 */
	private static double bonusRate;
	private String name;
	private double basePay;
	private double currentLibraryTotals;
	private double currentLibrarianUsedBookTotals;

	/**
	 * The librarian is constructed and assigned a name.
	 *
	 * @param name
	 *            - who the librarian is.
	 */
	public Librarian(String name) {
		this.name = name;
	}

	/**
	 * This returns the librarians name as a string.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This sets the librarians base pay
	 *
	 * @param basePay
	 *            - the basic rate of pay for the librarian
	 */
	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}

	/**
	 * This sets the librarians bonus rate, it is a percentage.
	 *
	 * @param bonusRate
	 *            - the bonus rate
	 */
	public static void setBonusRate(double bonusRate) {
		Librarian.bonusRate = bonusRate;
	}

	/**
	 * This sets how many used books the librarian has sold.
	 *
	 * @param currentLibrarianUsedBookTotals
	 *            - number of used books.
	 */
	public void setCurrentLibrarianUsedBookTotals(
			double currentLibrarianUsedBookTotals) {
		this.currentLibrarianUsedBookTotals = currentLibrarianUsedBookTotals;
	}

	/**
	 * This get how many books the librarian has sold.
	 *
	 * @return - the number of used books.
	 */
	public double getCurrentLibrarianUsedBookTotals() {
		return currentLibrarianUsedBookTotals;
	}

	/**
	 * This sets the total Library used books sold.
	 *
	 * @param currentLibraryUsedBookSalesTotals
	 *            - total used books sold for the entire library.
	 */
	public void setCurrentLibraryUsedBookSalesTotals(
			double currentLibraryUsedBookSalesTotals) {

		this.currentLibraryTotals = currentLibraryUsedBookSalesTotals;
	}

	/**
	 * This method (calculatePay) returns the pay for the librarian based on their basepay and
	 * the total number of used books sold (for the entire library) multiplied by the bonus rate that the
	 * librarian receives.
	 *
	 * @return - the pay for the librarian
	 */

	@Override
	public double calculatePay() {
		double pay = basePay + (currentLibraryTotals * bonusRate);
		// System.out.println(currentLibraryTotals);
		//System.out.println(pay);
		return pay;
	}

}
