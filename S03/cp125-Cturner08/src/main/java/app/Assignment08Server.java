package app;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.impl.store.replication.net.SocketConnection;

import com.scg.domain.ClientAccount;
import com.scg.domain.Consultant;
import com.scg.domain.TimeCard;
import com.scg.net.server.CommandProcessor;
import com.scg.net.server.InvoiceServer;
import com.scg.util.ListFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class Assignment08Server.
 */
public final class Assignment08Server {
    /** The listening port. */
	public static final int DEFAULT_PORT = 10888;



	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		final List<ClientAccount> accounts = new ArrayList<ClientAccount>();
		final List<Consultant> consultants = new ArrayList<Consultant>();
		final List<TimeCard> timeCards = new ArrayList<TimeCard>();
		ListFactory.populateLists(accounts, consultants, timeCards);

//		try {
//			ServerSocket sS = new ServerSocket(DEFAULT_PORT);
//			System.out.println("Server ready on port " + DEFAULT_PORT + "...");
//			Socket sock = sS.accept();
//			System.out.println("now we are here!");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
		InvoiceServer iS = new InvoiceServer(DEFAULT_PORT, accounts, consultants);

		iS.run();
//		Socket s = null;
//		try {
//			s = new Socket("127.0.0.1", DEFAULT_PORT);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		//CommandProcessor cP = new CommandProcessor(, accounts, consultants, iS);



	}

}
