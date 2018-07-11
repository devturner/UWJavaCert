package edu.washington.ext;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the class that tests all the classes in the edu.washington.ext
 * package. It ensures that the exceptions are handled correctly.
 */
public class InvoiceTest {

	/** Null string */
	private String nString = null;
	/** Null double */
	private double nDouble;
	/** Null int */
	private int nInt;
	/** This is an item */
	private Item item1;
	/** This is an item */
	private Item item2;
	/** This is an item */
	private Item item3;
	/** This is an item */
	private Item item4;
	/** This is a null item */
	private Item item5Null;
	/** An Invoice Item */
	private InvoiceItem invoiceItem1;
	/** An Invoice Item */
	private InvoiceItem invoiceItem2;
	/** An Invoice Item */
	private InvoiceItem invoiceItem3;
	/** An Invoice Item */
	private InvoiceItem invoiceItem4;
	/** A null Invoice Item */
	private InvoiceItem invoiceItem5Null;
	/** An Invoice */
	private Invoice invoice1;
	/** An Invoice */
	private Invoice invoice2;

	/**
	 * This is the setup method to establish the values of the items.
	 */

	@Before
	public void setUp() {
		item1 = new Item("Bacon Wave", 10.00, 680001);
		item2 = new Item("Schnozberry", 2.50, 543244);
		item3 = new Item("Soda", 2.00, 567892);
		item4 = new Item("Gobstopper", 1.00, 990204);
		item5Null = new Item(nString, nDouble, nInt);
		invoiceItem1 = new InvoiceItem(item1, 5, .5);
		invoiceItem2 = new InvoiceItem(item2, 10, 0.0);
		invoiceItem3 = new InvoiceItem(item3, 3, 0.0);
		invoiceItem4 = new InvoiceItem(item4, 20, 0.0);
		invoiceItem5Null = new InvoiceItem(item5Null, nInt, nDouble);
		invoice1 = new Invoice(invoiceItem1, invoiceItem2);
		invoice2 = new Invoice(invoiceItem2, invoiceItem3, invoiceItem4);
	}

	/**
	 * This test ensures a null item is created.
	 */
	@Test
	public void testAssertNullItem() {
		assertNull(item5Null.getDescription());
		assertEquals(item5Null.getPrice(), 0.0, .0);
		assertEquals(item5Null.getSku(), 0);
	}

	/**
	 * This test ensures that we are creating an Item correctly.
	 */
	@Test
	public void testItemCreation() {
		assertEquals(item1.getDescription(), "Bacon Wave");
		assertEquals(item2.getPrice(), 2, 50);
	}

	/**
	 * This test ensures that adding a null item to the invoice throws an
	 * exception.
	 */
	@Test(expected = Exception.class)
	public void nullTest() {
		invoice1.addItem(invoiceItem5Null);
	}

	/**
	 * This tests to ensures that an invoice can be processed incorrectly.
	 */
	@Test
	public void processInvoiceFail() {
		invoice1.setInvoiceDiscount(.5);
		invoice1.addItem(invoiceItem1);
		try {
			invoice1.processInvoice();
		} catch (DiscountException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This test shows that setting a negative discount rate fails.
	 */
	@Test(expected = Exception.class)
	public void processInvoiceFail2() {
		invoice1.setInvoiceDiscount(-.5);
		invoice1.addItem(invoiceItem1);
		try {
			invoice1.processInvoice();
		} catch (DiscountException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This tests to ensures that an invoice can be processed correctly.
	 */
	@Test
	public void processInvoicePass() {
		invoice2.setInvoiceDiscount(.5);
		try {
			invoice2.processInvoice();
		} catch (DiscountException e) {
			e.printStackTrace();
		}
	}
}
