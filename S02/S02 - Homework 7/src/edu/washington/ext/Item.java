package edu.washington.ext;
	/**
	 * This is the item class, it is responsible for making a new item to be kept in the inventory.
	 *
	 * @author christurner
	 *
	 */

final class Item {

	/** Description, a description of the item */
	final private String description;
	/** Price, the item's prices (in cents) */
	final private double price;
	/** Stock keeping unit (SKU), an numeric identifier for the item */
	final private int sku;

	/**
	 * This is the constructor for a new item.
	 *
	 * @param description
	 *            - this is the description of the item
	 * @param price
	 *            - the price
	 * @param sku
	 *            - the identification number
	 */

	public Item(String description, double price, int sku) {
		super();
		this.description = description;
		this.price = price;
		this.sku = sku;
	}

	/** This is the getter for the items description
	 *
	 * @return returns the item description
	 *
	 */

	public String getDescription() {
		return description;
	}

	/** This is the getter for the items price
	 *
	 * @return - This returns the price
	 * */

	public double getPrice() {
		return price;
	}

	/**
	 * This is the getter for the items sku
	 * @return - This returns the Sku
	 */
	public int getSku() {
		return sku;
	}

}
