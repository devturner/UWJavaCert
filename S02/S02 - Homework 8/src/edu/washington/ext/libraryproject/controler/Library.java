package edu.washington.ext.libraryproject.controler;

import edu.washington.ext.libraryproject.common.LibraryItem;
import edu.washington.ext.libraryproject.model.Patron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This is the library class, it is responsible for most of the code and the
 * functions of the library.
 *
 * @author chris turner
 *
 */

public class Library {
	/** This is the list of all the items that the library has in stock */
	private List<LibraryItem> items = new ArrayList<LibraryItem>();
	/** This is the map of all the library members */
	private Map<Integer, Patron> patrons = new HashMap<Integer, Patron>();
	/** This is the map of all the checked out items from the library */
	private Map<Integer, LibraryItem> checkedOutItems = new HashMap<Integer, LibraryItem>();
	/** This is the name of the branch */
	private String branch = null;

	/**
	 * Constructor, makes the instance of the library
	 *
	 * @param branch
	 *            what this library branch is called
	 */
	public Library(String branch) {
		super();
		this.branch = branch;
	}

	/**
	 * Adds a library item to the items list
	 *
	 * @param item
	 *            what is being added
	 * @throws LibraryException
	 *             this is thrown if a null item is added, also if an item
	 *             already exists
	 */
	public void add(LibraryItem item) throws LibraryException {
		if (item == null) {
			throw new LibraryException("Error: Invalid item, must not be null.");
		}
		if (items.contains(item)) {
			throw new LibraryException(
					"Error: This item already exists in the library.");
		} else {
			items.add(item);
		}
	}

	/**
	 * This removes an item from the items list
	 *
	 * @param item
	 *            what to remove
	 * @throws LibraryException
	 *             this is thrown if the requested item is not in the list
	 */
	public void remove(LibraryItem item) throws LibraryException {
		if (!items.contains(item)) {
			throw new LibraryException(item);
		}
		if (item == null) {
			throw new LibraryException("Error: Invalid item, must not be null.");
		} else {
			items.remove(item);
			// System.out.println("The item was removed.");
		}
	}

	/**
	 * This tests the HashMap for possible duplicates when adding new members
	 * against existing members
	 *
	 * @param name
	 *            the new member trying to be added
	 * @return boolean value if the person is already a member or not
	 */
	public boolean getPatronObjectsName(String name) {
		boolean test = false;
		Iterator<Map.Entry<Integer, Patron>> iterator = patrons.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Patron> patrons = iterator.next();
			if (name == patrons.getValue().getName()) {
				test = true;
			}
		}
		return test;
	}

	// private boolean getPatronObjectsName2(int libraryCardNumber) {
	// boolean test = false;
	// Iterator<Map.Entry<Integer, Patron>> iterator = patrons.entrySet()
	// .iterator();
	// while (iterator.hasNext()) {
	// Map.Entry<Integer, Patron> patrons = iterator.next();
	// if (libraryCardNumber == patrons.getValue().getCardNumber()) {
	// test = true;
	// }
	// }
	// return test;
	// }
	//
	// private Patron getPatron(int libraryCardNumber) {
	// Patron tPatron = null;
	// Iterator<Map.Entry<Integer, Patron>> iterator = patrons.entrySet()
	// .iterator();
	// while (iterator.hasNext()) {
	// Map.Entry<Integer, Patron> patrons = iterator.next();
	// if (libraryCardNumber == patrons.getValue().getCardNumber()) {
	// tPatron = (Patron) patrons;
	// }
	// }
	// return tPatron;
	// }

	/**
	 * Adds new patrons and returns library number
	 *
	 * @param name
	 *            of patron
	 * @return library card number
	 * @throws PatronException
	 *             is thrown if if there is a duplicate name in the map
	 */
	public int addPatron(String name) throws PatronException {
		int count = patrons.size();
		count += 1;
		Patron patron = new Patron(name, count);
		if (getPatronObjectsName(name) || (name == null) || (name == "")) {
			throw new PatronException(patron);
		} else {
			patrons.put(count, patron);
		}
		return patrons.size();
	}

	/**
	 * Removes patrons and returns whether or not the patron was removed
	 *
	 * @param libraryCardNumber
	 *            how to know who to remove
	 * @return boolean value true if the patron was removed, false if the patron
	 *         was not found
	 * @throws PatronException
	 *             is thrown if the patron was not found
	 */
	public boolean removePatron(int libraryCardNumber) throws PatronException {
		boolean removed = false;
		if (!patrons.containsKey(libraryCardNumber)) {
			throw new PatronException(libraryCardNumber);
		} else {
			patrons.remove(libraryCardNumber);
			removed = true;
		}
		return removed;
	}

	/**
	 * Checks out a a library item based on the patrons card number
	 *
	 * @param item
	 *            what to check out
	 * @param libraryCardNumber
	 *            patrons ID number
	 * @throws CheckInOutException
	 *             is thrown if the item is not found; or the patron is not
	 *             found
	 */
	public void checkout(LibraryItem item, int libraryCardNumber)
			throws CheckInOutException {
		if (!items.contains(item) && !patrons.containsKey(libraryCardNumber)) {
			throw new CheckInOutException(item, libraryCardNumber);
		}
		if (!items.contains(item)) {
			throw new CheckInOutException(item);
		}
		if (!patrons.containsKey(libraryCardNumber)) {
			throw new CheckInOutException(libraryCardNumber);
		} else {
			checkedOutItems.put(libraryCardNumber, item);
			items.remove(item);
		}
	}

	/**
	 * Checks to see if an item has been checked out
	 *
	 * @param item
	 *            what to check
	 * @return true or false if item is checked out
	 * @throws CheckInOutException
	 *             thrown if the item does not exist
	 */
	public boolean isCheckout(LibraryItem item) throws CheckInOutException {
		boolean checkedOut = false;
		if (!checkedOutItems.containsValue(item)) {
			throw new CheckInOutException("The book: '" + item.getTitle()
					+ "' was not checked out.");
		} else {
			// System.out.println("The item '" + item.getTitle()
			// + "' was checked out.");
			checkedOut = true;
		}
		return checkedOut;
	}

	/**
	 * This checks an item back into the library
	 *
	 * @param item
	 *            what's being checked in
	 * @throws CheckInOutException
	 *             thrown if item does not exist or the item is already checked
	 *             in (includes item and reason for error)
	 */

	public void checkin(LibraryItem item) throws CheckInOutException {
		if (items.contains(item)) {
			throw new CheckInOutException("Error: The item '" + item.getTitle()
					+ "' has not been checked out, and cannot be checked in.");
		}
		if (item == null) {
			throw new CheckInOutException("Item is null.");
		} else {
			int tempKey = 0;
			Iterator<Entry<Integer, LibraryItem>> iterator = checkedOutItems
					.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Integer, LibraryItem> checked = iterator.next();
				if (checked.getValue().equals(item)) {
					tempKey = checked.getKey();
				}
				checkedOutItems.remove(tempKey);
				items.add(item);
			}
		}
	}

	/**
	 * This creates a list of the library members card numbers list of every
	 * library card number.
	 *
	 * @return the library members name and their library number
	 */

	public List<Integer> getLibraryMembers() {
		List<Integer> lMemberIDs = new ArrayList<Integer>(patrons.keySet());
		return lMemberIDs;
	}

	/**
	 * This gets the libraries checked out items as a list
	 *
	 * @return returns the list of items checked out
	 */

	public List<LibraryItem> getCheckedOutItems() {
		List<LibraryItem> lCheckedOutItems = new ArrayList<LibraryItem>();
		Iterator<Map.Entry<Integer, LibraryItem>> iterator = checkedOutItems
				.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, LibraryItem> checked = iterator.next();
			lCheckedOutItems.add(checked.getValue());
		}
		return lCheckedOutItems;
	}

	/**
	 * Gets the full list of all the items that the library has
	 *
	 * @return the list of items
	 */
	public List<LibraryItem> getListOfAllLibraryItems() {
		return items;
	}
}
