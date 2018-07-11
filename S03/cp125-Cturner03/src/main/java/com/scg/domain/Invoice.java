package com.scg.domain;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.Assignment03;

import com.scg.util.Address;
import com.scg.util.ListFactory;
import com.scg.util.StateCode;

// TODO: Auto-generated Javadoc
/**
 * The Class Invoice.
 */
public final class Invoice {

	/** The Constant PROP_FILE_NAME. */
	public static final String PROP_FILE_NAME = "invoice.properties";

	/** The Constant BUSINESS_NAME_PROP. */
	public static final String BUSINESS_NAME_PROP = "business.name";

	/** The Constant BUSINESS_STREET_PROP. */
	public static final String BUSINESS_STREET_PROP = "business.street";

	/** The Constant BUSINESS_CITY_PROP. */
	public static final String BUSINESS_CITY_PROP = "business.city";

	/** The Constant BUSINESS_STATE_PROP. */
	public static final String BUSINESS_STATE_PROP = "business.state";

	/** The Constant BUSINESS_ZIP_PROP. */
	public static final String BUSINESS_ZIP_PROP = "business.zip";

	/** The Constant NA. */
	public static final String NA = "N/A";

	/** The client. */
	private ClientAccount client;

	/** The invoice month. */
	private int invoiceMonth;

	/** The invoice year. */
	private int invoiceYear;

	/** The end date. */
	private Date endDate;

	/** The start date. */
	private Date startDate;

	/** The total charges. */
	private int totalCharges;

	/** The total hours. */
	private int totalHours;

	/** The line items. */
	private ArrayList<InvoiceLineItem> lineItems;

	/** The invoice date. */
	private Date invoiceDate;

	/** The biz street. */
	private String bizStreet;

	/** The biz city. */
	private String bizCity;

	/** The biz state. */
	private String bizState;

	/** The biz zip. */
	private String bizZip;

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(Invoice.class);

	/** The biz name. */
	private static String bizName;

	/** The biz address. */
	private static Address bizAddress;

	/** The items per page. */
	private static  int ITEMS_PER_PAGE = 5;

	/**
	 * Instantiates a new invoice.
	 *
	 * @param client the client
	 * @param invoiceMonth the invoice month
	 * @param invoiceYear the invoice year
	 */
	public Invoice(ClientAccount client, int invoiceMonth, int invoiceYear) {
		this.client = client;
		this.invoiceMonth = invoiceMonth;
		this.invoiceYear = invoiceYear;
		this.lineItems = new ArrayList<InvoiceLineItem>();

		final Calendar calendar = Calendar.getInstance();
		this.invoiceDate = calendar.getTime();
		calendar.set(Calendar.YEAR, invoiceYear);
		calendar.set(Calendar.MONTH, invoiceMonth);

		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
		startDate = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
		endDate = calendar.getTime();

		final Properties invoiceProps = new Properties();
		final File propFile = new File(PROP_FILE_NAME);
		try(FileInputStream in = new FileInputStream(propFile);){
			invoiceProps.load(in);

			} catch(final FileNotFoundException e){
				log.warn("Unable to locate Properties file," + propFile.getAbsolutePath(), e);
			} catch (final IOException e){
				log.warn("Unable to read the properties file.", e);
			}

		bizName = invoiceProps.getProperty(BUSINESS_NAME_PROP, NA);
		bizStreet = invoiceProps.getProperty(BUSINESS_STREET_PROP);
		bizCity = invoiceProps.getProperty(BUSINESS_CITY_PROP);
		bizState = invoiceProps.getProperty(BUSINESS_STATE_PROP);
		bizZip = invoiceProps.getProperty(BUSINESS_ZIP_PROP);

		bizAddress = new Address (bizStreet, bizCity, StateCode.valueOf(bizState), bizZip);

		}



	/**
	 * Extract the billable hours for this Invoice's client from the input TimeCard and add them to the line items.
	 * Only those hours for the client and month unique to this invoice will be added.
	 *
	 * @param timeCard the time card
	 */
	public void extractLineItems(TimeCard timeCard){
		final List<ConsultantTime> billableHoursList = timeCard.getBillableHoursForClient(client.getName());
		for(final ConsultantTime consultantTime : billableHoursList){
			if(inDateRange(consultantTime.getDate())){
				InvoiceLineItem x = new InvoiceLineItem(consultantTime.getDate(), timeCard.getConsultant(), consultantTime.getSkill(), consultantTime.getHours());

				addLineItems(x);

			}

		}
	}

	/**
	 * In date range.
	 *
	 * @param date the date
	 * @return true, if successful
	 */
	private boolean inDateRange(final Date date){
		return !((date.before(startDate))) || !((date.after(endDate)));
	}

	/**
	 * Adds the line items.
	 *
	 * @param lineItem the line item
	 */
	private void addLineItems(final InvoiceLineItem lineItem){
		lineItems.add(lineItem);
		totalHours += lineItem.getHours();
		totalCharges += lineItem.getHours() * lineItem.getSkill().getRate();
		}




	/**
	 * Gets the client account.
	 *
	 * @return the client account
	 */
	public ClientAccount getClientAccount() {
		return client;
	}

	/**
	 * Gets the invoice month.
	 *
	 * @return the invoice month
	 */
	public int getInvoiceMonth() {
		final Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		return invoiceMonth;
	}

	/**
	 * Gets the invoice year.
	 *
	 * @return the invoice year
	 */
	public int getInvoiceYear() {
		return invoiceYear;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Gets the total charges.
	 *
	 * @return the total charges
	 */
	public int getTotalCharges() {

		return totalCharges;
	}

	/**
	 * Gets the total hours.
	 *
	 * @return the total hours
	 */
	public int getTotalHours() {
		return totalHours;
	}


	///	public InvoiceHeader(String businessName, Address businessAddress, ClientAccount client, Date invoiceDate, Date invoiceForMonth)
	/**
	 * To report string.
	 *
	 * @return the string
	 */
	public String toReportString(){

		final InvoiceHeader invoiceHeader = new InvoiceHeader(bizName, bizAddress, client, startDate, startDate);
		//for (InvoiceLineItem invoiceLineItem : lineItems) {
		final InvoiceFooter invFoot = new InvoiceFooter(bizCity);
		String temp = null;
		for (InvoiceLineItem invoiceLineItem : lineItems) {
			temp = lineItems.toString();
		}


		return invoiceHeader.toString() + "\n"
				+	temp + "\n"
				+ "\n_____________THIS IS THE FOOTER__________ \n";
		}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return " Temp for Now ";
	}

}
