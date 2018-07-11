package edu.washington.ext;

/**
 * This is the class that creates the payroll record for all the library
 * employees.
 *
 * @author christurner
 *
 */
public class PayrollRecord {
	/**
	 * These are the parameters that are used to setup a payroll record. The
	 * employees name and their current pay.
	 */
	private String employeeName;
	private Double currentPay;

	/**
	 * This is the constructor for the payroll record, it takes the parameters
	 * employee name and current pay
	 *
	 * @param employeeName
	 *            - the name
	 * @param currentPay
	 *            - the employees current pay
	 */
	public PayrollRecord(String employeeName, Double currentPay) {
		this.employeeName = employeeName;
		this.currentPay = currentPay;
	}

	/**
	 * This gets the employees name from the payroll object.
	 *
	 * @return - the name
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * This get the employees current pay
	 *
	 * @return - this is the pay.
	 */
	public Double getCurrentPay() {
		return currentPay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currentPay == null) ? 0 : currentPay.hashCode());
		result = prime * result
				+ ((employeeName == null) ? 0 : employeeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PayrollRecord other = (PayrollRecord) obj;
		if (currentPay == null) {
			if (other.currentPay != null)
				return false;
		} else if (!currentPay.equals(other.currentPay))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		return true;
	}



}
