package edu.washington.ext.libraryproject.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edu.washington.ext.libraryproject.controler.CheckInOutException;
import edu.washington.ext.libraryproject.controler.Library;
import edu.washington.ext.libraryproject.controler.LibraryException;
import edu.washington.ext.libraryproject.controler.PatronException;
import edu.washington.ext.libraryproject.model.Binding;
import edu.washington.ext.libraryproject.model.Book;
import edu.washington.ext.libraryproject.model.MediaType;
import edu.washington.ext.libraryproject.model.MovieGenre;
import edu.washington.ext.libraryproject.model.Music;
import edu.washington.ext.libraryproject.model.MusicGenre;
import edu.washington.ext.libraryproject.model.Video;



/**
 * This is the tet class to make sure that the library functions as expected.
 *
 * @author christurner
 *
 */

public class LibraryTest {
	/**
	 * This is the date format formula
	 */
	public DateFormat DF = new SimpleDateFormat("MM/dd/yyyy");
	/** This is a date */
	private Date d1;
	/** This is a date */
	private Date d2;
	/** This is a date */
	private Date d3;
	/** This is a date */
	private Date d4;
	/** This is a testLibrary */
	private Library testLibrary;
	/** This is a test book */
	private Book book1;
	/** This is a test book */
	private Book book2;
	/** This is a test book - its made to be null */
	private Book book3;
	/** This is a test music */
	private Music musicCD;
	/** This is a test video */
	private Video videoDVD;

	/**
	 * This is the setup method for the test cases. I build the media to run
	 * tests off of, I build my test library and I add a patron and a book to
	 * the inventory so I can expect them to be there in any subsequent testing.
	 */
	@Before
	public void setup() {
		try {
			d1 = DF.parse("12/10/2011");
			d2 = DF.parse("03/01/2012");
			d4 = DF.parse("04/01/1975");
			d3 = DF.parse("01/01/2002");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		testLibrary = new Library("Ballard Library");
		book1 = new Book("Python Programming for the Absolute Beginner",
				"Michael Dawson", "Course Technology", d1, Binding.PAPERBACK,
				455);
		book2 = new Book("Core Java2, Volume I - Fundamentals",
				"Horstmann/Cornell", "Manning", d2, Binding.PAPERBACK, 762);
		book3 = new Book(null, null, null, d1, null, 0);
		musicCD = new Music("light & magic", "Ladytron", "emperorNorton", d3,
				MediaType.CD, "Ladytron", MusicGenre.DANCE);
		videoDVD = new Video("Monty Python and the Holy Grail", "Monty Python",
				"Python (Monty) Pictures", d4, MediaType.DVD,
				"Terry Gilliam & Terry Jones", "Python (Monty) Pictures",
				MovieGenre.COMEDY);
		try {
			testLibrary.addPatron("Chris");
		} catch (PatronException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.add(book1);
		} catch (LibraryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is a test to try and add the same user to the library twice.
	 */
	@Test
	public void testAddPatronsFail() {
		try {
			System.out.print("Add same patron 2x fail: ");
			testLibrary.addPatron("Chris");
			fail("Chris is already a member.");
		} catch (PatronException e) {
			// ignore, expected
		}
	}

	/**
	 * This is a test to see if you can a null user to the library.
	 */
	@Test
	public void testAddPatronsFail2() {
		try {
			System.out.print("Add null patron: ");
			testLibrary.addPatron(null);
			fail("Patron must not be null.");
			assertEquals(testLibrary.getLibraryMembers().size(), 7);
		} catch (PatronException e) {
			// ignore, expected
		}
	}

	/**
	 * This is a test to make sure that a no named patron can not be added.
	 */
	@Test
	public void testAddPatronsFail3() {
		try {
			System.out.print("Add noString patron: ");
			testLibrary.addPatron("");
			fail("Patron must not be null.");
			assertEquals(testLibrary.getLibraryMembers().size(), 7);
		} catch (PatronException e) {
			// ignore, expected
		}
	}

	/**
	 * This is a test to make sure that adding patrons to the library works.
	 */
	@Test
	public void testAddPatrons() {
		try {
			testLibrary.addPatron("Fred");
		} catch (PatronException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.addPatron("Sam");
		} catch (PatronException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.addPatron("Frank");
		} catch (PatronException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.addPatron("Beth");
		} catch (PatronException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.addPatron("Ada");
		} catch (PatronException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.addPatron("Harsha");
		} catch (PatronException e) {
			e.printStackTrace();
		}
		assertEquals(testLibrary.getLibraryMembers().size(), 7);
	}

	/**
	 * This is a test to make sure adding a null media fails.
	 */
	@Test(expected = LibraryException.class)
	public void testAddNullMediaFail() throws LibraryException {
		System.out.print("Add null item fail: ");
		testLibrary.add(null);
	}

	/**
	 * This is a test make sure that adding the same media twice to the library
	 * fails.
	 */
	@Test(expected = LibraryException.class)
	public void testAddMediaTwiceFail() throws LibraryException {
		System.out.print("Add the same media 2x fail: ");
		testLibrary.add(book1);
	}

	/**
	 * This is a test make sure that adding media to the library actually works.
	 */
	@Test
	public void testAddMedia() {
		try {
			testLibrary.add(book2);
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.add(musicCD);
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.add(videoDVD);
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		assertEquals(testLibrary.getListOfAllLibraryItems().size(), 4);

	}

	/**
	 * This is a test to remove the media from the library inventory, say a book
	 * goes missing or if it is checked out.
	 */

	@Test
	public void testRemoveMedia() {
		try {
			testLibrary.remove(book1);
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		assertEquals(testLibrary.getListOfAllLibraryItems().size(), 0);
	}

	/**
	 * This is a test to remove an item that was not actually in the library to
	 * begin with.
	 */
	@Test
	public void testRemoveMediaFail() {
		try {
			System.out.print("Remove media fail (never an item): ");
			testLibrary.remove(book2);
			fail("The 'Core Java2, Volume I - Fundamentals' has not been checked out of the library.");
		} catch (LibraryException e) {
			// ignore, expected
		}
	}

	/**
	 * This is a test make sure that you cannot remove a null book from the
	 * library.
	 */
	@Test
	public void testRemoveMediaFail2() {
		try {
			System.out.print("Remove null fail: ");
			testLibrary.remove(book3);
			fail("Error: The item 'null' has not been checked out of the library.");
		} catch (LibraryException e) {
			// ignore, expected
		}
	}

	/**
	 * This is a test ensure that you can remove a patron from the library
	 * system.
	 */
	@Test
	public void testPatronRemoval() {
		try {
			testLibrary.addPatron("Ada");
		} catch (PatronException e1) {
			e1.printStackTrace();
		}
		try {
			assertEquals(testLibrary.removePatron(1), true);
		} catch (PatronException e) {
			e.printStackTrace();
		}
		try {
			assertEquals(testLibrary.removePatron(2), true);
		} catch (PatronException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This is a test to make sure that you cannot remove a patron from the
	 * library that is not a member.
	 */
	@Test
	public void testPatronRemovalFail() {
		try {
			System.out.print("Patron removal fail: ");
			testLibrary.removePatron(2);
			fail("Error: There is no user with ID '2'.");
		} catch (PatronException e) {
			// ignore, expected.
		}

	}

	/**
	 * This is a test to ensure that you cannot remove a patron from the library
	 * that is not a member(member with a negative number).
	 */
	@Test
	public void testPatronRemovalFail2() {
		try {
			System.out.print("Patron removal fail: ");
			testLibrary.removePatron(-6);
			fail("Error: There is no user with ID '-6'.");
		} catch (PatronException e) {
			// e.printStackTrace();
		}
	}

	/**
	 * This test tries to remove a null patron id.
	 */
	@Test
	public void testPatronRemovalFail3() {
		try {
			System.out.print("Patron null removal fail: ");
			testLibrary.removePatron(0);
			fail("Error: There is no user with ID '0'.");
		} catch (PatronException e) {
			// ignore, expected.
		}

	}
	/**
	 * This tests gets the checked out items list. Also, it ensures that once a
	 * book is checked out, it is no longer counted in the inventory.
	 */
	@Test
	public void testGetCheckOutItem() {
		try {
			testLibrary.checkout(book1, 1);
			assertEquals(testLibrary.getCheckedOutItems().size(), 1);
			assertEquals(testLibrary.getListOfAllLibraryItems().size(), 0);
		} catch (CheckInOutException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This test attempts to check out a null book to a patron that is not in
	 * the library. It fails.
	 */
	@Test
	public void testCheckOutItemFail() {
		try {
			System.out.print("CheckOut item fail #1: ");
			testLibrary.checkout(book3, 2);
			fail("Error: Neither the item 'null', nor the member with ID# '2' has been found.");
		} catch (CheckInOutException e) {
			// ignore, expected
		}
	}

	/**
	 * This test attempts to checkout a legit book to a non-patron. It fails.
	 */
	@Test
	public void testCheckOutItemFail2() {
		try {
			System.out.print("CheckOut item fail #2: ");
			testLibrary.checkout(book1, 0);
			fail("Error: There is no member with ID# '0'.");
		} catch (CheckInOutException e) {
			// ignore, expected
		}
	}

	/**
	 * This test attempts to checkout a null item to a legit user. it fails.
	 */
	@Test
	public void testCheckOutItemFail3() {
		try {
			System.out.print("CheckOut item fail #3: ");
			testLibrary.checkout(book3, 1);
			fail("Error: The item 'null' is not found, and was not be checked out.");
		} catch (CheckInOutException e) {
			// ignore, expected
		}
	}

	/**
	 * This test confirms that things can be checked out.
	 */
	@Test
	public void testIsCheckedOut() {
		try {
			testLibrary.checkout(book1, 1);
			assertEquals(testLibrary.isCheckout(book1), true);
		} catch (CheckInOutException e) {
			// e.printStackTrace();
		}
	}

	/**
	 * This test shows that you can not confirm something is checked out if it
	 * has not been checked out.
	 */
	@Test
	public void testIsCheckedOutFail() {
		try {
			System.out
					.print("Checked out item failed (item never checked out): ");
			assertEquals(testLibrary.isCheckout(book2), false);
		} catch (CheckInOutException e) {
			// ignore, expected
		}
	}

	/**
	 * This test shows that the get library members function works and returns
	 * the correct number of users.
	 */
	@Test
	public void testGetLibraryMembers() {
		try {
			testLibrary.addPatron("Fred");
		} catch (PatronException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.addPatron("Sam");
		} catch (PatronException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.addPatron("Frank");
		} catch (PatronException e) {
			e.printStackTrace();
		}
		assertEquals(testLibrary.getLibraryMembers().size(), 4);
	}

	/**
	 * This test shows that the checkIn method works. and that when something is
	 * checked in to the library, it is added back to the library items list.
	 */
	@Test
	public void testCheckin() {
		try {
			testLibrary.add(musicCD);
			assertEquals(testLibrary.getListOfAllLibraryItems().size(), 2);
		} catch (LibraryException e) {
			e.printStackTrace();
		}
		try {
			testLibrary.checkout(musicCD, 1);
			assertEquals(testLibrary.getCheckedOutItems().size(), 1);
		} catch (CheckInOutException e2) {
			e2.printStackTrace();
		}
		try {
			testLibrary.checkin(musicCD);
			assertEquals(testLibrary.getCheckedOutItems().size(), 0);
			assertEquals(testLibrary.getListOfAllLibraryItems().size(), 2);
		} catch (CheckInOutException e3) {
			e3.printStackTrace();
		}
		try {
			testLibrary.checkout(book1, 1);
			assertEquals(testLibrary.getCheckedOutItems().size(), 1);
			assertEquals(testLibrary.getListOfAllLibraryItems().size(), 1);
		} catch (CheckInOutException e4) {
			e4.printStackTrace();
		}
	}

	/**
	 * This test makes sure that you can not check in something that was not checked out.
	 */
	@Test
	public void testCheckinFail() {
		try {
			System.out.print("Checkin item fail: ");
			testLibrary.checkin(musicCD);
			assertEquals(testLibrary.getListOfAllLibraryItems().size(),1);
		} catch (CheckInOutException e) {
			// ignore, expected
		}
	}
	/**
	 * This test makes sure that you can not check in something that is null.
	 */
	@Test
	public void testCheckinFail2Null() {
		try {
			System.out.print("Checkin item fail: ");
			testLibrary.checkin(null);
		} catch (CheckInOutException e) {
			// ignore, expected
		}
	}
	/**
	 * This tests the getter to see how many items the library has in its list.
	 */
	@Test
	public void testGetListOfAllLibraryItems() {
		assertEquals(testLibrary.getListOfAllLibraryItems().size(), 1);
	}

}
