package edu.washington.ext;

import java.util.ArrayList;
import java.util.List;

import edu.washington.ext.common.CommissionedEmployee;

/**
 * A library.
 *
 * @author Chris Turner
 */
final class Library {
	/** The Library number, identifies the Library. */
	private int libraryNumber;

	/** The library staff. */
	private List<LibraryEmployee> staff;

	/** The Librarian. */
	private Librarian librarian;

	/** The Payroll record list. */
	private ArrayList<PayrollRecord> payrollRecord = new ArrayList<PayrollRecord>();

	/**
	 * Constructor.
	 *
	 * @param libraryNumber
	 *            the store number, identifies the store
	 */
	public Library(int libraryNumber) {
		this.libraryNumber = libraryNumber;
		staff = new ArrayList<LibraryEmployee>();
	}

	/**
	 * Returns the store number.
	 *
	 * @return the store number
	 */
	public int getLibraryNumber() {
		return libraryNumber;
	}

	/**
	 * Calculates the pay and creates a payroll record for each employee.
	 *
	 * @return the payroll records for the stores employees
	 */
	public List<PayrollRecord> processPayroll() {
		List<PayrollRecord> payroll = new ArrayList<PayrollRecord>();
		double storeSales = 0;
		for (LibraryEmployee emp : staff) {
			PayrollRecord payRec;
			payRec = new PayrollRecord(emp.getName(), emp.calculatePay());
			payroll.add(payRec);
			storeSales += emp.getCurrentSales();
		}
		storeSales += librarian.getCurrentSales();
		librarian.setCurrentLibraryTotals(storeSales);
		PayrollRecord mgrPayRec;
		mgrPayRec = new PayrollRecord(librarian.getName(),
				librarian.calculatePay());
		payroll.add(mgrPayRec);

		return payroll;
	}

	/**
	 * Returns the Library's Used book current sales.
	 *
	 * @return the Library's Used book current sales
	 */
	public double getCurrentUsedBookSales() {
		double storeSales = 0;
		for (LibraryEmployee emp : staff) {
			storeSales += emp.getCurrentSales();
		}
		storeSales += librarian.getCurrentSales();
		return storeSales;
	}

	/**
	 * Adds an employee to the store staff.
	 *
	 * @param employee
	 *            an employee to add to the store staff
	 */
	public void addEmployee(LibraryEmployee employee) {
		staff.add(employee);
	}

	/**
	 * Sets the Librarian.
	 *
	 * @param librarian
	 *            the Librarian
	 */
	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	/**
	 * Calculates the commissions for all commissioned employees for this pay
	 * period.
	 *
	 * @return -totalCommissions as a double
	 */
	public double getTotalCommissions() {
		double totalCommissions = 0;
		for (LibraryEmployee emp : staff) {
			if (emp instanceof CommissionedEmployee) {
				CommissionedEmployee comEmp = (CommissionedEmployee) emp;
				totalCommissions += comEmp.calculateCommission();
			}
		}
		totalCommissions += getCurrentUsedBookSales()
				* Librarian.getCommissionRate();
		return totalCommissions;
	}
}
