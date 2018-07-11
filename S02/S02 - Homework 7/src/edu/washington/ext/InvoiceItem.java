package edu.washington.ext;

/**
 * InvoiceItem Represents an item on an invoice. The InvoiceItem is immutable.
 *
 * @author christurner
 *
 */

public class InvoiceItem {
	/** Item, the item */
	final private Item item;
	/** Quantity, the quantity of the item being purchased */
	final private int totalPurchased;
	/** Discount, the discount (percentage) given on this particular item */
	final private double discountRate;

	/**
	 * This is the InvoiceItem constructor.
	 *
	 * @param item
	 *            - what is being sold
	 * @param totalPurchased
	 *            - how many are being bought
	 * @param discountRate
	 *            - what the discount rate is on the items
	 */
	public InvoiceItem(Item item, int totalPurchased, double discountRate) {
		super();
		this.item = item;
		this.totalPurchased = totalPurchased;
		this.discountRate = discountRate;
	}

	/**
	 * This method returns the total items being bought.
	 *
	 * @return - number of items
	 */
	public int getTotalPurchased() {
		return totalPurchased;
	}

	/**
	 * This method returns the discount rate.
	 *
	 * @return - the discount percentage.
	 */
	public double getDiscountRate() {
		return discountRate;
	}

	/**
	 * This is the description getter.
	 *
	 * @return - the description
	 */
	public String getItem() {
		return item.getDescription();
	}

	/**
	 * This is the price getter.
	 *
	 * @return - The price
	 */
	public double getPrice() {
		return item.getPrice();
	}

	/**
	 * This is the sku getter
	 *
	 * @return the SKU
	 */
	public double getSku() {
		return item.getSku();
	}

	/**
	 * This method returns the total value of the items bought.
	 *
	 * @return - the value, before discount.
	 */
	public double totalValue() {
		return getTotalPurchased() * item.getPrice();
	}

	/**
	 * This method returns the total discount of all the items bought.
	 *
	 * @return - the discounted total.
	 */
	public double totalDiscount() {
		return getTotalPurchased() * (item.getPrice() * getDiscountRate());
	}

	/**
	 * This method returns the net value of all these items sold
	 *
	 * @return - the net value of the sales.
	 */
	public double netValue() {
		return totalValue() - totalDiscount();

	}

}
