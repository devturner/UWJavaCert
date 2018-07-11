package edu.washington.ext.common;

/**
 * Employee type.
 *
 * @author Chris Turner
 */
public interface Employee {
    /**
     * Gets the name of the employee.
     *
     * @return the name of the employee
     */
    String getName();

    /**
     * Calculates the employee's pay.
     *
     * @return the pay of the employee
     */
    double calculatePay();
}
