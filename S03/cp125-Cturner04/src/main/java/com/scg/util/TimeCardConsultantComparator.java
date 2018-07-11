package com.scg.util;

import java.io.Serializable;
import java.util.Comparator;

import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;

/**
 * The Class TimeCardConsultantComparator.
 */
public final class TimeCardConsultantComparator implements Comparator<TimeCard> {

	/**
	 * Instantiates a new time card consultant comparator.
	 */
	public TimeCardConsultantComparator() {

	}


	/**
	 * Compares its two arguments for order. Returns a negative integer, zero,
	 * or a positive integer as the first argument is less than, equal to, or
	 * greater than the second.
	 */

	public int compare(TimeCard firstTimeCard, TimeCard secondTimeCard) {
		return firstTimeCard.getConsultant().compareTo(
				secondTimeCard.getConsultant());

	}

}
