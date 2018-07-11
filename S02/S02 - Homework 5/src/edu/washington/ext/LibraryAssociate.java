package edu.washington.ext;

/**
 * This is the class that establishes the Library Associate, a special employee
 * that receives a commission on their used book sales total.
 *
 * @author christurner
 *
 */
public class LibraryAssociate extends LibraryEmployee {

	/**
	 * These are the parameters that establish the unique elements for the
	 * Library Associate.
	 *
	 * The commisionRate is the percentage of their used book sales they have
	 * added to their pay.
	 */
	private double commisionRate;

	/**
	 * The library associate is is constructed and assigned a name
	 *
	 * @param name
	 *            - who the associate is.
	 */
	public LibraryAssociate(String name) {
		super(name);
	}

	/**
	 * This sets the rate at which the associates pay will be adjusted by
	 *
	 * @param commisionRate
	 *            - the percentage that their bonus is set to
	 */
	public void setCommisionRate(double commisionRate) {
		this.commisionRate = commisionRate;
	}

	/**
	 * This is the method that is used to calculate the pay for the library
	 * associate. It is based on the number of hours that they work plus their
	 * number of used book sales times their bonus rate.
	 *
	 * @return - this is their pay
	 */
	@Override
	public double calculatePay() {
		double pay = hourlyRate * currentHours
				+ (getCurrentSales() * commisionRate);
		//System.out.println(pay);
		return pay;
	}

}
