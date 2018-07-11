package com.scg.util;

import java.util.LinkedList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;

/**
 * The class <code>TimeCardListUtilcodeProTest</code> contains tests for the class <code>{@link TimeCardListUtil}</code>.
 *
 * @generatedBy CodePro at 2/8/15 9:21 PM
 * @author christurner
 * @version $Revision: 1.0 $
 */
public class TimeCardListUtilcodeProTest {
	/**
	 * Run the List<TimeCard> getTimeCardsForConsultant(List<TimeCard>,Consultant) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/8/15 9:21 PM
	 */
	@Test
	public void testGetTimeCardsForConsultant_1()
		throws Exception {
		List<TimeCard> timeCards = new LinkedList();
		Consultant consultant = new Consultant(new Name());

		List<TimeCard> result = TimeCardListUtil.getTimeCardsForConsultant(timeCards, consultant);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<TimeCard> getTimeCardsForDateRange(List<TimeCard>,DateRange) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/8/15 9:21 PM
	 */
	@Test
	public void testGetTimeCardsForDateRange_1()
		throws Exception {
		List<TimeCard> timeCards = new LinkedList();
		DateRange dateRange = new DateRange(1, 1);

		List<TimeCard> result = TimeCardListUtil.getTimeCardsForDateRange(timeCards, dateRange);

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the void sortByConsultantName(List<TimeCard>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/8/15 9:21 PM
	 */
	@Test
	public void testSortByConsultantName_1()
		throws Exception {
		List<TimeCard> timeCards = new LinkedList();

		TimeCardListUtil.sortByConsultantName(timeCards);

		// add additional test code here
	}

	/**
	 * Run the void sortByStartDate(List<TimeCard>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/8/15 9:21 PM
	 */
	@Test
	public void testSortByStartDate_1()
		throws Exception {
		List<TimeCard> timeCards = new LinkedList();

		TimeCardListUtil.sortByStartDate(timeCards);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/8/15 9:21 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2/8/15 9:21 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2/8/15 9:21 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(TimeCardListUtilcodeProTest.class);
	}
}