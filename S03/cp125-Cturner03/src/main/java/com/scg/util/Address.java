package com.scg.util;

import java.util.Locale;

// TODO: Auto-generated Javadoc
/**
 * The Class Address.
 */
public class Address implements Comparable <Address>{

	/** The street number. */
	private final String streetNumber;

	/** The city. */
	private final String city;

	/** The state. */
	private final StateCode state;

	/** The postal code. */
	private final String postalCode;

	/**
	 * Instantiates a new address.
	 *
	 * @param streetNumber the street number
	 * @param city the city
	 * @param state the state
	 * @param postalCode the postal code
	 */
	public Address(String streetNumber, String city, StateCode state, String postalCode){
		this.streetNumber = streetNumber;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	/**
	 * Gets the street number.
	 *
	 * @return the street number
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public StateCode getState() {
		return state;
	}

	/**
	 * Gets the postal code.
	 *
	 * @return the postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((streetNumber == null) ? 0 : streetNumber.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (state != other.state)
			return false;
		if (streetNumber == null) {
			if (other.streetNumber != null)
				return false;
		} else if (!streetNumber.equals(other.streetNumber))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		return String.format(Locale.US, "%s%n%s, %s %s", streetNumber, city, state, postalCode);
	}


	//Orders by state, postalCode, city and streetNumber.
	public int compareTo(Address other){
	int diff;
	diff = state.compareTo(other.state);
	if(diff == 0){
		diff = postalCode.compareTo(other.postalCode);
		if(diff == 0) {
			diff = city.compareTo(other.city);
			if(diff==0) {
				diff = streetNumber.compareTo(other.streetNumber);
			}
		}
	}
	return diff;
}


}
