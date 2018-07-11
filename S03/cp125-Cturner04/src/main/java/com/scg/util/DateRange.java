package com.scg.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The Class DateRange.
 */
public final class DateRange {

	/** The start calendar. */
	private Calendar startCalendar;

	/** The end calendar. */
	private Calendar endCalendar;

	/** The start date. */
	private Date startDate;

	/** The end date. */
	private Date endDate;

	/**
	 * Instantiates a new date range based on the dates given.
	 *
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 */
	public DateRange(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		// startCalendar = Calendar.getInstance();
		// this.startCalendar.setTime(startDate);
		// endCalendar = Calendar.getInstance();
		// this.endCalendar.setTime(endDate);
	}

	/**
	 * Instantiates a new date range from strings.
	 *
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 */
	public DateRange(String start, String end) {
		String targetS = start;
		DateFormat dfS = new SimpleDateFormat("MM/dd/yyyy");
		Date resultS = null;
		try {
			resultS = dfS.parse(targetS);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		String targetE = end;
		DateFormat dfE = new SimpleDateFormat("MM/dd/yyyy");
		Date resultE = null;
		try {
			resultE = dfE.parse(targetE);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.startDate = resultS;
		this.endDate = resultE;
	}

	/**
	 * Instantiates a new date range by int's.
	 *
	 * @param month
	 *            the month
	 * @param year
	 *            the year
	 */
	public DateRange(int month, int year) {
		// Create a calendar with today's date.
		final Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE,
				calendar.getActualMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND,
				calendar.getActualMinimum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND,
				calendar.getActualMinimum(Calendar.MILLISECOND));
		this.startDate = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR_OF_DAY,
				calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE,
				calendar.getActualMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND,
				calendar.getActualMaximum(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND,
				calendar.getActualMaximum(Calendar.MILLISECOND));
		this.endDate = calendar.getTime();
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
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Gets the start calendar.
	 *
	 * @return the start calendar
	 */
	public Calendar getStartCalendar() {
		return startCalendar;
	}

	/**
	 * Gets the end calendar.
	 *
	 * @return the end calendar
	 */
	public Calendar getEndCalendar() {
		return endCalendar;
	}

	/**
	 * Checks if date is in a range of the start and end dates. Returns true if
	 * the specified date is within the range start date <= date <= end date.
	 *
	 * @param date
	 *            the date
	 * @return true, if is in range
	 */
	public boolean isInRange(Date date) {
		return !((date.before(startDate)) || (date.after(endDate)));

	}
}
