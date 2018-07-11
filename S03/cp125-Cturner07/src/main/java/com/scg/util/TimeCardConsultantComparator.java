package com.scg.util;

import java.util.Comparator;

import com.scg.domain.TimeCard;

/**
 * Compares two TimeCard objects by the name of the Consultant.
 *
 * @author Russ Moul
 */
public final class TimeCardConsultantComparator implements Comparator<TimeCard> {
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.<p>
     *
     *
     * @param firstTimeCard the first object to be compared.
     * @param secondTimeCard the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     */
    @Override
    public int compare(final TimeCard firstTimeCard, final TimeCard secondTimeCard) {
        return firstTimeCard.getConsultant().compareTo(secondTimeCard.getConsultant());
    }
}
