package edu.washington.ext;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the class that tests all the classes in my library package. It
 * specifically focuses on the getCurrentUsedBookSales & testProcessPayroll, in
 * order to do that, a new library is established with 1 librarian, 1 employee,
 * and 3 associates.
 *
 * @author christurner
 *
 */
public class LibraryTest {

	/**
	 * This is the initializations of the library
	 */

	Library testLibrary;

	/**
	 * Setting up the objects and arraylist to be tested - the constructor - by
	 * adding the created objects to the Library, here the numbers of each
	 * employee are established.
	 */

	@Before
	public void setup() {
		testLibrary = new Library(45);
		Librarian librarian1;
		LibraryEmployee employee;
		LibraryAssociate associate1;
		LibraryAssociate associate2;
		LibraryAssociate associate3;

		librarian1 = new Librarian("Mukund");
		employee = new LibraryEmployee("Chris");
		associate1 = new LibraryAssociate("Sri");
		associate2 = new LibraryAssociate("Ada");
		associate3 = new LibraryAssociate("Francis");

		testLibrary.addEmployee(employee);
		testLibrary.addEmployee(associate1);
		testLibrary.addEmployee(associate2);
		testLibrary.addEmployee(associate3);
		testLibrary.setLibrarian(librarian1);

		librarian1.setBasePay(4000.00);
		librarian1.setCurrentLibrarianUsedBookTotals(10000);
		Librarian.setBonusRate(.005);

		employee.setCurrentHours(160);
		employee.setHourlyRate(10.50);
		employee.setCurrentSales(500);

		associate1.setHourlyRate(12.50);
		associate1.setCurrentHours(138);
		associate1.setCommisionRate(.02);
		associate1.setCurrentSales(15000);

		associate2.setHourlyRate(14.50);
		associate2.setCurrentHours(160);
		associate2.setCommisionRate(.02);
		associate2.setCurrentSales(30000);

		associate3.setHourlyRate(15.00);
		associate3.setCurrentHours(160);
		associate3.setCommisionRate(.03);
		associate3.setCurrentSales(45000);
		
		System.out.println(librarian1.calculatePay());
	}

	/**
	 * Cleans up after the test. Called after every test method.
	 *
	 */
	@After
	public void tearDown() throws Exception {
		testLibrary = null;
	}

	/**
	 * This test ensures that the current used number of books sold is
	 * calculated correctly.
	 */
	@Test
	public void testGetCurrentUsedBookSales() {
		testLibrary.getCurrentUsedBookSales();
		assertEquals(100500, testLibrary.getCurrentUsedBookSales(), .1);
	}

	/**
	 * This test ensures that the payrolls are calculated correctly for all
	 * employees and the librarian (who is an employee too).
	 */
	@Test
	public void testProcessPayroll() {
		PayrollRecord payroll1 = new PayrollRecord("Chris", 1680.0);
		PayrollRecord payroll2 = new PayrollRecord("Sri", 2025.0);
		PayrollRecord payroll3 = new PayrollRecord("Ada", 2920.0);
		PayrollRecord payroll4 = new PayrollRecord("Francis", 3750.0);
		PayrollRecord payroll5 = new PayrollRecord("Mukund", 4502.5);

		ArrayList<PayrollRecord> verify = new ArrayList<PayrollRecord>();
		verify.add(payroll1);
		verify.add(payroll2);
		verify.add(payroll3);
		verify.add(payroll4);
		verify.add(payroll5);

		testLibrary.getCurrentUsedBookSales();
		ArrayList<PayrollRecord> pay = testLibrary.processPayroll();
		assertEquals(verify, pay);

	}


}
