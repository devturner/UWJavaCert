package edu.washington.ext.libraryproject.model;

import edu.washington.ext.libraryproject.common.AbstractLibraryItem;
import java.util.Date;

/**
 * This is the class for the Music media type.
 *
 * @author christurner
 *
 */

public class Music extends AbstractLibraryItem {
	/** The media type */
	private MediaType mediaType = null;
	/** The artists name */
	private String artist = null;
	/** The genre of the music type */
	private MusicGenre genre = null;

	/**
	 * This is a media constructor. It takes all these params to make a new
	 * media.
	 *
	 * @param title
	 *            the title
	 * @param author
	 *            the author
	 * @param publisher
	 *            the publisher
	 * @param publishedDate
	 *            the date it was published
	 * @param mediaType
	 *            the type of media
	 * @param artist
	 *            the artist
	 * @param genre
	 *            the genre
	 */
	public Music(String title, String author, String publisher,
			Date publishedDate, MediaType mediaType, String artist,
			MusicGenre genre) {
		super(title, author, publisher, publishedDate);
		this.mediaType = mediaType;
		this.artist = artist;
		this.genre = genre;
	}

	/**
	 * This is the getter for the media type
	 *
	 * @return the mediaType
	 */
	public MediaType getMediaType() {
		return mediaType;
	}

	/**
	 * This is the getter for the artist
	 *
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * This is the getter for the genre
	 *
	 * @return the genre
	 */
	public MusicGenre getGenre() {
		return genre;
	}

}
