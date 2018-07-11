package edu.washington.ext;

import edu.washington.ext.common.CommissionedEmployee;

/**
 * Sales associates are store employees who also receive a commission on their
 * sales. The commission is a percentage of their current sales, individual sales
 * associates may receive different percentages of their sales in commission.
 *
 * @author Chris Turner
 */
final class LibraryAssociate extends LibraryEmployee implements CommissionedEmployee {
    /** The percentage of personal sales received as commission. */
    private double commissionRate;
    /** This is the commission total for the associate. */
    private double commissionTotal;

    /**
     * Constructor.
     *
     * @param name the employee's name
     */
    public LibraryAssociate(String name) {
        super(name);
    }

    /**
     * Sets the percentage of personal sales received as commission.
     *
     * @param rate the percentage of personal sales received as commission
     */
    public void setCommissionRate(double rate) {
        commissionRate = rate;
    }

    /**
     * Calculates the employees pay.
     *
     * @return the calculated pay for the employee
     */
    public double calculatePay() {
        double pay = super.calculatePay() + getCurrentSales() * commissionRate;
        return pay;
    }


    /**
     *Get the commission rate for the associate.
     * @return the commission rate
     */
	public double getCommissionRate() {
		return commissionRate;
	}

	/**
	 * This is the calculate commission method.
	 *
	 * @return This is the commission total for the associate
	 */
	public double calculateCommission() {
		commissionTotal = commissionRate * getCurrentSales();
		return commissionTotal;
	}

}
