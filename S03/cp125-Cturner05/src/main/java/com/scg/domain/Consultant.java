package com.scg.domain;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.util.Name;

// TODO: Auto-generated Javadoc
/**
 * A consultant.
 *
 * @author Russ Moul
 */

public class Consultant implements Serializable, Comparable<Consultant> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -807176607298823891L;




	/** Factor used in calculating hashCode. */
	private static final int HASH_FACTOR = 37;

	/** Holds value of property name. */
	private final Name name;

	/** The hash code value. */
	private final int hashCode;

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger("Consultant");

	/**
	 * Creates a new instance of AbstractConsultant.
	 *
	 * @param name
	 *            the consultant's name.
	 */
	public Consultant(final Name name) {
		this.name = name;

		this.hashCode = calcHashCode();
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
	 *
	 */
	@Override
	public final String toString() {
		return name.toString();
	}

	/**
	 * Calculate the hash code.
	 *
	 * @return the hash code value
	 */
	private int calcHashCode() {
		int hc = Consultant.class.hashCode();
		hc *= HASH_FACTOR + ((name == null) ? 0 : name.hashCode());
		return hc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return hashCode;
	}

	/**
	 * Compare names for equivalence.
	 *
	 * @param other
	 *            the object to compare to
	 *
	 * @return true if all the name elements have the same value
	 */
	@Override
	public boolean equals(final Object other) {
		if (other == null) {
			return false;
		}
		if (this.getClass() != other.getClass()) {
			return false;
		}
		final Consultant o = (Consultant) other;

		return (name == null && o.name == null)
				|| ((name != null && o.name != null) && name.equals(o.name));
	}



	/**
	 * The Class SerializationProxy.
	 */
	private static class SerializationProxy implements Serializable {
		/** The x. */
		private String x;
		/** The y. */
		private String y;
		/** The z. */
		private String z;


		/**
		 * Instantiates a new serialization proxy.
		 *
		 * @param consultant the consultant
		 */
		public SerializationProxy(Consultant consultant) {
			final Name name = consultant.getName();
			x = name.getFirstName();
			y = name.getMiddleName();
			z = name.getLastName();
		}

		/**
		 * Readresolve.
		 *
		 * @return the object
		 */
		@SuppressWarnings("unused")
		private Object readresolve() {
			final String msg = String.format(
					"Deserialized consultant: %s %s %s", x, y, z);
			log.info(msg);
			 return msg;
		}

	}

	/**
	 * Write replace.
	 *
	 * @return the object
	 */
	private Object writeReplace() {
		final String msg = String.format("Serializing consultant: %s", name);
		log.info(msg);
		return this;
	}

	/**
	 * Read object.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unused")
	private void readObject() throws IOException{
		log.info("This requires a proxy.");
	}

//	private void readObject(ObjectInputStream stream) throws InvalidObjectException {
//		throw new InvalidObjectException("Use Serialization Proxy instead.");
//		}

	/**
	 * Compares this Consultant object with the specified object for order.
	 * Returns a negative integer, zero, or a positive integer as this object is
	 * less than, equal to, or greater than the specified object, the consultant
	 * name is used to perform the comparison.
	 * <p>
	 *
	 * @param other the other
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 */
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public final int compareTo(final Consultant other) {
		return name.compareTo(other.name);
	}
}
