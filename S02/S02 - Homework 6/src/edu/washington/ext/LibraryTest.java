package edu.washington.ext;

import java.util.List;

import edu.washington.ext.common.AbstractEmployee;
import junit.framework.TestCase;

/**
 * JUnit test case for the Library class.
 *
 * @author Chris Turner
 */
public class LibraryTest extends TestCase {
	/** The store instance to be tested. */
	private Library library;

	/** Values to be used in testing. */
	public static final int LIBRARY_NUM = 123;

	private static final String LIBRARIAN_NAME = "Betty";
	private static final double LIBRARIAN_BASE_PAY = 4000.00;
	private static final double LIBRARIAN_CUR_SALES = 10000.00;
	private static final double LIBRARIAN_COMISSION_RATE = 0.005;
	private static final double LIBRARIAN_EXPECTED_PAY = 4502.50;

	private static final String LIBRARY_EMP_NAME = "Pebbles";
	private static final double LIBRARY_EMP_HOURLY_RATE = 10.50;
	private static final double LIBRARY_EMP_CUR_SALES = 500.00;
	private static final double LIBRARY_EMP_CUR_HOURS = 160.00;
	private static final double LIBRARY_EMP_EXPECTED_PAY = 1680.00;

	private static final String ASSOC_1_NAME = "Wilma";
	private static final double ASSOC_1_HOURLY_RATE = 12.50;
	private static final double ASSOC_1_COMMISION_RATE = 0.02;
	private static final double ASSOC_1_CUR_SALES = 15000.00;
	private static final double ASSOC_1_CUR_HOURS = 138.00;
	private static final double ASSOC_1_EXPECTED_PAY = 2025.00;

	private static final String ASSOC_2_NAME = "Fred";
	private static final double ASSOC_2_HOURLY_RATE = 14.50;
	private static final double ASSOC_2_COMMISION_RATE = 0.02;
	private static final double ASSOC_2_CUR_SALES = 30000.00;
	private static final double ASSOC_2_CUR_HOURS = 160.00;
	private static final double ASSOC_2_EXPECTED_PAY = 2920.00;

	private static final String ASSOC_3_NAME = "Barney";
	private static final double ASSOC_3_HOURLY_RATE = 15.00;
	private static final double ASSOC_3_COMMISION_RATE = 0.03;
	private static final double ASSOC_3_CUR_SALES = 45000.00;
	private static final double ASSOC_3_CUR_HOURS = 160.00;
	private static final double ASSOC_3_EXPECTED_PAY = 3750.00;

	private static final double LIBRARY_MONTHLY_CHECKOUTS = 100500.00;
	private static final double LIBRARY_COMMISSION_TOTALS = 2752.50;

	/**
	 * Setup the test environment.
	 *
	 * @exception Exception
	 *                if the super method throws
	 */
	protected void setUp() throws Exception {
		super.setUp();
		library = new Library(LIBRARY_NUM);

		// staff the Library
		Librarian librarian = new Librarian(LIBRARIAN_NAME);
		librarian.setBasePay(LIBRARIAN_BASE_PAY);
		Librarian.setCommission(LIBRARIAN_COMISSION_RATE);

		LibraryEmployee office = new LibraryEmployee(LIBRARY_EMP_NAME);
		office.setHourlyRate(LIBRARY_EMP_HOURLY_RATE);

		LibraryAssociate assoc1 = new LibraryAssociate(ASSOC_1_NAME);
		assoc1.setHourlyRate(ASSOC_1_HOURLY_RATE);
		assoc1.setCommissionRate(ASSOC_1_COMMISION_RATE);

		LibraryAssociate assoc2 = new LibraryAssociate(ASSOC_2_NAME);
		assoc2.setHourlyRate(ASSOC_2_HOURLY_RATE);
		assoc2.setCommissionRate(ASSOC_2_COMMISION_RATE);

		LibraryAssociate assoc3 = new LibraryAssociate(ASSOC_3_NAME);
		assoc3.setHourlyRate(ASSOC_3_HOURLY_RATE);
		assoc3.setCommissionRate(ASSOC_3_COMMISION_RATE);


		library.setLibrarian(librarian);
		library.addEmployee(office);
		library.addEmployee(assoc1);
		library.addEmployee(assoc2);
		library.addEmployee(assoc3);

		// set the current month numbers
		librarian.setCurrentSales(LIBRARIAN_CUR_SALES);

		office.setCurrentSales(LIBRARY_EMP_CUR_SALES);
		office.setCurrentHours(LIBRARY_EMP_CUR_HOURS);

		assoc1.setCurrentSales(ASSOC_1_CUR_SALES);
		assoc1.setCurrentHours(ASSOC_1_CUR_HOURS);

		assoc2.setCurrentSales(ASSOC_2_CUR_SALES);
		assoc2.setCurrentHours(ASSOC_2_CUR_HOURS);

		assoc3.setCurrentSales(ASSOC_3_CUR_SALES);
		assoc3.setCurrentHours(ASSOC_3_CUR_HOURS);

	}

	/**
	 * Test method for 'edu.washington.ext.Store.processPayroll()'
	 */
	public void testProcessPayroll() {
		List<PayrollRecord> payroll = library.processPayroll();
		for (PayrollRecord payRec : payroll) {
			if (LIBRARIAN_NAME.equals(payRec.getEmployeeName())) {
				assertEquals(LIBRARIAN_EXPECTED_PAY, payRec.getCurrentPay());
			} else if (LIBRARY_EMP_NAME.equals(payRec.getEmployeeName())) {
				assertEquals(LIBRARY_EMP_EXPECTED_PAY, payRec.getCurrentPay());
			} else if (ASSOC_1_NAME.equals(payRec.getEmployeeName())) {
				assertEquals(ASSOC_1_EXPECTED_PAY, payRec.getCurrentPay());
			} else if (ASSOC_2_NAME.equals(payRec.getEmployeeName())) {
				assertEquals(ASSOC_2_EXPECTED_PAY, payRec.getCurrentPay());
			} else if (ASSOC_3_NAME.equals(payRec.getEmployeeName())) {
				assertEquals(ASSOC_3_EXPECTED_PAY, payRec.getCurrentPay());
			} else {
				fail("Unknown employee!");
			}
		}
	}

	/**
	 * Test method for 'edu.washington.ext.Library.getCurrentSales()'
	 */
	public void testGetCurrentSales() {
		assertEquals(LIBRARY_MONTHLY_CHECKOUTS,
				library.getCurrentUsedBookSales());
	}

	/**
	 * Test method for the 'edu.washington.ext.Library.getTotalCommissions()
	 */
	public void testTotalCommissions() {
		assertEquals(LIBRARY_COMMISSION_TOTALS, library.getTotalCommissions());
	}

	/**
	 * This is the main method, not used.
	 *
	 * @param args
	 *            - this is not used.
	 */
	public static void main(String[] args) {

		// org.junit.runner.JUnitCore.main("edu.washington.ext.StoreTest");
	}
}
