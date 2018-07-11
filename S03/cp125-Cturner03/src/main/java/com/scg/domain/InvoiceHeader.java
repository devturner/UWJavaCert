package com.scg.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

import com.scg.util.Address;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceHeader.
 */
public class InvoiceHeader {

	/** The business name. */
	private String businessName;

	/** The business address. */
	private Address businessAddress;

	/** The client. */
	private ClientAccount client;

	/** The invoice date. */
	private Date invoiceDate;

	/** The invoice for month. */
	private Date invoiceForMonth;



	/**
	 * Instantiates a new invoice header.
	 *
	 * @param businessName the business name
	 * @param businessAddress the business address
	 * @param client the client
	 * @param invoiceDate the invoice date
	 * @param invoiceForMonth the invoice for month
	 */
	public InvoiceHeader(String businessName, Address businessAddress,
			ClientAccount client, Date invoiceDate, Date invoiceForMonth) {
		this.businessName = businessName;
		this.businessAddress = businessAddress;
		this.client = client;
		this.invoiceDate = invoiceDate;
		this.invoiceForMonth = invoiceForMonth;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final Calendar cal = Calendar.getInstance();
		Formatter fmtr = new Formatter();
		Formatter fmtr2 = new Formatter();
		String dateDisplay = "home";
		dateDisplay = fmtr.format(
				"%1$tB %1$te, %1$tY",cal
				).toString();
		String dateDisplay1 = "wrecker";
		dateDisplay1 = fmtr2.format("%1$tB %1$tY", invoiceForMonth).toString();

		return businessName + "\n"
				+ businessAddress.toString() + "\n" + "\n"
				+ "Invoice for: \n"
				+ client.getName() + "\n"
				+ client.getAddress().toString() + "\n"
				+ client.getContact().toString() + "\n" + "\n"
				+ "Invoice For Month Of: " + dateDisplay1 + "\n"
				+ "Invoice Date: " + dateDisplay + "\n" + "\n"
				+ "Date           Consultant        Skill               Hours   Charge \n"
				+ "-------------------------------------------------------------------"
				;
	}

}
