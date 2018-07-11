package edu.washington.ext.libraryproject.model;

import edu.washington.ext.libraryproject.common.AbstractLibraryItem;
import java.util.Date;

/**
 * This is the class that makes a new video for the library.
 *
 * @author christurner
 *
 */

public class Video extends AbstractLibraryItem {
	/** This is the media type */
	private MediaType mediaType = null;
	/** This is the movie genre */
	private MovieGenre genre = null;
	/** This is the director of the movie */
	private String director = null;
	/** This is the producer of the movie */
	private String producer = null;

	/**
	 * This is the constructor that makes builds a new movie object.
	 *
	 * @param title
	 *            the title
	 * @param author
	 *            the author
	 * @param publisher
	 *            the publisher
	 * @param publishedDate
	 *            the date published
	 * @param mediaType
	 *            the media type
	 * @param director
	 *            the director
	 * @param producer
	 *            the producer
	 * @param genre
	 *            the movie genre
	 */
	public Video(String title, String author, String publisher,
			Date publishedDate, MediaType mediaType, String director,
			String producer, MovieGenre genre) {
		super(title, author, publisher, publishedDate);
		this.director = director;
		this.producer = producer;
		this.mediaType = mediaType;
	}

	/**
	 * The getter for the media type
	 * @return the mediaType
	 */
	public MediaType getMediaType() {
		return mediaType;
	}

	/**
	 * The getter for the movie genre
	 * @return the genre
	 */
	public MovieGenre getGenre() {
		return genre;
	}

	/**
	 * The getter for the director
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * This is the setter for the director
	 * @param director
	 *            the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * This is the setter for the producer
	 * @return the producer
	 */
	public String getProducer() {
		return producer;
	}
}

