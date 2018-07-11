package com.scg.domain;

/**
 * Encapsulates the concept of a non-billable account, such as sick leave,
 * vacation, or business development.
 *
 * @author Russ Moul
 */
public enum NonBillableAccount implements Account {
    /** Sick Leave. */
    SICK_LEAVE("Sick Leave"),
    /** Vacation. */
    VACATION("Vacation"),
    /** Business development. */
    BUSINESS_DEVELOPMENT("Business Development");


    /** The name of this account. */
    private final String friendlyName;

    /**
     * Creates a new instance of NonBillableAccount
     *
     * @param name
     *            the name of this account.
     */
    private NonBillableAccount(final String name) {
        this.friendlyName = name;
    }

    /**
     * Getter for the name of this account.
     * 
     * Not to be confused with the enum name() method.
     *
     * @return the name of this account.
     */
    @Override
    public String getName() {
        return friendlyName;
    }

    /**
     * Determines if this account is billable.
     *
     * @return always false
     *
     */
    @Override
    public boolean isBillable() {
        return false;
    }
    
    /**
     * Returns the friendly name for this enumerated value.
     * 
     * @return the friendly name for this enumerated value
     */
    @Override
	public String toString() {
        return friendlyName;
    }
}
