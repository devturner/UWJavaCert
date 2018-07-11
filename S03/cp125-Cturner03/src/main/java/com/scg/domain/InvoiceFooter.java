package com.scg.domain;

/**
 * The Class InvoiceFooter.
 */
public class InvoiceFooter {

	/** The business name. */
	private String businessName;

	/**
	 * Instantiates a new invoice footer.
	 *
	 * @param businessName the business name
	 */
	public InvoiceFooter(String businessName) {
		super();
		this.businessName = businessName;
	}

	/**
	 * Gets the business name.
	 *
	 * @return the business name
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * Sets the business name.
	 *
	 * @param businessName the new business name
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	/**
	 * Increment page number.
	 */
	public void incrementPageNumber(){

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "InvoiceFooter [businessName=" + businessName + "]";
	}




}
