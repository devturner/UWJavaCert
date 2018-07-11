package edu.washington.ext;

import java.util.HashMap;

/**
 * A class that maintains information on a book. This might form part of a
 * larger application such as a library system, for instance.
 *
 * @author (Chris Turner)
 * @version (Tuesday October 14, 2014)
 *
 */
class Book {

	/**
	 * The fields.
	 *
	 * @param author
	 *            this is the author of the book.
	 * @param title
	 *            this is the title
	 * @param publisher
	 *            this is the publisher
	 * @param binding
	 *            this is the type of binding
	 * @param pages
	 *            this is the number of pages
	 * @param refNumber
	 *            this is the refNumber for the book
	 * @param description
	 *            this is the description of the book
	 * @param totalWordInDescription
	 *            this is the number of times a single word is used in the
	 *            description
	 * @param wordsAndCount
	 *            this is the HashMap that store the words and their usage count
	 */

	private String author;
	private String title;
	private String publisher;
	private Binding binding;
	private int pages;
	private String refNumber;
	private String description;
	private int totalWordsInDescription;
	private HashMap<String, Integer> wordsAndCount;

	/**
	 * Constructor. Set the author, title and binding fields when this object is
	 * constructed.
	 *
	 * @param bookAuthor
	 * @param bookTitle
	 * @param bookPublisher
	 * @param bindingType
	 * @param pages
	 * @param description
	 *
	 */

	public Book(String bookAuthor, String bookTitle, String bookPublisher,
			Binding bindingType, int pages, String description) {
		author = bookAuthor;
		title = bookTitle;
		publisher = bookPublisher;
		binding = bindingType;
		this.pages = pages;
		refNumber = "";
		this.description = description;

	}

	/**
	 * Description Getter.
	 *
	 * @return returns the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Description Setter.
	 *
	 * @return set the description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Author Getter
	 *
	 * @return returns the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Title Getter
	 *
	 * @return returns the title of the book
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Publisher Getter
	 *
	 * @return returns the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Binding Getter
	 *
	 * @return returns the type of binding
	 */
	public Binding getBinding() {
		return binding;
	}

	/**
	 * Page Getter.
	 *
	 * @return returns number of pages
	 */
	public int getPages() {
		return pages;
	}

	/**
	 * Ref Number Getter
	 *
	 * @return returns ref number
	 */
	public String getRefNumber() {
		return refNumber;
	}

	/**
	 * This is the setter for the RefNumber
	 *
	 * @param refNumber
	 *            - this is the refNumber to set it to
	 */
	public void setRefNumber(String refNumber) {
		if (refNumber.length() < 3) {
			System.out
					.println("There was an error, the reference needs to be greater than 3 characters long.");
		} else
			this.refNumber = refNumber;
	}

	/**
	 * Author setter.
	 *
	 * @param author
	 *            sets the author to this author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Title setter.
	 *
	 * @param title
	 *            sets the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Publisher setter.
	 *
	 * @param publisher
	 *            sets the publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Binding setter.
	 *
	 * @param binding
	 *            sets the type of binding
	 */
	public void setBinding(Binding binding) {
		this.binding = binding;
	}

	/**
	 * Page number setter.
	 *
	 * @param pages
	 *            sets the number of pages
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	/**
	 * This is the setter for the wordAndCount HashMap
	 *
	 * @param wordsAndCount
	 */
	public void setWordsAndCount(HashMap<String, Integer> wordsAndCount) {
		this.wordsAndCount = wordsAndCount;
	}

	/**
	 * Printer for the author
	 */

	public void printAuthor() {
		System.out.println("The author is: " + author);
	}

	/**
	 * Printer for the title
	 */
	public void printTitle() {
		System.out.println("The title is: " + title);
	}

	/**
	 * Printer for the publisher
	 */
	public void printPublisher() {
		System.out.println("The publisher is: " + publisher);
	}

	/**
	 * Printer for the type of binding - makes it lowerCase.
	 */
	public void printBinding() {
		System.out.println("The binding is: "
				+ binding.toString().toLowerCase());
	}

	/**
	 * Printer for the number of pages.
	 */
	public void printPages() {
		System.out.println("The number of pages: " + pages);
	}

	/**
	 * Printer for the description of the book.
	 */
	private void printdescription() {
		System.out.println("Book description: " + description);

	}

	/**
	 * Printer for all the details of the book
	 */
	public void printDetails() {
		System.out.println();
		printAuthor();
		printTitle();
		printPublisher();
		printBinding();
		printPages();
		if (refNumber.length() >= 3) {
			System.out.println("Refrence Number: " + refNumber);
		} else {
			System.out.println("Refrence Number: ZZZ");
		}
		printdescription();
	}

	/**
	 * This method counts the total number of whole words in the description.
	 * "\\s+" is the delimiter we then just count the words in the result
	 *
	 * @param description
	 *            what we want to count
	 * @return returns the int count
	 */
	public int getTotalWordsInDescription(String description) {
		String temp = description.trim();
		totalWordsInDescription = temp.split("\\s+").length;
		System.out.println();
		// System.out.println("Total words in the description is: "
		// + totalWordsInDescription);
		return totalWordsInDescription;
	}

	/**
	 * This method takes the description string and prepares it for the HashMap,
	 * which keeps a count of the total unique words and how many times each
	 * non-unique word is used.
	 *
	 * @param description
	 * @return wordsAndCount.size(); - this is the number of unique words used
	 *         in the description
	 */
	public int getTotalUniqueWordsInDescription(String description) {
		HashMap<String, Integer> wordsAndCount = new HashMap<String, Integer>();
		description = description.replace(",", "");
		description = description.replace(".", "");
		description = description.toLowerCase();
		String[] words = description.split(" ");
		for (String word : words) {
			if (wordsAndCount.containsKey(word)) {
				wordsAndCount.put(word, wordsAndCount.get(word) + 1);
			} else {
				wordsAndCount.put(word, 1);
			}
		}
		setWordsAndCount(wordsAndCount);
		return wordsAndCount.size();
	}

	/**
	 * This method takes the HashMap and tells us how many times a requested
	 * word is used in the description. If the word does not appear, the method
	 * will tell the user that as well.
	 *
	 * @param requestedWord
	 * @return this is the number of times the word was used.
	 */

	public int getTotalWordInDescription(String requestedWord) {
		if (wordsAndCount.containsKey(requestedWord)) {

			int a = wordsAndCount.get(requestedWord);
			return a;
		} else {
			System.out.println("The word '" + requestedWord
					+ "' is not used in the description!");
			int a = 0;
			return a;
		}

	}

}
