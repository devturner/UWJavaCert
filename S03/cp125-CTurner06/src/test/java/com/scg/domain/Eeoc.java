package com.scg.domain;

import java.util.EventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class Eeoc.
 */
public final class Eeoc implements TerminationListener, EventListener {

	/** The voluntary term count. */
	private int vTermCount = 0;

	/** The involuntary term count. */
	private int iVTermCount = 0;

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(Eeoc.class);

	/**
	 * Instantiates a new eeoc.
	 */
	public Eeoc() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.scg.domain.TerminationListener#voluntaryTermination(com.scg.domain
	 * .TerminationEvent)
	 */
	public void voluntaryTermination(TerminationEvent evt) {
		Consultant cons = (Consultant) evt.getConsultant();
		log.info(cons.getName() + " has quit the company.");
	}

	/**
	 * Forced termination count.
	 *
	 * @return the int
	 */
	public int forcedTerminationCount() {
		return iVTermCount++;
	}

	/**
	 * Voluntary termination count.
	 *
	 * @return the int
	 */
	public int voluntaryTerminationCount() {
		return vTermCount++;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.scg.domain.TerminationListener#forcedTermination(com.scg.domain.
	 * TerminationEvent)
	 */
	@Override
	public void forcedTermination(TerminationEvent evt) {
		Consultant cons = (Consultant) evt.getConsultant();
		log.info(cons.getName() + " has been fired.");
	}

}
