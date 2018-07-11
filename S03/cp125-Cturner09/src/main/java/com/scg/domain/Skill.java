package com.scg.domain;

// TODO: Auto-generated Javadoc
/**
 * Encapsulates the concept of a billable skill.
 */
public enum Skill {
    /** Project manager skill. */
    PROJECT_MANAGER("Project Manager", 250),
    /** Architect skill. */
    SYSTEM_ARCHITECT("System Architect", 200),
    /** Engineer skill. */
    SOFTWARE_ENGINEER("Software Engineer", 150),
    /** Tester skill. */
    SOFTWARE_TESTER("Software Tester", 100),
    /** Unknown skill. */
    UNKNOWN_SKILL("Unknown Skill", 0);

    /** Holds value of property name. */
    private String friendlyName;

    /** Holds value of property rate. */
    private int rate;

    /**
     * Creates a new instance of Skill.
     *
     * @param name Skill name.
     * @param rate The billing rate.
     */
    private Skill(final String name, final int rate) {
        this.friendlyName = name;
        this.rate = rate;
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

    /**
     * Getter for property rate.
     *
     * @return Value of property rate.
     */
    public int getRate() {
        return this.rate;
    }
}
