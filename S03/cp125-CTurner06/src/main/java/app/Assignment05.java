package app;
import java.io.FileInputStream;
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

/**
 * Assignment 5 application.
 *
 * @author Russ Moul
 */
public final class Assignment05 {
    /** This class' logger. */
    private static Logger logger = LoggerFactory.getLogger(Assignment05.class);

    /** The start month for our test cases. */
    private static final int INVOICE_MONTH = Calendar.MARCH;

    /** The test year. */
    private static final int INVOICE_YEAR = 2006;

    /** The list of clients. */
    private List<ClientAccount> clients;

    /** The list of time cards. */
    private List<TimeCard> timeCards;

    /**
     * Entry point for Assignment05.
     *
     * @param args command line arguments.
     */
    public static void main(final String[] args) {
        final Assignment05 assign = new Assignment05();
        assign.deSerializeLists();
        final List<Invoice> invoices = createInvoices(assign.clients, assign.timeCards);
        printInvoices(invoices, System.out);
    }

    /**
     * Create invoices for the clients from the timecards.
     *
     * @param accounts the accounts to create the invoices for
     * @param timeCards the time cards to create the invoices from
     *
     * @return the created invoices
     */
    private static List<Invoice> createInvoices(final List<ClientAccount> accounts,
                                            final List<TimeCard> timeCards) {
        final List<Invoice> invoices = new ArrayList<Invoice>();

        final List<TimeCard> timeCardList = TimeCardListUtil
                .getTimeCardsForDateRange(timeCards, new DateRange(INVOICE_MONTH, INVOICE_YEAR));
        for (final ClientAccount account : accounts) {
            final Invoice invoice = new Invoice(account, INVOICE_MONTH, INVOICE_YEAR);
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
     * @param invoices the invoices to print
     * @param out The output stream; can be System.out or a text file.
     */
    private static void printInvoices(final List<Invoice> invoices, final PrintStream out) {
        for (final Invoice invoice : invoices) {
            out.println(invoice.toReportString());
        }
    }

    /**
     * De-serialize one object from the specified file.
     */
    private Object deSerializeFile(final String filename) {
    	Object obj = null;
        try ( ObjectInputStream in  = new ObjectInputStream(new FileInputStream(filename)) ) {
        	obj = in.readObject();
        } catch (final ClassNotFoundException ex) {
            logger.error("Input contains unknown types.", ex);
        } catch (final IOException ex) {
            logger.error("Unable to read list.", ex);
        }
        return obj;
    }
    
    /**
     * De-serialize the client, and time card lists.
     */
    public void deSerializeLists() {
        @SuppressWarnings("unchecked")
        final List<ClientAccount> deserClientList = (List<ClientAccount>)deSerializeFile("ClientList.ser");
        clients = deserClientList;
        
        @SuppressWarnings("unchecked")
        final List<TimeCard>deserTimeCards = (List<TimeCard>)deSerializeFile("TimeCardList.ser");
        timeCards = deserTimeCards;
    }
}
