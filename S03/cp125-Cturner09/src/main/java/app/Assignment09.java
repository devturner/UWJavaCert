package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.net.client.InvoiceClient;
import com.scg.util.ListFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Assignment09.
 */
public class Assignment09 {
    /** Localhost. */
    public static final String LOCALHOST = "127.0.0.1";

    /** The Constant DEFAULT_PORT. */
    public static final int DEFAULT_PORT = 10888;

    /**
     * Prevent instantiation.
     */
    private Assignment09() {
    }


//    Thread(Runnable threadObj, String threadName);
//    Where, threadObj is an instance of a class that implements the Runnable interface and threadName is the name given to the new thread.

	/**
 * The main method.
 *
 * @param args the arguments
 * @throws Exception the exception
 */
public static void main(String[] args) throws Exception {
		final List<ClientAccount> accounts = new ArrayList<ClientAccount>();
        final List<Consultant> consultants = new ArrayList<Consultant>();
        final List<TimeCard> timeCards = new ArrayList<TimeCard>();
        ListFactory.populateLists(accounts, consultants, timeCards);

        final List<TimeCard> unmodableTCs = Collections.unmodifiableList(timeCards);

        final InvoiceClient netClient1 = new InvoiceClient(LOCALHOST, DEFAULT_PORT, unmodableTCs);
        Thread t1 = new Thread(netClient1, "thread1");
        t1.start();

        final InvoiceClient netClient2 = new InvoiceClient(LOCALHOST, DEFAULT_PORT, unmodableTCs);
        Thread t2 = new Thread(netClient2, "thread2");
        t2.start();


        final InvoiceClient netClient3 = new InvoiceClient(LOCALHOST, DEFAULT_PORT, unmodableTCs);
        Thread t3 = new Thread(netClient3, "thread3");
        t3.start();


        final InvoiceClient netClient4 = new InvoiceClient(LOCALHOST, DEFAULT_PORT, unmodableTCs);
        Thread t4 = new Thread(netClient4, "thread4");
        t4.start();


        t1.join();
        t2.join();
        t3.join();
        t1.join();
        System.out.println(Thread.activeCount());
      //System.out.println("????");
        // Sent quit command
      InvoiceClient.sendShutdown(Assignment09.LOCALHOST, Assignment09Server.DEFAULT_PORT);

	}

}
