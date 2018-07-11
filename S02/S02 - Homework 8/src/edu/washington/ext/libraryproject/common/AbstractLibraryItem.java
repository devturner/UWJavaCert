package edu.washington.ext.libraryproject.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.washington.ext.libraryproject.model.Patron;

/**
 * This is the AbstractLibraryItem class
 *
 * @author christurner
 *
 */

public abstract class AbstractLibraryItem implements LibraryItem {
	/** The objects title */
	private String title;
	/** The published date */
	private Date publishedDate;
	/** The author */
	private String author;
	/** The publisher */
	private String publisher;
	/** The patron that has the object */
	private Patron checkedOut;

	/**
	 * This is the item constructor. It is used to build up a new item in the
	 * library.
	 *
	 * @param title
	 *            the title
	 * @param author
	 *            the author
	 * @param publisher
	 *            the publisher
	 * @param publishedDate
	 *            the date published
	 */
	public AbstractLibraryItem(String title, String author, String publisher,
			Date publishedDate) {
		this.title = title;
		this.publishedDate = publishedDate;
		this.author = author;
		this.publisher = publisher;
	}

	/**
	 * This is the date format for all the published dates.
	 */
	public DateFormat DF = new SimpleDateFormat("MM/dd/yyyy");

	/**
	 * Title getter
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Publish date getter
	 *
	 * @return the publishedDate
	 */

	public Date getPublishedDate() {
		return publishedDate;
	}

	/**
	 * Author getter
	 *
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Publisher getter
	 *
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Getter for the patron that checked out the book
	 *
	 * @return the checkedOut
	 */
	public Patron getCheckedOutPatron() {
		return checkedOut;
	}

	/**
	 * The setter for the checker
	 *
	 * @param checkedOut
	 *            the checkedOut to set
	 */
	public void setCheckedOut(Patron checkedOut) {
		this.checkedOut = checkedOut;
	}

	/**
	 * This overrides the toString method
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return super.toString();
	}

}
