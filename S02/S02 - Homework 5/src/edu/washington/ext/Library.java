package edu.washington.ext;

import java.util.ArrayList;

/**
 * This is the class that builds the Library system. It calculates pay and
 * creates the lists of all employees, tracks the Library number and who the
 * Librarian is.
 *
 * @author chris turner
 *
 */

final class Library {

	/**
	 * These are the perameters that all define all libraries.
	 */
	private int libraryNumber;
	private Librarian librarian;
	private ArrayList<LibraryEmployee> staff = new ArrayList<LibraryEmployee>();
	private ArrayList<PayrollRecord> payrollRecord = new ArrayList<PayrollRecord>();
	private double currentUsedBookSales;

	/**
	 * This is the constructor that makes a new library, it takes a number.
	 *
	 * @param libraryNumber
	 *            - this is the number the new library will be identified as.
	 */
	public Library(int libraryNumber) {
		this.libraryNumber = libraryNumber;
	}

	/**
	 * Gets the Library number
	 *
	 * @return - Returns the number
	 */
	public int getLibraryNumber() {
		return libraryNumber;
	}

	/**
	 * Calculates the payroll records for all employees and the librarian.
	 *
	 * @return - returns the arraylist of payroll records.
	 */
	public ArrayList<PayrollRecord> processPayroll() {
		double cPay = 0;
		String name = "";
		for (int i = 0; i < staff.size(); i++) {
			cPay = staff.get(i).calculatePay();
			name = staff.get(i).getName();
			PayrollRecord pay = new PayrollRecord(name, cPay);
			payrollRecord.add(pay);
		}
		cPay = librarian.calculatePay();
		name = librarian.getName();
		PayrollRecord pay = new PayrollRecord(name, cPay);
		payrollRecord.add(pay);
		// System.out.println(pay.getEmployeeName());
		// System.out.println(pay.getCurrentPay());
		return payrollRecord;
	}

	/**
	 * This method returns the total sales for the library, it includes the
	 * librarian and all employees.
	 *
	 * @return - the total sales of all employees
	 */

	public double getCurrentUsedBookSales() {
		double cSales = 0;
		for (int i = 0; i < staff.size(); i++) {
			cSales += staff.get(i).getCurrentSales();
		}
		double total = librarian.getCurrentLibrarianUsedBookTotals() + cSales;
		currentUsedBookSales = total;
		librarian.setCurrentLibraryUsedBookSalesTotals(currentUsedBookSales);
		return currentUsedBookSales;
	}

	/**
	 * This adds a Library employee to the Library staff arraylist.
	 *
	 * @param staff
	 *            - who is added
	 */
	public void addEmployee(LibraryEmployee staff) {
		this.staff.add(staff);
	}

	/**
	 * Sets the librarian for the Library
	 *
	 * @param librarian
	 *            - who is the librarian.
	 */
	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	/**
	 * This method gets the staff members name from the Library arraylist.
	 */
	public void getStaff() {
		for (int i = 0; i < staff.size(); i++) {
			String tName = staff.get(i).getName();
			System.out.println(tName);
		}
	}

}
