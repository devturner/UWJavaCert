package com.scg.domain;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class CompensationManager.
 */
public class CompensationManager implements PropertyChangeListener,
		VetoableChangeListener {

	/** This class' logger. */
	private static Logger log = LoggerFactory
			.getLogger(CompensationManager.class);

	/*
	 * (non-Javadoc)
	 *
	 * @see java.beans.VetoableChangeListener#vetoableChange(java.beans.
	 * PropertyChangeEvent)
	 */
	public void vetoableChange(PropertyChangeEvent evt)
			throws PropertyVetoException {
		if (StaffConsultant.PAY_RATE_PROPERTY_NAME
				.equals(evt.getPropertyName())) {
			int oRate = (Integer) evt.getOldValue();
			int nRate = (Integer) evt.getNewValue();
			Consultant cons = (Consultant) evt.getSource();
			if (oRate * .05 + oRate < nRate) {
				log.info(String
						.format("This pay raise has been rejected for %s, the raise from %d to %d was more than 5%%",
								cons.getName(), oRate, nRate));
				throw new PropertyVetoException(
						"This payRate is greater than a 5% change and has been rejected.",
						evt);
			}
			log.info(String
					.format("This pay raise has been approved for %s, the raise was from %d to %d",
							cons.getName(), oRate, nRate));

		}
	}

	// verify event here. need to make sure that this is
	// StaffConsultanlt.PAY.... .equals(evt.getPropertyName())
	/*
	 * (non-Javadoc)
	 *
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.
	 * PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if (StaffConsultant.PAY_RATE_PROPERTY_NAME
				.equals(evt.getPropertyName())) {
			int oRate = (Integer) evt.getOldValue();
			int nRate = (Integer) evt.getNewValue();
			Consultant cons = (Consultant) evt.getSource();
			log.info(String
					.format("The pay raise has been approved for %s, the raise was from %d to %d",
							cons.getName(), oRate, nRate));

		}
	}

}
