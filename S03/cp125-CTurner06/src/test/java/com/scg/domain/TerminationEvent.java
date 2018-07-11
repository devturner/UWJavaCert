package com.scg.domain;

import java.util.EventObject;

/**
 * The Class TerminationEvent.
 */
@SuppressWarnings("serial")
public final class TerminationEvent extends EventObject {

	/** The voluntary. */
	private boolean voluntary;

	/** The consultant. */
	private Consultant consultant;

	/**
	 * Instantiates a new termination event.
	 *
	 * @param source
	 *            the source
	 * @param consultant
	 *            the consultant
	 * @param voluntary
	 *            the voluntary
	 */
	public TerminationEvent(Object source, Consultant consultant,
			boolean voluntary) {
		super(source);
		this.consultant = consultant;
		this.voluntary = voluntary;
	}

	/**
	 * Gets the consultant.
	 *
	 * @return the consultant
	 */
	public Consultant getConsultant() {
		return consultant;
	}

	/**
	 * Checks if is voluntarty.
	 *
	 * @return true, if is voluntarty
	 */
	public boolean isVoluntarty() {
		return voluntary;
	}

}
