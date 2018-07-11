package edu.washington.ext;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

	Book courseText;

	/**
	 * This sets up the new book to test against using the constructor.
	 */

	@Before
	public void setup() {
		courseText = new Book(
				"Cay Horstman",
				"Core Java Vol 1, 9th Ed",
				"Prentice Hall",
				Binding.PAPERBACK,
				1008,
				"We hold these truths to be self-evident, that all "
						+ "men are created equal, that they are endowed by their "
						+ "Creator with certain unalienable Rights, that among "
						+ "these are Life, Liberty, and the pursuit of Happiness. "
						+ "That to secure these rights, Governments are instituted "
						+ "among Men, deriving their just powers from the consent "
						+ "of the governed. That whenever any Form of Government "
						+ "becomes destructive of these ends, it is the Right of the "
						+ "People to alter or to abolish it, and to institute new "
						+ "Government, laying its foundation on such principles and "
						+ "organizing its powers in such form, as to them shall seem "
						+ "most likely to effect their Safety and Happiness.");
	}

	/**
	 * This is the test that gets the total words used in the description.
	 */

	@Test
	public void checkgetTotalWordsInDescription() {
		int words = courseText.getTotalWordsInDescription(courseText
				.getDescription());
		assertEquals(words, 110);
	}

	/**
	 * This is the unique word counting tests, they make sure that the methods are
	 * performing correctly.
	 */

	@Test
	public void uniqueWordsCounting() {
		int b = courseText.getTotalUniqueWordsInDescription(courseText
				.getDescription());
		assertEquals(b, 71);
		int c = courseText.getTotalWordInDescription("to");
		assertEquals(c, 7);
		int d = courseText.getTotalWordInDescription("rights");
		assertEquals(d, 2);
		int e = courseText.getTotalWordInDescription("");
		assertEquals(e, 0);
		int f = courseText.getTotalWordInDescription("hamburger");
		assertEquals(f, 0);
	}

}
