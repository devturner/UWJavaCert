package com.scg.domain;

import java.util.EventListener;

/**
 * The listener interface for receiving termination events. The class that is
 * interested in processing a termination event implements this interface, and
 * the object created with that class is registered with a component using the
 * component's <code>addTerminationListener<code> method. When
 * the termination event occurs, that object's appropriate
 * method is invoked.
 *
 * @see TerminationEvent
 */
public interface TerminationListener extends EventListener {

	/**
	 * Voluntary termination.
	 *
	 * @param evt
	 *            the evt
	 */
	void voluntaryTermination(TerminationEvent evt);

	/**
	 * Forced termination.
	 *
	 * @param evt
	 *            the evt
	 */
	void forcedTermination(TerminationEvent evt);
}
