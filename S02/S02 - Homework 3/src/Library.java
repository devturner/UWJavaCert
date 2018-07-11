import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/*
 *
 * @author Chris Turner Date: October 16, 2014
 */

/**
 * To complete the Library class you will need to:
 *
 * X - 1. Add the appropriate import statements.
 *
 * X - 2. Complete the declaration of the checkoutBooks HashMap. Use generics to
 * specify the key and value types. In this case, the key is isbn number of book
 * and value is an list of 1 or more patrons that have borrowed this book.
 *
 * X - 3. Implement the constructor to initialize the HashMap.
 *
 * X - 4. Implement the checkoutBook(String,String) method. This is an isbn for
 * book and one patron thats checking it out
 *
 * X - 5. Define and implement the checkoutBook(String, String variable argument
 * list) method declaration and implement the method. This is an isbn for a book
 * and any number of patrons that are checking it out.
 *
 * X - 6. Define and Implement the returnBook(String,String) method. Is isbn for
 * book and person return the book
 *
 * X - 7. Define and Implement the printCheckoutBooksByIsbn(String) method by
 * isbn number only
 *
 * X - 8. Optional, Define and implement printAllCheckoutBooks() method
 */

class Library {

	/**
	 * All checked out Books are stored in this map. The HashMap has a String
	 * key for the isbn and the data is an ArrayList of Strings with patron's
	 * name
	 */

	private HashMap<String, ArrayList<String>> checkoutBooks;

	/**
	 * Constructor, initializes the entries HashMap.
	 */

	Library() {
		checkoutBooks = new HashMap<String, ArrayList<String>>();
	}

	/**
	 * add isbn book checked out to patron - Iterates the arguments down to just
	 * one at a time. Checks the value of an ISBN and if its null it creates a
	 * new arraylist. Then adds the arg to the list. If ISBN is not null it adds
	 * the arg to the existing array
	 *
	 * @param isbn
	 *            -this is the book number for the checked out book
	 * @param args
	 *            -this is the person or people that are checking out the book,
	 *            stored in the arraylist.
	 */

	public void checkoutBook(String isbn, String... args) {
		for (String arg : args) {
			if (checkoutBooks.get(isbn) == null) {
				checkoutBooks.put(isbn, new ArrayList<String>());
				checkoutBooks.get(isbn).add(arg);
			} else {
				checkoutBooks.get(isbn).add(arg);
			}
		}
	}

	/**
	 * prints who has checked out a book based on the ISBN.
	 *
	 * @param string
	 *            - this string contains the book number - ISBN
	 */
	public void printCheckoutBooksByIsbn(String string) {
		System.out.println();
		for (Entry<String, ArrayList<String>> entry : checkoutBooks.entrySet()) {
			if (entry.getKey().equals(string)) {
				System.out.print("Book " + entry.getKey()
						+ " has been checked out by: ");
				for (String patron : entry.getValue()) {
					System.out.print(patron + ", ");
					System.out.println();
				}
			}
		}
	}

	/**
	 * This checks books back into the library based to the ISBN and the patrons
	 * name. Also, if all copies of the book have been returned, it removes the
	 * key from the hashmap and tells you all the outstanding copies of that
	 * book have been returned
	 *
	 * @param isbn
	 *            - this is the book number of the book being returned
	 * @param patron
	 *            - this is the person returning the book
	 */

	public void returnBook(String isbn, String patron) {
		ArrayList<String> patrons = getPatronsList(isbn);
		System.out.println("Returning ISBN: " + isbn);
		if (patrons.contains(patron)) {
			patrons.remove(patron);
			System.out.println("\t Removed Patron: " + patron);
		} else {
			System.out
					.println("\t Patron: '" + patron + "' not found for ISBN");
		}
	}

	private ArrayList<String> getPatronsList(String isbn) {
		ArrayList<String> patrons = checkoutBooks.get(isbn);
		if (patrons == null) {
			patrons = new ArrayList<String>();
			checkoutBooks.put(isbn, patrons);
		}
		return patrons;
	}

	/**
	 * this prints all the patrons names and all the books that have been
	 * checked out.
	 */

	public void printAllCheckoutBooks() {
		System.out.println();
		System.out.println();
		for (Entry<String, ArrayList<String>> entry : checkoutBooks.entrySet()) {
			if (entry.getValue().isEmpty()) {
				checkoutBooks.remove(entry);
			} else {
				int len = entry.getValue().toString().length();
				System.out.println("All checked out books: "
						+ entry.getValue().toString().substring(1, len - 1)
						+ " have/ has a copy book " + entry.getKey());
			}
		}
	}
}
