package com.scg.domain;

import java.io.Serializable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

import com.scg.util.Name;

/**
 * The Class StaffConsultant.
 */
public final class StaffConsultant extends Consultant implements Serializable {

	/** The vcs. */
	private final VetoableChangeSupport vcs = new VetoableChangeSupport(this);

	/** The pcs. */
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	/** The pay rate property name. */
	static String PAY_RATE_PROPERTY_NAME = "payRate";

	/** The sick leave hours property name. */
	static String SICK_LEAVE_HOURS_PROPERTY_NAME = "sickLeaveHours";

	/** The vacation hours property name. */
	static String VACATION_HOURS_PROPERTY_NAME = "vacationHours";

	/** The pay rate. */
	private int payRate;

	/** The sick leave. */
	private int sickLeave;

	/** The vacation. */
	private int vacation;

	/**
	 * Instantiates a new staff consultant.
	 *
	 * @param name
	 *            the name
	 * @param rate
	 *            the rate
	 * @param sickLeave
	 *            the sick leave
	 * @param vacation
	 *            the vacation
	 */
	public StaffConsultant(Name name, int rate, int sickLeave, int vacation) {
		super(name);
		this.payRate = rate;
		this.sickLeave = sickLeave;
		this.vacation = vacation;
	}

	/**
	 * Adds the pay rate listener.
	 *
	 * @param l
	 *            the l
	 */
	public void addPayRateListener(PropertyChangeListener l) {
		pcs.addPropertyChangeListener(PAY_RATE_PROPERTY_NAME, l);
	}

	/**
	 * Adds the property change listener.
	 *
	 * @param l
	 *            the l
	 */
	public void addPropertyChangeListener(PropertyChangeListener l) {
		pcs.addPropertyChangeListener(l);
	}

	/**
	 * Adds the sick leave hours listener.
	 *
	 * @param l
	 *            the l
	 */
	public void addSickLeaveHoursListener(PropertyChangeListener l) {
		pcs.addPropertyChangeListener(SICK_LEAVE_HOURS_PROPERTY_NAME, l);
	}

	/**
	 * Adds the vacation hours listener.
	 *
	 * @param l
	 *            the l
	 */
	public void addVacationHoursListener(PropertyChangeListener l) {
		pcs.addPropertyChangeListener(VACATION_HOURS_PROPERTY_NAME, l);
	}

	/**
	 * Adds the vetoable change listener.
	 *
	 * @param l
	 *            the l
	 */
	public void addVetoableChangeListener(VetoableChangeListener l) {
		vcs.addVetoableChangeListener(PAY_RATE_PROPERTY_NAME, l);
	}

	/**
	 * Gets the pay rate.
	 *
	 * @return the pay rate
	 */
	public synchronized int getPayRate() {
		return payRate;
	}

	/**
	 * Gets the sick leave.
	 *
	 * @return the sick leave
	 */
	public synchronized int getSickLeave() {
		return sickLeave;
	}

	/**
	 * Gets the vacation.
	 *
	 * @return the vacation
	 */
	public synchronized int getVacation() {
		return vacation;
	}

	/**
	 * Removes the pay rate listener.
	 *
	 * @param l
	 *            the l
	 */
	private void removePayRateListener(PropertyChangeListener l) {
		pcs.removePropertyChangeListener(PAY_RATE_PROPERTY_NAME, l);
	}

	/**
	 * Removes the property change listener.
	 *
	 * @param l
	 *            the l
	 */
	private void removePropertyChangeListener(PropertyChangeListener l) {
		pcs.removePropertyChangeListener(l);
	}

	/**
	 * Removes the sick leave hours listener.
	 *
	 * @param l
	 *            the l
	 */
	private void removeSickLeaveHoursListener(PropertyChangeListener l) {
		pcs.removePropertyChangeListener(SICK_LEAVE_HOURS_PROPERTY_NAME, l);
	}

	/**
	 * Removes the vacation hours listener.
	 *
	 * @param l
	 *            the l
	 */
	private void removeVacationHoursListener(PropertyChangeListener l) {
		pcs.removePropertyChangeListener(VACATION_HOURS_PROPERTY_NAME, l);
	}

	/**
	 * Removes the vetoable change listener.
	 *
	 * @param l
	 *            the l
	 */
	private void removeVetoableChangeListener(VetoableChangeListener l) {
		vcs.removeVetoableChangeListener(PAY_RATE_PROPERTY_NAME, l);
	}

	/**
	 * Sets the pay rate.
	 *
	 * @param payRate
	 *            the new pay rate
	 * @throws PropertyVetoException
	 *             the property veto exception
	 */
	public synchronized void setPayRate(int payRate)
			throws PropertyVetoException {
		this.vcs.fireVetoableChange(PAY_RATE_PROPERTY_NAME, this.payRate,
				payRate);
		int oRate = getPayRate();
		this.payRate = payRate;
		this.pcs.firePropertyChange(PAY_RATE_PROPERTY_NAME, oRate, payRate);
	}

	/**
	 * Sets the sick leave.
	 *
	 * @param sickLeave
	 *            the new sick leave
	 */
	public synchronized void setSickLeave(int sickLeave) {
		int oldSickLeave = getSickLeave();
		this.sickLeave = sickLeave;
		this.pcs.firePropertyChange(SICK_LEAVE_HOURS_PROPERTY_NAME,
				oldSickLeave, sickLeave);
	}

	/**
	 * Sets the vacation.
	 *
	 * @param vacation
	 *            the new vacation
	 */
	public synchronized void setVacation(int vacation) {
		int oldVacation = getVacation();
		this.vacation = vacation;
		this.pcs.firePropertyChange(VACATION_HOURS_PROPERTY_NAME, oldVacation,
				vacation);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + payRate;
		result = prime * result + ((pcs == null) ? 0 : pcs.hashCode());
		result = prime * result + sickLeave;
		result = prime * result + vacation;
		result = prime * result + ((vcs == null) ? 0 : vcs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaffConsultant other = (StaffConsultant) obj;
		if (payRate != other.payRate)
			return false;
		if (pcs == null) {
			if (other.pcs != null)
				return false;
		} else if (!pcs.equals(other.pcs))
			return false;
		if (sickLeave != other.sickLeave)
			return false;
		if (vacation != other.vacation)
			return false;
		if (vcs == null) {
			if (other.vcs != null)
				return false;
		} else if (!vcs.equals(other.vcs))
			return false;
		return true;
	}



}
