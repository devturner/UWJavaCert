package edu.washington.ext;

/**
 * A record of an employee's pay.
 *
 * @author Chris Turner
 */
final class PayrollRecord {
    /** The employee name. */
    private String employeeName;

    /** Employee's current pay. */
    private double currentPay;

    /**
     * Constructor.
     *
     * @param employeeName the employee's name
     * @param currentPay the employee's current pay
     */
    public PayrollRecord(String employeeName, double currentPay) {
        this.employeeName = employeeName;
        this.currentPay = currentPay;
    }

    /**
     * Returns the employee's current pay.
     *
     * @return the employee's current pay
     */
    public double getCurrentPay() {
        return currentPay;
    }

    /**
     * Return the employee's name.
     *
     * @return the employee's name
     */
    public String getEmployeeName() {
        return employeeName;
    }
}
