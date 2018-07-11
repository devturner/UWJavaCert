/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.model;

/**
 *
 * @author appleman
 */
public enum MovieGenre {
	/** The action genre. */
	ACTION("action"),
	/** The adventure genre. */
	ADVENTURE("adventure"),
	/** The comedy genre. */
	COMEDY("comedy"),
	/** The crime genre. */
	CRIME("crime"),
	/** The documentary genre. */
	DOCUMENTARY("documentary"),
	/** The drama genre. */
	DRAMA("drama"),
	/** The family genre. */
	FAMILY("family");

	/** The movies genre */
	private String movieGenre;

	/**
	 * Instantiates a new movieGenre
	 *
	 * @param movieGenre
	 *            the genre type
	 */
	MovieGenre(final String movieGenre) {
		this.movieGenre = movieGenre;
	}

	/**
	 * Gets the genre.
	 *
	 * @return the movieGenre
	 */

	public String getMovieGenre() {
		return movieGenre;
	}

}
