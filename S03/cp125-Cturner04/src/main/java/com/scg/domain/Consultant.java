package com.scg.domain;

import com.scg.util.Name;

// TODO: Auto-generated Javadoc
/**
 * A consultant.
 *
 * @author Russ Moul
 */
public class Consultant implements Comparable<Consultant>{

    /** Holds value of property name. */
    private final Name name;

    /**
     * Creates a new instance of Consultant.
     *
     * @param name the consultant's name.
     */
    public Consultant(final Name name) {
        this.name = name;
    }

    /**
     * Getter for property name.
     *
     * @return Value of property name.
     *
     */
    public final Name getName() {
        return this.name;
    }

    /**
     * Returns the string representation of the consultant's name.
     *
     * @return the consultant name string
     */
    @Override
    public final String toString() {
        return name.toString();
    }


    /**
     * This is the compare to method, it compares the consultant names.
     */
	@Override
	public int compareTo(Consultant otherConsultant) {
		return name.toString().compareTo(otherConsultant.getName().toString());
		}
}
