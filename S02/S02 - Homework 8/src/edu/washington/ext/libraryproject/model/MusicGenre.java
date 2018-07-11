/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.model;

/**
 *
 * @author appleman
 */
public enum MusicGenre {
	/** The pop */
	POP("pop"),
	/** The dance */
	DANCE("dance"),
	/** The hiphop */
	HIPHOP("hiphop"),
	/** The rap */
	RAP("rap"),
	/** The rock */
	ROCK("rock"),
	/** The alternative */
	ALTERNATIVE("alternative"),
	/** The hardrock */
	HARDROCK("hardrock"),
	/** The folk */
	FOLK("folk"),
	/** The country */
	COUNTRY("country");

	/** The music genre */
	private String musicGenre;

	/**
	 * Instantiates a new music genre.
	 *
	 * @param bindingType
	 *            the genre
	 */
	MusicGenre(final String musicGenre) {
		this.musicGenre = musicGenre;
	}

	/**
	 * Gets the genre type
	 *
	 * @return what the genre is
	 */
	public String getMusicGenre() {
		return musicGenre;
	}

}
