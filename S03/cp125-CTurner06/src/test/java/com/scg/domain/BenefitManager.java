package com.scg.domain;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class BenefitManager.
 */
public class BenefitManager implements PropertyChangeListener {

	// private final PropertyChangeSupport pcs = new
	// PropertyChangeSupport(this);

	/**
	 * Instantiates a new benefit manager.
	 */
	public BenefitManager() {

	}

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(BenefitManager.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.
	 * PropertyChangeEvent)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		final String propName = evt.getPropertyName();
		final int oValue = (Integer) evt.getOldValue();
		final int nValue = (Integer) evt.getNewValue();

		log.info(propName + "changed from " + oValue + " to " + nValue
				+ " for " + ((StaffConsultant) evt.getSource()).getName());
	}

}
