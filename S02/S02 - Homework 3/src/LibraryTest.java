
import org.junit.Test;

/*
 *
 * @author Chris Turner
 * Date: October 16, 2014
 */

public class LibraryTest {

	/**
	 * This calls the constructor and sets up the hashmap.
	 */
	Library library = new Library();

	@Test
	public void printTest() {
		addSomeEntries();
		printSomeEntries();
		returnSomeItems();
		printSomeEntries();
	}

	/**
	 * This checks out some books with an ISBN and a Patron, or many patrons --
	 * I added the args so that I could see verargs work the way it is supposed
	 * to.
	 */

	void addSomeEntries() {
		library.checkoutBook("000", "Cay Horstman", "CHRIS", "Ada");
		library.checkoutBook("000", "Sharron Morrow", "Bob Saget");
		library.checkoutBook("001", "Julie Hill");
		library.checkoutBook("001", "Gayle Walker");
		library.checkoutBook("001", "Ada");
		library.checkoutBook("002", "Jimmy Dean");
		library.checkoutBook("002", "Sherry Crow");
		library.checkoutBook("002", "Ada");
		library.checkoutBook("032", "Harsha V");
		library.checkoutBook("7802", "Ada Liu");
		library.checkoutBook("7802", "Ada");
		library.checkoutBook("652", "Francis");
		library.checkoutBook("000", "My Cat");
	}

	/**
	 * This prints the checked out books by ISBN. And I added a line to print
	 * out all of the checked out books.
	 */

	void printSomeEntries() {
		library.printCheckoutBooksByIsbn("000");
		library.printCheckoutBooksByIsbn("001");
		library.printCheckoutBooksByIsbn("002");
		library.printCheckoutBooksByIsbn("032");
		library.printAllCheckoutBooks();
	}

	/**
	 * This is to test the return books method.
	 */

	void returnSomeItems() {
		library.returnBook("000", "CHRIS");
		library.returnBook("000", "Bob Saget");
		library.returnBook("000", "Ada");
		library.returnBook("001", "Ada Liu");
		library.returnBook("000", "Sharron Morrow");
		library.returnBook("000", "Cay Horstman");
		library.returnBook("001", "Gayle Walker");
		library.returnBook("001", "Julie Hill");
		library.returnBook("001", "Red Bike");
		library.returnBook("002", "Sherry Crow");
		library.returnBook("002", "Jimmy Dean");
		library.returnBook("032", "Harsha V");
		library.returnBook("7802", "Ada Liu");

	}

	void printSomeEntriesAgain() {
		library.printCheckoutBooksByIsbn("001");
		library.printAllCheckoutBooks();
	}
}
