package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scg.domain.ClientAccount;
import com.scg.domain.Invoice;
import com.scg.domain.TimeCard;
import com.scg.util.DateRange;
import com.scg.util.TimeCardListUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class Assignment05.
 */
public class Assignment05 {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger("assignment5");

	/** The invoice month. */
	private static final int INVOICE_MONTH = Calendar.MARCH;

	/** The test year. */
	private static final int INVOICE_YEAR = 2006;

	/** The deserialized accounts. */
	private static List<ClientAccount> deserializedAccounts = new ArrayList<ClientAccount>();

	/** The deserialized time cards. */
	private static List<TimeCard> deserializedTimeCards = new ArrayList<TimeCard>();

	/** The invoices. */
	private static List<Invoice> invoices = new ArrayList<Invoice>();

	/**
	 * Read client list.
	 */
	@SuppressWarnings("unchecked")
	private static void readClientList() {
		try (FileInputStream fi = new FileInputStream("ClientList.ser")) {
			ObjectInputStream os = new ObjectInputStream(fi);
			deserializedAccounts = (List<ClientAccount>) os.readObject();
			os.close();
		} catch (FileNotFoundException e) {
			log.error("The file was not found.", e);
		} catch (IOException e) {
			log.error("The file could not be read.", e);
		} catch (ClassNotFoundException e) {
			log.error("The specified class could not be found.", e);
		}
	}

	/**
	 * Read time cards.
	 */
	@SuppressWarnings("unchecked")
	private static void readTimeCards() {
		try (FileInputStream fi = new FileInputStream("TimeCardList.ser")) {
			ObjectInputStream os = new ObjectInputStream(fi);
			deserializedTimeCards = (List<TimeCard>) os.readObject();
			os.close();
		} catch (FileNotFoundException e) {
			log.error("The file was not found.", e);
		} catch (IOException e) {
			log.error("The file could not be read.", e);
		} catch (ClassNotFoundException e) {
			log.error("The specified class could not be found.", e);
		}
	}


	/**
	 * Create invoices for the clients from the timecards.
	 *
	 * @param newAccounts the new accounts
	 * @param timeCards            the time cards to create the invoices from
	 * @return the created invoices
	 */
	private static List<Invoice> createInvoices(
			final List<ClientAccount> newAccounts,
			final List<TimeCard> timeCards) {
		final List<TimeCard> timeCardList = TimeCardListUtil
				.getTimeCardsForDateRange(timeCards, new DateRange(
						INVOICE_MONTH, INVOICE_YEAR));
		for (final ClientAccount account : deserializedAccounts) {
			final Invoice invoice = new Invoice(account, INVOICE_MONTH,
					INVOICE_YEAR);
			invoices.add(invoice);
			for (final TimeCard currentTimeCard : timeCardList) {
				invoice.extractLineItems(currentTimeCard);
			}
		}

		return invoices;
	}

	/**
	 * Print the invoice to a PrintStream.
	 *
	 * @param invoices
	 *            the invoices to print
	 * @param out
	 *            The output stream; can be System.out or a text file.
	 */
	private static void printInvoices(final List<Invoice> invoices,
			final PrintStream out) {
		for (final Invoice invoice : invoices) {
			out.println(invoice.toReportString());
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		readClientList();
		readTimeCards();
		System.out.println();
		System.out
				.println("==================================================================================");
		System.out
				.println("=============================== I N V O I C E S ==================================");
		System.out
				.println("==================================================================================");
		System.out.println();
		createInvoices(deserializedAccounts, deserializedTimeCards);
		printInvoices(invoices, System.out);

	}

}
