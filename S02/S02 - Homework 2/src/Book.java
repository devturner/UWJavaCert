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
	 * @param totalWordsInDescription
	 *            this is the total number of words in the description
	 * @param totalUniqueWordsInDescription
	 *            this is the number of unique words in the description
	 * @param totalWordInDescription
	 *            this is the number of times a single word is used in the
	 *            description
	 */

	private String author;
	private String title;
	private String publisher;
	private Binding binding;
	private int pages;
	private String refNumber;
	private String description;
	private int totalWordsInDescription;
	private int totalUniqueWordsInDescription;
	private int totalWordInDescription;

	/**
	 * Constructor. Set the author, title and binding fields when this object is
	 * constructed.
	 *
	 * @param bookAuthor
	 * @param bookTitle
	 * @param bookPublisher
	 * @param bindingType
	 * @param pages
	 *
	 */

	Book(String bookAuthor, String bookTitle, String bookPublisher,
			Binding bindingType, int pages) {
		author = bookAuthor;
		title = bookTitle;
		publisher = bookPublisher;
		binding = bindingType;
		this.pages = pages;
		refNumber = "";
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
	 * setter.
	 *
	 * @param publisher
	 *            sets the publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * setter.
	 *
	 * @param binding
	 *            sets the type of binding
	 */
	public void setBinding(Binding binding) {
		this.binding = binding;
	}

	/**
	 * setter.
	 *
	 * @param pages
	 *            sets the number of pages
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}

	/**
	 * Printer for the author
	 */

	public void printAuthor() {
		System.out.println(author);
	}

	/**
	 * Printer for the title
	 */
	public void printTitle() {
		System.out.println(title);
	}

	/**
	 * Printer for the publisher
	 */
	public void printPublisher() {
		System.out.println(publisher);
	}

	/**
	 * Printer for the type of binding - makes it lowerCase.
	 */
	public void printBinding() {
		System.out.println(binding.toString().toLowerCase());
	}

	/**
	 * Printer for all the details of the book
	 */
	public void printDetails() {
		System.out.println();
		System.out.println("Author: " + author);
		System.out.println("Title: " + title);
		System.out.println("Publisher: " + publisher);
		System.out.println("Binding: " + binding.toString().toLowerCase());
		System.out.println("Pages: " + pages);
		if (refNumber.length() >= 3) {
			System.out.println("Refrence Number: " + refNumber);
		} else
			System.out.println("Refrence Number: ZZZ");
	}

	
	public int getTotalWordsInDescription(){
		return 4;

	}
}
