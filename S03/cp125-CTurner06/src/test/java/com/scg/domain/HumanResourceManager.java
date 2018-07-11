package com.scg.domain;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeSupport;
import java.util.EventListener;

import javax.swing.event.EventListenerList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class HumanResourceManager.
 */
public final class HumanResourceManager {

	/** The pcs. */
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	// add to and remove from this.
	/** The listener list. */
	private final EventListenerList listenerList = new EventListenerList();

	// private final TerminationEvent termEvent = new
	// TerminationEvent(termEvent, null, false);

	/** The evl. */
	private final EventListener evl = new EventListener() {
	};

	/** The log. */
	private static Logger log = LoggerFactory
			.getLogger(HumanResourceManager.class);

	/**
	 * Instantiates a new human resource manager.
	 */
	public HumanResourceManager() {
	}

	/**
	 * Adjust pay rate.
	 *
	 * @param c
	 *            the c
	 * @param newPayRate
	 *            the new pay rate
	 */
	public void adjustPayRate(StaffConsultant c, int newPayRate) {
		int oRate = c.getPayRate();
		try {
			if (log.isInfoEnabled()) {
				c.setPayRate(newPayRate);
				log.info(String.format(
						"This was approved, the new payrate is %d", newPayRate));
			}
		} catch (PropertyVetoException e) {
			log.info(String.format(
					"This was not approved, the rate remains %d", oRate));
		}
	}

	/**
	 * Accept resignation.
	 *
	 * @param c
	 *            the c
	 */
	public void acceptResignation(Consultant c) {
		fireTerminationEvent(new TerminationEvent(this, c, true));
	}

	/**
	 * Terminate.
	 *
	 * @param c
	 *            the c
	 */
	public void terminate(Consultant c) {
		fireTerminationEvent(new TerminationEvent(this, c, false));
	}

	/**
	 * Fire termination event.
	 *
	 * @param evnt
	 *            the evnt
	 */
	public void fireTerminationEvent(TerminationEvent evnt) {
		TerminationListener[] listeners;
		listeners = listenerList.getListeners(TerminationListener.class);
		for (final TerminationListener listener : listeners) {
			if (evnt.isVoluntarty()) {
				listener.voluntaryTermination(evnt);
			} else {
				listener.forcedTermination(evnt);
			}
		}

	}

	// Object source, Consultant consultant, boolean voluntary
	/**
	 * Adds the termination listener.
	 *
	 * @param l
	 *            the l
	 */
	public void addTerminationListener(final TerminationListener l) {
		listenerList.add(TerminationListener.class, l);
	}

	/**
	 * Removes the termination listener.
	 *
	 * @param l
	 *            the l
	 */
	public void removeTerminationListener(TerminationListener l) {
		listenerList.remove(TerminationListener.class, l);
	}

	/**
	 * Adjust sick leave hours.
	 *
	 * @param staffConsultant
	 *            the staff consultant
	 * @param hours
	 *            the hours
	 */
	public void adjustSickLeaveHours(StaffConsultant staffConsultant, int hours) {
		staffConsultant.setSickLeave(hours);

	}

	/**
	 * Adjust vacation hours.
	 *
	 * @param staffConsultant
	 *            the staff consultant
	 * @param testVacationHours
	 *            the test vacation hours
	 */
	public void adjustVacationHours(StaffConsultant staffConsultant,
			int testVacationHours) {
		staffConsultant.setVacation(testVacationHours);
	}

}
