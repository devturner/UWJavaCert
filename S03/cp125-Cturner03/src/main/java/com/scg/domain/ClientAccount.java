package com.scg.domain;

import com.scg.util.Address;
import com.scg.util.Name;

/**
 * Encapsulates the information for a billable client account.
 *
 * @author Russ Moul
 */
public final class ClientAccount implements Account, Comparable <ClientAccount> {
    /**
     * Holds value of property name.
     */
    private final String name;

    /**
     * Holds value of property contact.
     */
    private Name contact;

    /** This is the the value of the address */
	private Address address;

    /**
     * Creates a new instance of ClientAccount.
     *
     * @param name String with the name of the client.
     * @param contact Name of the contact person for this client.
     */
    public ClientAccount(final String name, final Name contact) {
        this.name = name;
        this.contact = contact;
    }

    public ClientAccount(final String name, final Name contact, final Address address) {
    	this.name = name;
        this.contact = contact;
        this.address = address;
	}

	/**
     * Gets the account name.
     *
     * @return Value of property name.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets the contact for this account.
     *
     * @return Value of property contact.
     */
    public Name getContact() {
        return this.contact;
    }



    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/**
     * Setter for property contact.
     *
     * @param contact New value of property contact.
     */
    public void setContact(final Name contact) {
        this.contact = contact;
    }

    /**
     * Determines if this account is billable.
     *
     * @return always true
     */
    @Override
    public boolean isBillable() {
        return true;
    }

    //ordering by name, contact, and finally address. Returns a negative integer, zero, or a
    //positive integer as this Client is less than, equal to, or greater than the specified Client.

    @Override
	public int compareTo(ClientAccount other){
	int diff;
	diff = name.compareTo(other.name);
	if(diff == 0){
		diff = contact.compareTo(other.contact);
		if(diff == 0) {
			diff = address.compareTo(other.address);
		}
	}
	return diff;
}





}
