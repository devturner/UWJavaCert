package com.scg.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;

// TODO: Auto-generated Javadoc
/**
 * The Class TimeCardListUtil.
 */
public final class TimeCardListUtil {

	/** The Constant DAYS_PER_WEEK. */
	private static final int DAYS_PER_WEEK = 6;

	/** The consultant comparator. */
	private static TimeCardConsultantComparator consultantComparator = new TimeCardConsultantComparator();

	/**
	 * Instantiates a new time card list util.
	 */
	private TimeCardListUtil(){

	}

	// Sorts this list into ascending order, by the start date.
	/**
	 * Sort by start date.
	 *
	 * @param timeCards the time cards
	 */
	public static void sortByStartDate(List<TimeCard> timeCards) {
		Collections.sort(timeCards);
	}

	/*
	 * Collections.sort(movieItems, new Comparator<Movie>() { public int
	 * compare(Movie m1, Movie m2) { return m1.getDate().compare(m2.getDate());
	 * } });
	 */




	// Sorts this list into ascending order by consultant name.
	/**
	 * Sort by consultant name.
	 *
	 * @param timeCards the time cards
	 */
	public static void sortByConsultantName(List<TimeCard> timeCards) {
		Collections.sort(timeCards, consultantComparator);
	}

	// Get a list of TimeCards that cover dates that fall within a date range.
	// Each time
	// may have time entries through out one week beginning with the time card
	// start date.
	/**
	 * Gets the time cards for date range.
	 *
	 * @param timeCards the time cards
	 * @param dateRange the date range
	 * @return the time cards for date range
	 */
	public static List<TimeCard> getTimeCardsForDateRange(List<TimeCard> timeCards, DateRange dateRange) {
		final List<TimeCard> returnList = new ArrayList<TimeCard>();
		for(final TimeCard currentTimeCard : timeCards){
			final Date startDate = currentTimeCard.getWeekStartingDay();
			final Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			cal.add(Calendar.DATE, DAYS_PER_WEEK);
			final Date timeCardEndDate = cal.getTime();

			if(dateRange.isInRange(startDate) || dateRange.isInRange(timeCardEndDate)){
				returnList.add(currentTimeCard);
			}
		}
		return returnList;
	}

	//add a break somewhere

	// Get a list of TimeCards for the specified consultant.
	/**
	 * Gets the time cards for consultant.
	 *
	 * @param timeCards the time cards
	 * @param consultant the consultant
	 * @return the time cards for consultant
	 */
	public static List<TimeCard> getTimeCardsForConsultant(
			List<TimeCard> timeCards, Consultant consultant) {
		final List<TimeCard> returnList = new ArrayList<TimeCard>();
		for (final TimeCard currentTimeCard : timeCards){
			if(currentTimeCard.getConsultant().equals(consultant)){
				returnList.add(currentTimeCard);
			}
		}
		return returnList;
	}

}
