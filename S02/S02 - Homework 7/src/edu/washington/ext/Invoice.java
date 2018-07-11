package edu.washington.ext;

import java.util.ArrayList;

/**
 * Invoice The Invoice is a collection of InvoiceItems.
 *
 * @author christurner
 *
 */

public class Invoice {

	/** This establishes the arraylist of invoice items */
	private ArrayList<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();
	/** This establishes the invoice discount */
	private double invoiceDiscount;

	/**
	 * * This is a constructor for the class that makes a Invoice from any
	 * number of invoice items.
	 *
	 * @param args
	 *            - these are the invoice items that need to be added.
	 */
	@SafeVarargs
	public Invoice(InvoiceItem... args) {
		for (InvoiceItem arg : args) {
			invoiceItems.add(arg);
		}
	}

	/**
	 * This method gets the individual items in the invoice.
	 *
	 * @return - it returns the Arraylist of items.
	 */
	public ArrayList<InvoiceItem> getInvoiceItem() {
		for (int i = 0; i < invoiceItems.size(); i++) {
			System.out.println(invoiceItems.get(i).getItem());
		}
		return invoiceItems;
	}

	/**
	 * Adds an InvoiceItem to the invoice, also tests to see if the item (any
	 * part) is null, if so, it throws the IllegalArgumentException.
	 *
	 * @param InvoiceItem
	 *            - A single invoiceItem to be added to the invoice
	 */
	public void addItem(InvoiceItem InvoiceItem) {
		if (InvoiceItem.getItem() == null || InvoiceItem.getPrice() == 0.0
				|| InvoiceItem.getSku() == 0) {
			throw new IllegalArgumentException(
					"Null atrabutes not permissible.");
		} else {
			invoiceItems.add(InvoiceItem);
		}
	}

	/**
	 * This removes an item from the arraylist of invoice items.
	 *
	 * @param InvoiceItem
	 *            - what item to remove
	 */
	public void removeItem(InvoiceItem InvoiceItem) {
		invoiceItems.remove(InvoiceItem);
	}

	/**
	 * This set the invoice discount rate for the entire invoice, if there is
	 * not already an item with a discount. It throws an error if the discount
	 * is set to a negative number.
	 *
	 * @param discountRate
	 *            - what the invoice discount is set to.
	 */
	public void setInvoiceDiscount(double discountRate) {
		if (discountRate < 0) {
			throw new IllegalArgumentException(
					"The discount must be greater than 0");
		} else {
			for (InvoiceItem item : invoiceItems) {
				invoiceDiscount += item.netValue() * discountRate;

			}
		}
	}

	/**
	 * This method returns the invoice discount
	 *
	 * @return - the invoice discount.
	 */
	public double getInvoiceDiscount() {
		return invoiceDiscount;
	}

	/**
	 * This prints out the details for each item in the invoice.
	 *
	 * @throws DiscountException
	 *             - It throws an error if an item does have an existing
	 *             discount.
	 */
	public void processInvoice() throws DiscountException {
		double invoiceTotal = 0;
		for (InvoiceItem item : invoiceItems) {
			if (item.getDiscountRate() == 0.0) {
				System.out.println("Item: " + item.getItem());
				System.out.println("  Total purchased: "
						+ item.getTotalPurchased());
				System.out.println("  Subtotal: " + item.totalValue());
				invoiceTotal += item.totalValue();
				System.out.println("Total after invoice discount: $"
						+ (invoiceTotal - invoiceDiscount));
			} else {
				throw new DiscountException(
						"A discount cannot be applied to the invoice if an item is already on sale.");
			}
		}
	}
}
