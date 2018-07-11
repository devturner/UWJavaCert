package app;

import java.util.ArrayList;
import java.util.List;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.net.server.InvoiceServer;
import com.scg.util.ListFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Assignment09Server.
 */
public class Assignment09Server {

	/** The port for the server to listen on. */
    public static final int DEFAULT_PORT = 10888;

    /**
     * Prevent instantiation.
     */
    private Assignment09Server() {
    }

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

        final InvoiceServer server = new InvoiceServer(DEFAULT_PORT, accounts, consultants);
        server.run();

	}

}
