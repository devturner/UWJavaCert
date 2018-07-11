package com.scg.domain;

import java.util.Date;
import java.util.Formatter;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceLineItem.
 */
public class InvoiceLineItem {

	/** The date. */
	private Date date;

	/** The consultant. */
	private Consultant consultant;

	/** The skill. */
	private Skill skill;

	/** The hours. */
	private int hours;

	/** The charge. */
	private int charge;

	/**
	 * Instantiates a new invoice line item.
	 *
	 * @param date the date
	 * @param consultant the consultant
	 * @param skill the skill
	 * @param hours the hours
	 */
	public InvoiceLineItem(final Date date, final Consultant consultant, final Skill skill,
			final int hours) {
		this.date = date;
		this.consultant = consultant;
		this.skill = skill;
		this.hours = hours;
		if(hours < 0){
			throw new IllegalArgumentException("The hours worked must be greater than zero.");
		}
		else {this.charge = hours * skill.getRate();}
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
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
	 * Gets the skill.
	 *
	 * @return the skill
	 */
	public Skill getSkill() {
		return skill;
	}

	/**
	 * Gets the hours.
	 *
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		Formatter fmtr = new Formatter();
		String dateDisplay = "home";
		dateDisplay = fmtr.format("%1$tm/%1$td/%1$tY", date).toString();

		return dateDisplay +  "    " + consultant + "   " + skill  +"   "+  hours +"       "  + charge + "\n";

	}







}
